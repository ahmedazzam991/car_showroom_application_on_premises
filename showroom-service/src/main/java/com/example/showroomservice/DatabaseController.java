package com.example.showroomservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    @GetMapping("/showrooms")
    public List<Map<String, Object>> getAllFromShowrooms() {
        return databaseService.getAllFromShowrooms();
    }

    @GetMapping("/showroom")
    public List<Map<String, Object>> getAllFromShowroom() {
        return databaseService.getAllFromShowroom();
    }

    @PostMapping("/showrooms")
    public void addDataToShowrooms(@RequestBody Map<String, Object> data) {
        databaseService.addDataToShowrooms(data);
    }

    @PostMapping("/showroom")
    public void addDataToShowroom(@RequestBody Map<String, Object> data) {
        databaseService.addDataToShowroom(data);
    }

    @PutMapping("/showrooms/{id}")
    public void updateDataInShowrooms(@PathVariable String id, @RequestBody Map<String, Object> data) {
        databaseService.updateDataInShowrooms("id", id, data);
    }

    @PutMapping("/showroom/{id}")
    public void updateDataInShowroom(@PathVariable String id, @RequestBody Map<String, Object> data) {
        databaseService.updateDataInShowroom("id", id, data);
    }

    @DeleteMapping("/showrooms/{id}")
    public void deleteDataFromShowrooms(@PathVariable String id) {
        databaseService.deleteDataFromShowrooms("id", id);
    }

    @DeleteMapping("/showroom/{id}")
    public void deleteDataFromShowroom(@PathVariable String id) {
        databaseService.deleteDataFromShowroom("id", id);
    }
}

