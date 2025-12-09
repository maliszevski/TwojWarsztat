package com.example.twojwarsztatfinal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RepairOrderDTO {
    private String customerName;
    private String customerSurname;
    private String customerEmail;
    private String customerPhone;
    private String customerNipNumber;
    private String customerAddress;


    private String vehicleBrand;
    private String vehicleModel;
    private String vehicleVinNumber;
    private String vehicleRegistrationNumber;

    private String description;
}
