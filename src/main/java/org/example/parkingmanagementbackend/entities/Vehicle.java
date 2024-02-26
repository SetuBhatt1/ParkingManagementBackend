package org.example.parkingmanagementbackend.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Parking_Vehicle")
public class Vehicle {
    // vehicle -> unique id + vehicle number + entry time + exit time + floor no (fk) + slot no (fk)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long id;

    @Column(name = "vehicle_issued_number")
    private String vehicleNumber;

    @Column(name = "entry_time")
    private Date entryTime;

    @Column(name = "exit_time")
    private Date exitTime;

    @OneToOne
    @JoinColumn(name = "slot_vehicle")
    private ParkingSlot slotId;

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

    public ParkingSlot getSlotId() {
        return slotId;
    }

    public void setSlotId(ParkingSlot slotId) {
        this.slotId = slotId;
    }


}
