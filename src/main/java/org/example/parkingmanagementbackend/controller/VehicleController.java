package org.example.parkingmanagementbackend.controller;

import org.example.parkingmanagementbackend.model.Vehicle;
import org.example.parkingmanagementbackend.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RestController
@RequestMapping("/api")
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;

    @PostMapping("/vehicles")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        // https://f6a2-150-129-170-239.ngrok-free.app/vehicle/add
        return vehicleRepository.save(vehicle);
//        return vehicleRepository.addVehicle(vehicle);
    }

    @GetMapping("/vehicles")
    public List<Vehicle> readVehicle() {
        // https://f6a2-150-129-170-239.ngrok-free.app/vehicle/read
        return vehicleRepository.findAll();
    }

    @GetMapping("/vehicles/search")
    public ResponseEntity<List<Vehicle>> searchVehicles(@RequestParam String vehicleNumber) {
        List<Vehicle> vehicles = vehicleRepository.findByVehicleNumber(vehicleNumber);
        if (vehicles.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(vehicles);
        }
    }
    @DeleteMapping("/vehicles/{vehicleNumber}")
    public void removeVehicle(@PathVariable("vehicleNumber") String vehicleNumber ) {
        // https://f6a2-150-129-170-239.ngrok-free.app/vehicle/read
        vehicleRepository.deleteById(vehicleNumber);
    }

    @PatchMapping("/vehicles/{vehicleNumber}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable("vehicleNumber") String vehicleNumber) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleNumber);

        if (optionalVehicle.isPresent()) {
            Vehicle existingVehicle = optionalVehicle.get();
            existingVehicle.setExitTime(new Date());

            Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);
            return ResponseEntity.ok(updatedVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
