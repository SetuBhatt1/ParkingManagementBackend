package org.example.parkingmanagementbackend.controller;

import org.example.parkingmanagementbackend.model.PermanentVehicle;
import org.example.parkingmanagementbackend.model.Vehicle;
import org.example.parkingmanagementbackend.repository.PermanentVehicleRepository;
import org.example.parkingmanagementbackend.repository.VehicleRepository;
import org.example.parkingmanagementbackend.service.FirebaseAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private FirebaseAuthService firebaseAuthService;

    @Autowired
    private PermanentVehicleRepository permanentVehicleRepository;


    @PostMapping("/vehicles")
    public ResponseEntity<Vehicle> addVehicle(@RequestHeader("Authorization") String idToken, @RequestBody Vehicle vehicle) {
        try {
            firebaseAuthService.verifyIdToken(idToken.replace("Bearer ", ""));
            return ResponseEntity.ok(vehicleRepository.save(vehicle));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<Vehicle>> readVehicle(@RequestHeader("Authorization") String idToken) {
        try {
            firebaseAuthService.verifyIdToken(idToken.replace("Bearer ", ""));
            List<Vehicle> vehicles = vehicleRepository.findAll();
            return ResponseEntity.ok(vehicles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @GetMapping("/vehicles/search")
    public ResponseEntity<List<Vehicle>> searchVehicles(@RequestHeader("Authorization") String idToken, @RequestParam String vehicleNumber) {
        try {
            firebaseAuthService.verifyIdToken(idToken.replace("Bearer ", ""));
            List<Vehicle> vehicles = vehicleRepository.findByVehicleNumber(vehicleNumber);
            if (vehicles.isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(vehicles);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @GetMapping("/vehicles/sort")
    public ResponseEntity<List<Vehicle>> sortVehicle(@RequestHeader("Authorization") String idToken, @RequestParam String sortBy) {
        try {
            firebaseAuthService.verifyIdToken(idToken.replace("Bearer ", ""));
            List<Vehicle> vehicles = vehicleRepository.findAll(Sort.by(sortBy));
            return ResponseEntity.ok(vehicles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

//    @DeleteMapping("/vehicles/{vehicleNumber}")
//    public ResponseEntity<Void> removeVehicle(@RequestHeader("Authorization") String idToken, @PathVariable("vehicleNumber") String vehicleNumber) {
//        try {
//            firebaseAuthService.verifyIdToken(idToken.replace("Bearer ", ""));
//            vehicleRepository.deleteById(vehicleNumber);
//            return ResponseEntity.noContent().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
//        }
//    }




    @DeleteMapping("/vehicles/{vehicleNumber}")
    public ResponseEntity<Void> removeVehicle(@RequestHeader("Authorization") String idToken, @PathVariable("vehicleNumber") String vehicleNumber) {
        try {
            firebaseAuthService.verifyIdToken(idToken.replace("Bearer ", ""));
            Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleNumber);

            if (optionalVehicle.isPresent()) {
                Vehicle vehicle = optionalVehicle.get();
                // Update the exit time of the vehicle
                vehicle.setExitTime(new Date());
                // Save the updated vehicle to the database
                vehicleRepository.save(vehicle);

                // Create a new PermanentVehicle instance and copy data from the Vehicle
                PermanentVehicle permanentVehicle = new PermanentVehicle();
                // Explicitly set the entryTime to ensure it's copied over correctly
                permanentVehicle.setEntryTime(vehicle.getEntryTime()); // This line ensures the entryTime is copied over
//                permanentVehicle.setExitTime(vehicle.getExitTime()); // This line ensures the exitTime is updated
                permanentVehicle.setVehicleNumber(vehicle.getVehicleNumber());
                permanentVehicle.setSlot(vehicle.getSlot());
                permanentVehicle.setFloor(vehicle.getFloor());

                // Save the PermanentVehicle instance
                permanentVehicleRepository.save(permanentVehicle);

                // Delete the Vehicle instance
                vehicleRepository.deleteById(vehicleNumber);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


    @PatchMapping("/vehicles/{vehicleNumber}")
    public ResponseEntity<Vehicle> updateVehicle(@RequestHeader("Authorization") String idToken, @PathVariable("vehicleNumber") String vehicleNumber) {
        try {
            firebaseAuthService.verifyIdToken(idToken.replace("Bearer ", ""));
            Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleNumber);

            if (optionalVehicle.isPresent()) {
                Vehicle existingVehicle = optionalVehicle.get();
                existingVehicle.setExitTime(new Date());

                Vehicle updatedVehicle = vehicleRepository.save(existingVehicle);
                return ResponseEntity.ok(updatedVehicle);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}




