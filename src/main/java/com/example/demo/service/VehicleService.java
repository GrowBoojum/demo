package com.example.demo.service;

import com.example.demo.api.VehicleApi;
import com.example.demo.entities.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleApi vehicleRepository ;

    public VehicleService(final VehicleApi vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
        createVehicle("t1", "11", "opel");
        createVehicle("t2", "22", "opel");
    }

    public Vehicle createVehicle(String type, String modelCode, String brandName){
        Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
        return this.vehicleRepository.insert(vehicle);
    }

    public List<Vehicle> getAllVehicles(final int count) {
        return this.vehicleRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    public Optional<Vehicle> getVehicle(final String id) {
        return this.vehicleRepository.findById(id);
    }
}






