package com.example.carshowroomfrontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/health")
    public String healthCheck() {
        try {
            jdbcTemplate.execute("SELECT 1");
            return "Database Connection is OK";
        } catch (Exception e) {
            return "Database Connection Failed: " + e.getMessage();
        }
    }
}

