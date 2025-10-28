package com.example.twojwarsztat.controller;

import com.example.twojwarsztat.model.Vehicle;
import com.example.twojwarsztat.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;


    @GetMapping("/vehicles")
    public String vehicles(Model model) {
        List<Vehicle> vehicles = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicles);
        return "vehicles";
    }




}
