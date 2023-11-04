package lk.ijse.spring.controller;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.service.RentService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
@CrossOrigin
public class DriverController {
    @Autowired
    DriverService driverService;

    @Autowired
    RentService rentService;

    @PostMapping
    public ResponseUtil saveDriver(@RequestParam String username, @RequestParam String password, @ModelAttribute DriverDTO driverDTO) {

        driverDTO.setUser(new UserDTO(username, password, "Driver"));
        driverService.saveDriver(driverDTO);
        return new ResponseUtil("OK", "Successfully Saved..!", "");

    }

    @GetMapping
    public ResponseUtil getCurrentDriver() {

        return new ResponseUtil("OK", "Successfully Loaded..!", driverService.getDriver());

    }

    @GetMapping(params = {"nic"})
    public ResponseUtil getDriverSchedule(String nic) {

        return new ResponseUtil("OK", "Successfully Loaded..!", rentService.getDriverSchedule(nic));

    }

    @GetMapping(path = "/all")
    public ResponseUtil getAll() {

        return new ResponseUtil("OK", "Successfully Loaded..!", driverService.getAllDrivers());

    }

    @PostMapping(path = "/update")
    public ResponseUtil updateDriver(@RequestParam String username, @RequestParam String password, @ModelAttribute DriverDTO driverDTO) {

        driverDTO.setUser(new UserDTO(username, password, "Driver"));
        driverService.updateDriver(driverDTO);
        return new ResponseUtil("OK", "Successfully Updated..!", "");

    }

    @DeleteMapping
    public ResponseUtil deleteDriver(String nic){

        driverService.deleteDriver(nic);
        return new ResponseUtil("OK", "Successfully Deleted..!", "");

    }

    @GetMapping(path = "/available")
    public ResponseUtil availableDrivers() {

        return new ResponseUtil("OK", "Successfully Loaded..!", driverService.countAvailableDrivers());

    }

    @GetMapping(path = "/reserved")
    public ResponseUtil reservedDrivers() {

        return new ResponseUtil("OK", "Successfully Loaded..!", driverService.countReservedDrivers());

    }
}
