package org.example.parkingmanagementbackend.repository;

import org.example.parkingmanagementbackend.model.PermanentVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermanentVehicleRepository extends JpaRepository<PermanentVehicle,String> {
}
