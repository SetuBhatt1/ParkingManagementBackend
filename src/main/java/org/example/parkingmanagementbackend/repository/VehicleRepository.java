package org.example.parkingmanagementbackend.repository;

import org.example.parkingmanagementbackend.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,String> {
}
