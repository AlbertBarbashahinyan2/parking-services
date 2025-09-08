package org.example.parkingservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ParkingServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingServicesApplication.class, args);
    }

}
