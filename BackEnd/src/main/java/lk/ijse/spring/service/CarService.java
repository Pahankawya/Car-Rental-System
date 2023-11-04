package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarAllDTO;
import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.CarImageDTO;

import java.util.List;

public interface CarService {
    public void saveCar(CarDTO carDTO) throws RuntimeException;

    public List<CarDTO> getAllCars() throws RuntimeException;

    public void saveCarImages(CarImageDTO carImageDTO) throws RuntimeException;

    public void addToMaintains(String regNum) throws RuntimeException;

    public CarAllDTO getCar(String regNum) throws RuntimeException;

    public Long countAvailableCars() throws RuntimeException;

    public Long countReservedCars() throws RuntimeException;

    public void updateCar(CarDTO carDTO) throws  RuntimeException;

    public void deleteCar(String regNum) throws RuntimeException;

    public List<CarAllDTO> filterCarsByRegNum(String text, String search, String fuel) throws RuntimeException;

    public List countCarsByBrand() throws RuntimeException;

    public Long countMaintainingCars() throws RuntimeException;
}
