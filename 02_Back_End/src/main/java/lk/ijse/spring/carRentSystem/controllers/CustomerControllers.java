package lk.ijse.spring.carRentSystem.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerControllers {
    public CustomerControllers() {
        System.out.println("Customer");
    }

    @GetMapping
    public String saveCustomer(){
        return "save";
    }
}
