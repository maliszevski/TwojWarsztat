package com.example.twojwarsztatfinal.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="repair_orders")
@Getter
@Setter
public class RepairOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable = false)
    private Customer customer;

    private String description;

    private LocalDate repairOrderDate = LocalDate.now();

    private LocalTime repairOrderTime = LocalTime.now();

    @Enumerated(EnumType.STRING)
    private RepairOrderStatus repairOrderStatus;




}