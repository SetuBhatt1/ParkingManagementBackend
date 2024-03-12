package org.example.parkingmanagementbackend.repository;

import org.example.parkingmanagementbackend.model.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Integer> {
    
}
