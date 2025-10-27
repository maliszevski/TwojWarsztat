package com.example.twojwarsztat.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
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
