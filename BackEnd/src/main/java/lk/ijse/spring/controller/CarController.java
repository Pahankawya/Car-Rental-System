package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.CarImageDTO;
import lk.ijse.spring.embeddable.FreeMileage;
import lk.ijse.spring.embeddable.Price;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {
    @Autowired
    CarService carService;

    @PostMapping
    public ResponseUtil saveCar(@ModelAttribute CarImageDTO carImageDTO, @ModelAttribute Price price, @ModelAttribute FreeMileage freeMileage, @ModelAttribute CarDTO carDTO) {

        carDTO.setPhotos(carImageDTO);
        carDTO.setPrice(price);
        carDTO.setFreeMileage(freeMileage);

        carService.saveCar(carDTO);

        return new ResponseUtil("OK", "Successfully Saved..!", "");

    }

    @GetMapping
    public ResponseUtil getAll() {

        return new ResponseUtil("OK", "Successfully Loaded..!", carService.getAllCars());

    }

    @PostMapping(path = "/image")
    public ResponseUtil saveImages(@ModelAttribute CarImageDTO carImageDTO) {

        carService.saveCarImages(carImageDTO);
        return new ResponseUtil("OK", "Successfully Saved..!", "");

    }

    @PutMapping(params = {"regNum"})
    public ResponseUtil addToMaintains(@RequestParam String regNum) {

        carService.addToMaintains(regNum);
        return new ResponseUtil("OK", "Successfully Saved..!", "");

    }

    @GetMapping(params = {"regNum"})
    public ResponseUtil getCar(@RequestParam String regNum) {

        return new ResponseUtil("OK", "Successfully Loaded..!", carService.getCar(regNum));

    }

    @GetMapping(path = "/count")
    public ResponseUtil countAvailableCars() {

        return new ResponseUtil("OK", "Successfully Loaded..!", carService.countAvailableCars());

    }

    @GetMapping(path = "/count/reserved")
    public ResponseUtil countReservedCars() {

        return new ResponseUtil("OK", "Successfully Loaded..!", carService.countReservedCars());

    }

    @PostMapping(path = "/update")
    public ResponseUtil updateCar(@ModelAttribute CarImageDTO carImageDTO, @ModelAttribute Price price, @ModelAttribute FreeMileage freeMileage, @ModelAttribute CarDTO carDTO) {

        carDTO.setPhotos(carImageDTO);
        carDTO.setPrice(price);
        carDTO.setFreeMileage(freeMileage);

        carService.updateCar(carDTO);

        return new ResponseUtil("OK", "Successfully Loaded..!", "");

    }

    @DeleteMapping
    public ResponseUtil deleteCar(@RequestParam String regNum) {

        carService.deleteCar(regNum);
        return new ResponseUtil("OK", "Successfully Deleted..!", "");

    }

    @GetMapping(path = "/filterByRegNum")
    public ResponseUtil filterByRegNum(@RequestParam String text, @RequestParam String search, @RequestParam String fuel) {

        return new ResponseUtil("OK", "Successfully Deleted..!", carService.filterCarsByRegNum(text, search, fuel));

    }

    @GetMapping(path = "/brand")
    public ResponseUtil countCarsByBrand() {

        return new ResponseUtil("OK", "Successfully Loaded..!", carService.countCarsByBrand());

    }

    @GetMapping(path = "/count/maintain")
    public ResponseUtil countMaintainingCars() {

        return new ResponseUtil("OK", "Successfully Loaded..!", carService.countMaintainingCars());

    }

}
