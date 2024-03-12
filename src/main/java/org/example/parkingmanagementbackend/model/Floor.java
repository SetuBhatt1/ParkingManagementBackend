package org.example.parkingmanagementbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Parking_Floor")
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "floor_id", nullable = false)
    private int floorId;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Column(name = "floor_number", nullable = false)
    private int floorNumber;

}
