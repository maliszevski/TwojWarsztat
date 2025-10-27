package com.example.twojwarsztat.repository;


import com.example.twojwarsztat.model.RepairOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairOrderRepository extends JpaRepository<RepairOrder,Long> {
}
