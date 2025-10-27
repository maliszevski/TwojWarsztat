package com.example.twojwarsztat.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String name;

    @Column(length = 30)
    private String surname;

    @Column(length = 100)
    private String address;

    @Column(length= 50)
    private String email;

    @Column(length = 50)
    private String phoneNumber;

    @Column(length = 70)
    private String nipNumber;

}
