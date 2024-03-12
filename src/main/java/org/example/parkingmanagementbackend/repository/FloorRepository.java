package org.example.parkingmanagementbackend.repository;

import org.example.parkingmanagementbackend.model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FloorRepository extends JpaRepository<Floor, Integer> {
}
