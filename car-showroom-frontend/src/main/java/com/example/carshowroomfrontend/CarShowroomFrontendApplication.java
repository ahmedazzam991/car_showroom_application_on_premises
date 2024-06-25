package com.example.carshowroomfrontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarShowroomFrontendApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarShowroomFrontendApplication.class, args);
    }
}

