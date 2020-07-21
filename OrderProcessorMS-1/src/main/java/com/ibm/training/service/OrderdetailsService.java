package com.ibm.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.training.Order;
import com.ibm.training.repository.OrderProcessRepository;

@RestController
public class OrderdetailsService {
	
	@Autowired
	private OrderProcessRepository orderProcessRepository;
	
	@GetMapping("/getProcessedOrderDetails")
	public List<Order> getProcessedOrderDetails(){
		
		return orderProcessRepository.findAll();
		
	}

}
