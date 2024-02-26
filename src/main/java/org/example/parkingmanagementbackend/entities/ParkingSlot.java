package org.example.parkingmanagementbackend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Parking_Slot")
public class ParkingSlot {
    //Slot -> unique id + slot number + floorId (fk)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slot_id")
    private Long id;

    @Column(name = "slot_number")
    private int slotNumber;

    @ManyToOne
    @JoinColumn(name = "floor_slot", nullable = false)
    private Floor floorId;

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Floor getFloorId() {
        return floorId;
    }

    public void setFloorId(Floor floorId) {
        this.floorId = floorId;
    }


}
