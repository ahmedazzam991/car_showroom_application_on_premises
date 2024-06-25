package com.example.carservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CarServiceApplication {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);
    }

    @PostConstruct
    public void printDbUrl() {
        System.out.println("Database URL: " + dbUrl);
    }
}

