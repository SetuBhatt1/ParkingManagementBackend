package org.example.parkingmanagementbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class ParkingManagementBackendApplication {
    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(ParkingManagementBackendApplication.class, args);
    }
}
