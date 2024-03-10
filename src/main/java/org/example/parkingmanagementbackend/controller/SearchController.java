package org.example.parkingmanagementbackend.controller;

import org.example.parkingmanagementbackend.model.Vehicle;
import org.example.parkingmanagementbackend.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
@RequestMapping("search")
public class SearchController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("car/{carNumber}")
    public Optional<Vehicle> findCarByNumber(@PathVariable("carNumber") String carNumber){
        return vehicleRepository.findById(carNumber);
    }
}
