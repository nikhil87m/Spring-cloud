package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com.example")
@EnableJpaRepositories("com.example.repo")
public class CurrencyExchangeMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeMsApplication.class, args);
	}

}