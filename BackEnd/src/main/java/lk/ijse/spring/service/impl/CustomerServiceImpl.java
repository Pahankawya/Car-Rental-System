package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.CustomerImageDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper mapper;


    @Override
    public void saveCustomer(CustomerDTO customerDTO) throws RuntimeException {

        if (customerRepo.existsById(customerDTO.getNic())) throw new RuntimeException("Customer Already Exits..!");
        customerDTO.getUser().setRole("Customer");
        customerRepo.save(mapper.map(customerDTO, Customer.class));

    }

    @Override
    public List<CustomerDTO> getAllCustomer() throws RuntimeException {
        return mapper.map(customerRepo.findAll(), new TypeToken<ArrayList<CustomerDTO>>() {
        }.getType());

    }

    @Override
    public void saveImages(String nic, CustomerImageDTO imageDTO) throws RuntimeException {

        Customer customer = customerRepo.findById(nic).get();

        try {
            if (imageDTO.getLicenseImage() != null && imageDTO.getNicImage() != null) {

            // Get the byte arrays representing the NIC and license images from the DTO.
                byte[] nicFileBytes = imageDTO.getNicImage().getBytes();
                byte[] licenseFileBytes = imageDTO.getLicenseImage().getBytes();

                String projectPath = "D:\\Dev\\Java\\My_Projects\\Car_Rental_System\\Front_End\\assets";

            // Construct paths for saving the NIC and license images, including the filename based on the 'nic'.
                Path nicLocation = Paths.get(projectPath + "/image/bucket/customer/nic/nic_" + nic + ".jpeg");
                Path licenseLocation = Paths.get(projectPath + "/image/bucket/customer/license/license_" + nic + ".jpeg");

            // Write the NIC and license image bytes to their respective locations on the filesystem.
                Files.write(nicLocation, nicFileBytes);
                Files.write(licenseLocation, licenseFileBytes);

            // Transfer the uploaded images to the specified locations
                imageDTO.getNicImage().transferTo(nicLocation);
                imageDTO.getLicenseImage().transferTo(licenseLocation);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    // Update the customer object with the paths to the NIC and license images
        customer.setNicImage("/assets/image/bucket/customer/nic/nic_" + nic + ".jpeg");
        customer.setLicenseImage("/assets/image/bucket/customer/license/license_" + nic + ".jpeg");

        customer.getUser().setRole("Customer");
        customerRepo.save(customer);

    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) throws RuntimeException {
        if (!customerRepo.existsById(customerDTO.getNic())) throw new RuntimeException("Invalid Customer..!");
        Customer customer = mapper.map(customerDTO, Customer.class);
        Customer customer1 = customerRepo.findById(customerDTO.getNic()).get();
        customer.setLicenseImage(customer1.getLicenseImage());
        customer.setNicImage(customer1.getNicImage());
        customer.getUser().setRole("Customer");
        customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(String nic) throws RuntimeException {
        if (!customerRepo.existsById(nic)) throw new RuntimeException("Invalid Customer..!");
        customerRepo.deleteById(nic);
    }

    @Override
    public Long countCustomers() throws RuntimeException {
        return customerRepo.countCustomerByNic();
    }
}
