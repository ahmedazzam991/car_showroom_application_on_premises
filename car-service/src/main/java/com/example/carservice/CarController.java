package com.example.carservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private DatabaseService databaseService;

    @GetMapping
    public List<Map<String, Object>> getAllCars() {
        List<Map<String, Object>> carData = databaseService.getAllFromCar();
        List<Map<String, Object>> carsData = databaseService.getAllFromCars();

        List<Map<String, Object>> combinedData = new ArrayList<>();
        combinedData.addAll(carData);
        combinedData.addAll(carsData);

        return combinedData;
    }

    @GetMapping("/search")
    public List<Car> searchCars(@RequestParam String make, @RequestParam String model) {
        return carRepository.findByMakeContainingIgnoreCaseAndModelContainingIgnoreCase(make, model);
    }
}

