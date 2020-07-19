package com.ibm.training.rules;

import org.springframework.stereotype.Service;

import com.ibm.training.Order;

@Service
public class BusinessRules {
	
	public String setPriority(Order order) {
		String priority = null;
		if(order.getAmount()>5000) {
			priority = "HIGH Priority";
		}
		else if (order.getAmount()>500) {
			priority = "MEDIUM Priority";
		}
		else {
			priority = "CANCELLED";
		}
		return priority;
	}

}
