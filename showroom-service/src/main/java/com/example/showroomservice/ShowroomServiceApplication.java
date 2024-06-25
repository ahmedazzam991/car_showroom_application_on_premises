package com.example.showroomservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ShowroomServiceApplication {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    public static void main(String[] args) {
        SpringApplication.run(ShowroomServiceApplication.class, args);
    }

    @PostConstruct
    public void printDbUrl() {
        System.out.println("Database URL: " + dbUrl);
    }
}

