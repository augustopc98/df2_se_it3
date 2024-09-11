package com.example.demo.repositories;

import com.example.demo.entities.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}
