package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.RentDTO;
import lk.ijse.spring.dto.RentDetailsDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.entity.Rent;
import lk.ijse.spring.entity.RentDetails;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.RentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class RentServiceImpl implements RentService {

    @Autowired
    RentRepo rentRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    RentDetailsRepo rentDetailsRepo;

    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void requestRent(RentDTO rentDTO) throws RuntimeException {

        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Rent rent;
        rent = mapper.map(rentDTO, Rent.class);

        System.out.println(rent);

        if (rentDTO.getDriverRequest().equals("YES")) {

            List<Driver> drivers = driverRepo.getAvailableDrivers();
            int i;

            for (RentDetails rentDetails : rent.getRentDetails()) {

                i = new Random().nextInt(drivers.size());
                rentDetails.setNic(drivers.get(i).getNic());
//                Car car = carRepo.findById(rentDetails.getRegNum()).get();
//                car.setAvailability("NO");
//
//                carRepo.save(car);

                drivers.get(i).setAvailabilityStatus("NO");
                driverRepo.save(drivers.get(i));
            }

        }

        for (RentDetails rentDetail : rent.getRentDetails()) {
            Car car1 = carRepo.findCarByRegNum(rentDetail.getRegNum());
            car1.setAvailability("NO");
            carRepo.save(car1);
        }

        rentRepo.save(rent);

    }

    @Override
    public String generateNewRentId() throws RuntimeException {
        String lastRentId = rentRepo.getLastRentId();
        return lastRentId != null ? String.format("RID-%03d", (Integer.parseInt(lastRentId.replace("RID-", "")) + 1)) : "RID-001";
    }

    @Override
    public CustomerDTO getCustomerByUsername(String username) throws RuntimeException {
        return mapper.map(customerRepo.getCustomerByUsername(username), CustomerDTO.class);
    }

    @Override
    public List<RentDTO> getAllRents() throws RuntimeException {
        return mapper.map(rentRepo.findAll(), new TypeToken<ArrayList<RentDTO>>() {
        }.getType());
    }

    @Override
    public void acceptRentRequest(String rentId, String option) throws RuntimeException {
        Rent rent = rentRepo.findById(rentId).get();

        if (option.equals("accepted")) {
            rent.setStatus("Accepted");
            rent.setDescription("Rent Accepted on " + LocalDate.now() + " " + LocalTime.now());
        } else if (option.equals("reject")) {
            rent.setStatus("Rejected");
            for (RentDetails rentDetails : rent.getRentDetails()) {
                if (rentDetails.getDriver()!=null){
                    rentDetails.getDriver().setAvailabilityStatus("YES");
                    rentDetails.getCar().setAvailability("YES");
                }
            }
            rent.setDescription("Rent Rejected on " + LocalDate.now() + " " + LocalTime.now());
        } else {
            rent.setStatus("Closed");
            for (RentDetails rentDetails : rent.getRentDetails()) {
                if (rentDetails.getDriver()!=null){
                    rentDetails.getDriver().setAvailabilityStatus("YES");
                    rentDetails.getCar().setAvailability("MAINTAIN");
                }
            }
            rent.setDescription("Rent Closed on " + LocalDate.now() + " " + LocalTime.now());
        }

        rentRepo.save(rent);
    }

    @Override
    public RentDTO getRentByRentId(String rentId) throws RuntimeException {
        return mapper.map(rentRepo.findById(rentId), RentDTO.class);
    }

    @Override
    public List<RentDetailsDTO> getDriverSchedule(String nic) throws RuntimeException {
        return mapper.map(rentDetailsRepo.getRentDetailByNic(nic), new TypeToken<ArrayList<RentDetailsDTO>>() {
        }.getType());
    }

    @Override
    public List<RentDTO> getRentByNic(String nic) throws RuntimeException {
        return mapper.map(rentRepo.getRentsByNic_Nic(nic), new TypeToken<ArrayList<RentDTO>>() {
        }.getType());

    }

    @Override
    public Long countRents() throws RuntimeException {

        return rentRepo.countBookings();

    }
}
