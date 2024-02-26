package org.example.parkingmanagementbackend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Parking_Floor")
public class Floor {
    // Floor -> unique id + floor number

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "floor_id", nullable = false)
    private Long id;

    @Column(name = "floor_number", nullable = false)
    private int floorNumber;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

}
