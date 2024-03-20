package org.example.parkingmanagementbackend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "Permanent_Vehicle")
public class PermanentVehicle {

    @Id
    @Column(name = "vehicle_number")
    private String vehicleNumber;

    @CreationTimestamp
    @Column(name = "entry_time")
    private Date entryTime;

    @UpdateTimestamp
    @Column(name = "exit_time")
    private Date exitTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "slot_id")
    private ParkingSlot slot;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "floor_id")
    private Floor floor;

    // Constructors, getters, and setters

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public void setSlot(ParkingSlot slot) {
        this.slot = slot;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}
