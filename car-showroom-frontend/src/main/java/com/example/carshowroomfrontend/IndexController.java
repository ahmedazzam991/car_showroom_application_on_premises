package com.example.carshowroomfrontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = Logger.getLogger(IndexController.class.getName());

    @GetMapping("/")
    public String index(Model model) {
        ResponseEntity<List<Car>> carResponse = restTemplate.exchange(
            "http://car-service/cars",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Car>>() {}
        );

        ResponseEntity<List<Showroom>> showroomResponse = restTemplate.exchange(
            "http://showroom-service/showrooms",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Showroom>>() {}
        );

        List<Car> cars = carResponse.getBody();
        List<Showroom> showrooms = showroomResponse.getBody();

        logger.info("Cars: " + cars);
        logger.info("Showrooms: " + showrooms);

        model.addAttribute("cars", cars);
        model.addAttribute("showrooms", showrooms);
        model.addAttribute("search", new SearchForm());
        model.addAttribute("searchResults", null);
        model.addAttribute("price", null);

        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam String make, @RequestParam String model, Model modelAttr) {
        ResponseEntity<List<Car>> searchResponse = restTemplate.exchange(
            "http://car-service/cars/search?make=" + make + "&model=" + model,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Car>>() {}
        );

        List<Car> searchResults = searchResponse.getBody();

        modelAttr.addAttribute("cars", restTemplate.exchange(
            "http://car-service/cars",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Car>>() {}
        ).getBody());

        modelAttr.addAttribute("showrooms", restTemplate.exchange(
            "http://showroom-service/showrooms",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Showroom>>() {}
        ).getBody());

        modelAttr.addAttribute("search", new SearchForm(make, model));
        modelAttr.addAttribute("searchResults", searchResults);

        if (searchResults != null && !searchResults.isEmpty()) {
            modelAttr.addAttribute("price", searchResults.get(0).getPrice());
        } else {
            modelAttr.addAttribute("price", "Car not found");
        }

        return "index";
    }
}

