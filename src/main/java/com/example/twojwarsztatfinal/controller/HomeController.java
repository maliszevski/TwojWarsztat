package com.example.twojwarsztatfinal.controller;


import com.example.twojwarsztatfinal.service.RepairOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private RepairOrderService repairOrderService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("activeRepairOrders", repairOrderService.getActiveRepairOrders());
        return "index";
    }
    
}
