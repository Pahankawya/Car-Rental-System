package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarAllDTO;
import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.CarImageDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.repo.RentDetailsRepo;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.util.ImagePathWriterUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    CarRepo carRepo;

    @Autowired
    RentDetailsRepo rentDetailsRepo; // Interface orientation through loose coupling promote

    @Override
    public void saveCar(CarDTO carDTO) throws RuntimeException {

        if (carRepo.existsById(carDTO.getRegNum())) throw new RuntimeException("Car Already Exist..!");

        Car car = mapper.map(carDTO, Car.class);
        try {
            // Write and set the front image for the car
            car.getPhotos().setFront(new ImagePathWriterUtil().writeImage(carDTO.getPhotos().getFront(), Paths.get(ImagePathWriterUtil.projectPath + "/image/bucket/car/front_" + carDTO.getRegNum() + ".jpeg")));
            car.getPhotos().setBack(new ImagePathWriterUtil().writeImage(carDTO.getPhotos().getBack(), Paths.get(ImagePathWriterUtil.projectPath + "/image/bucket/car/back_" + carDTO.getRegNum() + ".jpeg")));
            car.getPhotos().setSide(new ImagePathWriterUtil().writeImage(carDTO.getPhotos().getSide(), Paths.get(ImagePathWriterUtil.projectPath + "/image/bucket/car/side_" + carDTO.getRegNum() + ".jpeg")));
            car.getPhotos().setInterior(new ImagePathWriterUtil().writeImage(carDTO.getPhotos().getInterior(), Paths.get(ImagePathWriterUtil.projectPath + "/image/bucket/car/interior_" + carDTO.getRegNum() + ".jpeg")));

            carRepo.save(car);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public List<CarDTO> getAllCars() throws RuntimeException {
        return mapper.map(carRepo.findAll(), new TypeToken<ArrayList<CarAllDTO>>() {
        }.getType());
    }

    @Override
    public void saveCarImages(CarImageDTO carImageDTO) throws RuntimeException {

    }

    @Override
    public void addToMaintains(String regNum) throws RuntimeException {
        Car car = carRepo.findCarByRegNum(regNum);
        car.setAvailability(car.getAvailability().equals("YES") ? "NO" : "YES");

        carRepo.save(car);
    }

    @Override
    public CarAllDTO getCar(String regNum) throws RuntimeException {
        return mapper.map(carRepo.findById(regNum), CarAllDTO.class);
    }

    @Override
    public Long countAvailableCars() throws RuntimeException {
        return carRepo.countAvailableCars();
    }

    @Override
    public Long countReservedCars() throws RuntimeException {
        return carRepo.countReservedCars();
    }

    @Override
    public void updateCar(CarDTO carDTO) throws RuntimeException {
        if (!carRepo.existsById(carDTO.getRegNum())) throw new RuntimeException("Car Doesn't Exist..!");

        Car car1 = carRepo.findById(carDTO.getRegNum()).get();

        Car car = mapper.map(carDTO, Car.class);

        car.setPhotos(car1.getPhotos());

        carRepo.save(car);
    }

    @Override
    public void deleteCar(String regNum) throws RuntimeException {

        if (!carRepo.existsById(regNum)) throw new RuntimeException("Car Doesn't Exist..!");

        rentDetailsRepo.deleteRentDetailByRegNum(regNum);



        carRepo.deleteById(regNum);
    }

    @Override
    public List<CarAllDTO> filterCarsByRegNum(String text, String search, String fuel) throws RuntimeException {
        fuel = fuel.equals("ALL") ? "" : fuel;

        switch (search) {
            case "REG_NUM":
                return mapper.map(carRepo.findByRegNumLikeAndFuelTypeLike("%" + text + "%", "%"+fuel+"%"), new TypeToken<ArrayList<CarAllDTO>>() {
                }.getType());

            case "BRAND":
                return mapper.map(carRepo.findByBrandLikeAndFuelTypeLike("%" + text + "%", "%"+fuel+"%"), new TypeToken<ArrayList<CarAllDTO>>() {
                }.getType());

            case "COLOR":
                return mapper.map(carRepo.findByColorLikeAndFuelTypeLike("%" + text + "%", "%"+fuel+"%"), new TypeToken<ArrayList<CarAllDTO>>() {
                }.getType());

            default:
                return null;

        }
    }

    @Override
    public List countCarsByBrand() throws RuntimeException {
        return carRepo.countCarBrands();
    }

    @Override
    public Long countMaintainingCars() throws RuntimeException {
        return carRepo.countMaintainingCars();
    }
}
