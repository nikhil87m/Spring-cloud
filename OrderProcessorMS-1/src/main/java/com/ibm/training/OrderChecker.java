package com.ibm.training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.ibm.training.rules.BusinessRules;

@Component
public class OrderChecker {

	public static final Logger log = LoggerFactory.getLogger(OrderChecker.class);
	@Autowired
	private OrderProcessor processor;
	
	@Autowired
	private BusinessRules businessRules;

	@StreamListener("output")
	public void checkAndSortLoans(Order order) {
		
		order.setStatus(businessRules.setPriority(order));
		
		if (order.getAmount() > 5000) {
			processor.approved().send(message(order));
			
		} else if (order.getAmount() > 400) {
			processor.approved().send(message(order));
			
		} else {
			processor.declined().send(message(order));
		}
		log.info("Exit  :" + order.getStatus() + " " + order);

	}

	private static final <T> Message<T> message(T val) {
		return MessageBuilder.withPayload(val).build();
	}
}
