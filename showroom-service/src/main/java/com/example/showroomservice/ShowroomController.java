package com.example.showroomservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/showrooms")
public class ShowroomController {

    @Autowired
    private ShowroomRepository showroomRepository;

    @Autowired
    private DatabaseService databaseService;

    @GetMapping
    public List<Map<String, Object>> getAllShowrooms() {
        List<Map<String, Object>> showroomData = databaseService.getAllFromShowroom();
        List<Map<String, Object>> showroomsData = databaseService.getAllFromShowrooms();

        List<Map<String, Object>> combinedData = new ArrayList<>();
        combinedData.addAll(showroomData);
        combinedData.addAll(showroomsData);

        return combinedData;
    }
}

