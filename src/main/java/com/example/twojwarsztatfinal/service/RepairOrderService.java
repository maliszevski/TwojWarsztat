package com.example.twojwarsztatfinal.service;

import com.example.twojwarsztatfinal.dto.RepairOrderDTO;
import com.example.twojwarsztatfinal.model.Customer;
import com.example.twojwarsztatfinal.model.RepairOrder;
import com.example.twojwarsztatfinal.model.RepairOrderStatus;
import com.example.twojwarsztatfinal.model.Vehicle;
import com.example.twojwarsztatfinal.repository.CustomerRepository;
import com.example.twojwarsztatfinal.repository.RepairOrderRepository;
import com.example.twojwarsztatfinal.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairOrderService {
    @Autowired
    private RepairOrderRepository repairOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public RepairOrder createNewRepairOrder(RepairOrderDTO repairOrderDTO) {
        Customer newCustomer = new Customer();
        newCustomer.setName(repairOrderDTO.getCustomerName());
        newCustomer.setSurname(repairOrderDTO.getCustomerSurname());
        newCustomer.setAddress(repairOrderDTO.getCustomerAddress());
        newCustomer.setEmail(repairOrderDTO.getCustomerEmail());
        newCustomer.setPhoneNumber(repairOrderDTO.getCustomerPhone());
        newCustomer.setNipNumber(repairOrderDTO.getCustomerNipNumber());
        customerRepository.save(newCustomer);

        Vehicle newVehicle = new Vehicle();
        newVehicle.setBrand(repairOrderDTO.getVehicleBrand());
        newVehicle.setModel(repairOrderDTO.getVehicleModel());
        newVehicle.setVinNumber(repairOrderDTO.getVehicleVinNumber());
        newVehicle.setRegistrationNumber(repairOrderDTO.getVehicleRegistrationNumber());
        newVehicle.setCustomer(newCustomer);
        vehicleRepository.save(newVehicle);

        RepairOrder newRepairOrder = new RepairOrder();
        newRepairOrder.setDescription(repairOrderDTO.getDescription());
        newRepairOrder.setCustomer(newCustomer);
        newRepairOrder.setVehicle(newVehicle);
        newRepairOrder.setRepairOrderStatus(RepairOrderStatus.OPEN);

        return repairOrderRepository.save(newRepairOrder);
    }

    public RepairOrder findRepairOrderById(Long id) {
        return repairOrderRepository.findById(id).get();
    }

    public List<RepairOrder> searchTerm(String searchTerm) {
        return repairOrderRepository.findByVehicleCustomerNameContainingIgnoreCaseOrVehicleCustomerSurnameContainingIgnoreCaseOrVehicleRegistrationNumberContainingIgnoreCase(
                searchTerm, searchTerm, searchTerm
        );
    }

    public List<RepairOrder> getActiveRepairOrders() {
        return repairOrderRepository.findByRepairOrderStatus(RepairOrderStatus.OPEN);
    }

}



