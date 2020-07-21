package com.ibm.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.training.Order;

public interface OrderProcessRepository extends JpaRepository<Order, String>{

}
