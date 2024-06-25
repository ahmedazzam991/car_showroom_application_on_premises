package com.example.carservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    @GetMapping("/cars")
    public List<Map<String, Object>> getAllFromCars() {
        return databaseService.getAllFromCars();
    }

    @GetMapping("/car")
    public List<Map<String, Object>> getAllFromCar() {
        return databaseService.getAllFromCar();
    }

    @PostMapping("/cars")
    public void addDataToCars(@RequestBody Map<String, Object> data) {
        databaseService.addDataToCars(data);
    }

    @PostMapping("/car")
    public void addDataToCar(@RequestBody Map<String, Object> data) {
        databaseService.addDataToCar(data);
    }

    @PutMapping("/cars/{id}")
    public void updateDataInCars(@PathVariable String id, @RequestBody Map<String, Object> data) {
        databaseService.updateDataInCars("id", id, data);
    }

    @PutMapping("/car/{id}")
    public void updateDataInCar(@PathVariable String id, @RequestBody Map<String, Object> data) {
        databaseService.updateDataInCar("id", id, data);
    }

    @DeleteMapping("/cars/{id}")
    public void deleteDataFromCars(@PathVariable String id) {
        databaseService.deleteDataFromCars("id", id);
    }

    @DeleteMapping("/car/{id}")
    public void deleteDataFromCar(@PathVariable String id) {
        databaseService.deleteDataFromCar("id", id);
    }
}

