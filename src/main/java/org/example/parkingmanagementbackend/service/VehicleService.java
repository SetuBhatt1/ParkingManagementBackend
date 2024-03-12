package org.example.parkingmanagementbackend.service;

import org.example.parkingmanagementbackend.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    Vehicle saveVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    Optional<Vehicle> getVehicleByNumber(String vehicleNumber);

    void deleteVehicleByNumber(String vehicleNumber);
}
