package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.RentDTO;
import lk.ijse.spring.dto.RentDetailsDTO;

import java.util.List;

public interface RentService {
    public void requestRent(RentDTO rentDTO) throws RuntimeException;

    public String generateNewRentId() throws RuntimeException;

    public CustomerDTO getCustomerByUsername(String username) throws RuntimeException;

    public List<RentDTO> getAllRents() throws RuntimeException;

    public void acceptRentRequest(String rentId, String option) throws RuntimeException;

    public RentDTO getRentByRentId(String rentId) throws RuntimeException;

    public List<RentDetailsDTO> getDriverSchedule(String nic) throws RuntimeException;

    public List<RentDTO> getRentByNic(String nic) throws RuntimeException;

    public Long countRents() throws RuntimeException;
}
