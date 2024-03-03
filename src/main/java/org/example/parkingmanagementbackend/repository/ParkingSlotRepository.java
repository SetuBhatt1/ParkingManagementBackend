package org.example.parkingmanagementbackend.repository;

import org.example.parkingmanagementbackend.model.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {
}
