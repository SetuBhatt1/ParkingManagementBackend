package org.example.parkingmanagementbackend.service;

import org.example.parkingmanagementbackend.model.Vehicle;
import org.example.parkingmanagementbackend.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> getVehicleByNumber(String vehicleNumber) {
        return vehicleRepository.findById(vehicleNumber);
    }

    @Override
    public void deleteVehicleByNumber(String vehicleNumber) {
        vehicleRepository.deleteById(vehicleNumber);
    }

//    @Override
//    public List<Vehicle> findByCarNumber(String carNumber) {
//        List<Vehicle> result = null;
//        if (carNumber != null) {
//            return vehicleRepository.findByCarNumber(carNumber);
//        }
//        return result;
//    }
}
