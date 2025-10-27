package com.example.twojwarsztat.controller;


import com.example.twojwarsztat.dto.RepairOrderDTO;
import com.example.twojwarsztat.service.RepairOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RepairOrderController {
    @Autowired
    private RepairOrderService repairOrderService;


    @PostMapping("/create-repair-order")
    public String createRepairOrder(@ModelAttribute RepairOrderDTO repairOrderDTO, Model model) {
        repairOrderService.createRepairOrder(repairOrderDTO);
        return "redirect:/success";
    }

    @GetMapping("/new-order")
    public String showRepairForm(Model model) {
        model.addAttribute("repairOrderDTO", new RepairOrderDTO());
        return "index";
    }


}
