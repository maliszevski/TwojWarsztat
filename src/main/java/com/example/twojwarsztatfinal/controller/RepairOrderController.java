package com.example.twojwarsztatfinal.controller;

import com.example.twojwarsztatfinal.dto.RepairOrderDTO;
import com.example.twojwarsztatfinal.model.RepairOrder;
import com.example.twojwarsztatfinal.service.RepairOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/repair_orders")
public class RepairOrderController {

    @Autowired
    private RepairOrderService repairOrderService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("repairOrderDTO", new RepairOrderDTO());
        return "repair_orders/create";
    }

    @PostMapping("/create")
    public String processCreateForm(@ModelAttribute RepairOrderDTO repairOrderDTO) {
        repairOrderService.createNewRepairOrder(repairOrderDTO);
        return "redirect:/";
    }


    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable Long id, Model model) {
        RepairOrder repairOrder = repairOrderService.findRepairOrderById(id);
        model.addAttribute("repairOrderDetails", repairOrder);
        return "repair_orders/details";
    }

    @GetMapping("/repair_orders")
    public String searchForRepairOrders(@RequestParam(name = "searchTerm", required = false) String searchTerm, Model model) {
        List<RepairOrder> repairOrderList = repairOrderService.searchTerm(searchTerm);
        model.addAttribute("repairOrderList", repairOrderList);
        model.addAttribute("searchTerm", searchTerm);
        return "repair_orders"; // do dokończenia
    }

}
