package com.ibm.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients("com.ibm.training")
@ComponentScan("com")
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableHystrix
public class CurrencyConversionMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionMsApplication.class, args);
	}

}