package com.example.twojwarsztat.service;


import com.example.twojwarsztat.dto.RepairOrderDTO;
import com.example.twojwarsztat.model.Customer;
import com.example.twojwarsztat.model.RepairOrder;
import com.example.twojwarsztat.model.Vehicle;
import com.example.twojwarsztat.repository.CustomerRepository;
import com.example.twojwarsztat.repository.RepairOrderRepository;
import com.example.twojwarsztat.repository.VehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RepairOrderService {

    @Autowired
    private RepairOrderRepository repairOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public RepairOrder createRepairOrder(RepairOrderDTO repairOrderDTO) {
        Customer customer = new Customer();
        customer.setName(repairOrderDTO.getCustomerName());
        customer.setSurname(repairOrderDTO.getCustomerSurname());
        customer.setAddress(repairOrderDTO.getCustomerAddress());
        customer.setEmail(repairOrderDTO.getCustomerEmail());
        customer.setPhoneNumber(repairOrderDTO.getCustomerPhone());
        customer.setNipNumber(repairOrderDTO.getCustomerNipNumber());
        Customer savedCustomer = customerRepository.save(customer);

        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(repairOrderDTO.getVehicleBrand());
        vehicle.setModel(repairOrderDTO.getVehicleModel());
        vehicle.setVinNumber(repairOrderDTO.getVehicleVinNumber());
        vehicle.setRegistrationNumber(repairOrderDTO.getVehicleRegistrationNumber());
        vehicle.setCustomer(savedCustomer);
        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        RepairOrder newRepairOrder = new RepairOrder();
        newRepairOrder.setDescription(repairOrderDTO.getDescription());
        newRepairOrder.setVehicle(savedVehicle);

        return repairOrderRepository.save(newRepairOrder);
    }

}
