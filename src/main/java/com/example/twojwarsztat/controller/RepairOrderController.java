package com.example.twojwarsztat.controller;


import com.example.twojwarsztat.dto.RepairOrderDTO;
import com.example.twojwarsztat.model.RepairOrder;
import com.example.twojwarsztat.service.RepairOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class RepairOrderController {
    @Autowired
    private RepairOrderService repairOrderService;


    @PostMapping("/create-repair-order")
    public String createRepairOrder(@ModelAttribute RepairOrderDTO repairOrderDTO, RedirectAttributes redirectAttributes) {
        repairOrderService.createRepairOrder(repairOrderDTO);
        redirectAttributes.addFlashAttribute("successMessage", "Zlecenie naprawy utworzone pomyślnie.");
        return "redirect:/";
    }

    @GetMapping("/new-order")
    public String showRepairForm(Model model) {
        model.addAttribute("repairOrderDTO", new RepairOrderDTO());
        return "index";
    }

    @GetMapping("/repair_orders")
    public String getRepairOrders(@RequestParam(name ="searchTerm", required = false) String searchTerm, Model model) {
        List<RepairOrder> repairOrderList = repairOrderService.searchTerm(searchTerm);
        model.addAttribute("repairOrders", repairOrderList);
        model.addAttribute("searchTerm", searchTerm);
        return "orders";
    }


}
