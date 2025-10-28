package com.example.twojwarsztat.service;


import com.example.twojwarsztat.model.Vehicle;
import com.example.twojwarsztat.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    }
}
