package com.example.twojwarsztat.service;


import com.example.twojwarsztat.model.Customer;
import com.example.twojwarsztat.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return  customerRepository.findAll();
    }



}
