package com.example.twojwarsztatfinal.repository;

import com.example.twojwarsztatfinal.model.RepairOrder;
import com.example.twojwarsztatfinal.model.RepairOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairOrderRepository extends JpaRepository<RepairOrder, Long> {
    List<RepairOrder> findByRepairOrderStatus(RepairOrderStatus status);
    List<RepairOrder> findByVehicleCustomerNameContainingIgnoreCaseOrVehicleCustomerSurnameContainingIgnoreCaseOrVehicleRegistrationNumberContainingIgnoreCase(String name, String surname, String registrationNumber);

}
