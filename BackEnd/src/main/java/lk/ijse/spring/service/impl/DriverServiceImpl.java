package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DriverAllDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.util.UserUtil;
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
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO driverDTO) throws RuntimeException {

        Driver driver = mapper.map(driverDTO, Driver.class);

        if (driverRepo.existsById(driverDTO.getNic())) throw new RuntimeException("Customer Already Exits..!");
        try {
            if (driverDTO.getLicenseImage().getBytes() != null) {

                byte[] licenseFileBytes = driverDTO.getLicenseImage().getBytes();

                String projectPath = "D:\\Dev\\Java\\My_Projects\\Car_Rental_System\\Front_End\\assets";
                Path licenseLocation = Paths.get(projectPath + "/image/bucket/driver/license_" + driver.getNic() + ".jpeg");

                Files.write(licenseLocation, licenseFileBytes);

                driverDTO.getLicenseImage().transferTo(licenseLocation);

                driver.setLicenseImage("/image/bucket/driver/license_" + driver.getNic() + ".jpeg");

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver.setAvailabilityStatus("YES");
        driver.getUser().setRole("Driver");

        driverRepo.save(driver);

    }

    @Override
    public void updateDriver(DriverDTO driverDTO) throws RuntimeException {

        Driver driver = mapper.map(driverDTO, Driver.class);

        if (!driverRepo.existsById(driverDTO.getNic())) throw new RuntimeException("Invalid Driver..!");

        Driver driver1 = driverRepo.findById(driverDTO.getNic()).get();

        driver.setLicenseImage(driver1.getLicenseImage());

        driver.setAvailabilityStatus("YES");

        driver.getUser().setRole("Driver");

        driverRepo.save(driver);

    }

    @Override
    public DriverDTO getDriver() throws RuntimeException {
        return mapper.map(driverRepo.getDriverByUsername(UserUtil.currentUser.getUsername()), DriverDTO.class);
    }

    @Override
    public List<DriverDTO> getAllDrivers() throws RuntimeException {
        return mapper.map(driverRepo.findAll(), new TypeToken<ArrayList<DriverAllDTO>>() {
        }.getType());
    }

    @Override
    public void deleteDriver(String nic) throws RuntimeException {
        if (!driverRepo.existsById(nic)) throw new RuntimeException("Invalid Driver..!");
        driverRepo.deleteById(nic);
    }

    @Override
    public Long countAvailableDrivers() throws RuntimeException {
        return driverRepo.countAvailableDrivers();
    }

    @Override
    public Long countReservedDrivers() throws RuntimeException {
        return driverRepo.countReservedDrivers();
    }
}
