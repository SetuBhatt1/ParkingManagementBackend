package org.example.parkingmanagementbackend.controller;

import org.example.parkingmanagementbackend.model.Vehicle;
import org.example.parkingmanagementbackend.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
@RequestMapping("vehicle")
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;

    @PostMapping("add")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        // https://f6a2-150-129-170-239.ngrok-free.app/vehicle/add
        return vehicleRepository.save(vehicle);
//        return vehicleRepository.addVehicle(vehicle);
    }

    @GetMapping("read")
    public List<Vehicle> readVehicle() {
        // https://f6a2-150-129-170-239.ngrok-free.app/vehicle/read
        return vehicleRepository.findAll();
    }

    @DeleteMapping("remove/{vehicleNumber}")
    public void removeVehicle(@PathVariable("vehicleNumber") String vehicleNumber ) {
        // https://f6a2-150-129-170-239.ngrok-free.app/vehicle/read
        vehicleRepository.deleteById(vehicleNumber);
    }
}
