package lk.ijse.spring.service;

import lk.ijse.spring.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    public void saveDriver(DriverDTO driverDTO) throws RuntimeException;

    public void updateDriver(DriverDTO driverDTO) throws RuntimeException;

    public DriverDTO getDriver() throws RuntimeException;

    public List<DriverDTO> getAllDrivers() throws RuntimeException;

    public void deleteDriver(String nic) throws RuntimeException;

    public Long countAvailableDrivers() throws RuntimeException;

    public Long countReservedDrivers() throws RuntimeException;
}
