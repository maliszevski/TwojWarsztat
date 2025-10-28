package com.example.twojwarsztat.repository;


import com.example.twojwarsztat.model.RepairOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairOrderRepository extends JpaRepository<RepairOrder,Long> {
    public List<RepairOrder> findByVehicleCustomerNameContainingIgnoreCaseOrVehicleCustomerSurnameContainingIgnoreCaseOrVehicleRegistrationNumberContainingIgnoreCase(String name, String surname, String registrationNumber);
}
