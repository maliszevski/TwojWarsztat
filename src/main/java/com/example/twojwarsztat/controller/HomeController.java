package com.example.twojwarsztat.controller;

import com.example.twojwarsztat.dto.RepairOrderDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("repairOrderDTO", new RepairOrderDTO());
        return "index";
    }


}
