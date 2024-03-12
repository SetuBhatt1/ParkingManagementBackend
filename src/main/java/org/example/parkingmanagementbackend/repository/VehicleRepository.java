package org.example.parkingmanagementbackend.repository;

import org.example.parkingmanagementbackend.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    //    @Query("SELECT p from Vehicle WHERE p.vehicleNumber LIKE %?1%")
    List<Vehicle> findByVehicleNumber(String vehicleNumber);
}
