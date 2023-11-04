package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.CustomerImageDTO;

import java.util.List;

public interface CustomerService {
    public void saveCustomer(CustomerDTO customerDTO) throws RuntimeException;

    public List<CustomerDTO> getAllCustomer() throws RuntimeException;

    public void saveImages(String nic, CustomerImageDTO imageDTO) throws RuntimeException;

    public void updateCustomer(CustomerDTO customerDTO) throws RuntimeException;

    public void deleteCustomer(String nic) throws RuntimeException;

    public Long countCustomers() throws RuntimeException;
}
