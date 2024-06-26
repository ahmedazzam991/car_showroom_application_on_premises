// src/main/java/com/example/yourapp/ProfileLogger.java
package com.example.carshowroomfrontend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProfileLogger implements CommandLineRunner {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Active Spring Boot Profile: " + activeProfile);
    }
}

