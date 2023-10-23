package lk.ijse.carRentSystem.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"lk.ijse.carRentSystem.controllers"})
public class WebAppConfig {
    public WebAppConfig() {
        System.out.println("WebAppConfig");
    }
}
