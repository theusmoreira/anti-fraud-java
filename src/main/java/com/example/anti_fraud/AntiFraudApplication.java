package com.example.anti_fraud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AntiFraudApplication {

	public static void main(String[] args) {
		SpringApplication.run(AntiFraudApplication.class, args);
		System.out.println("Anti-fraud initialize");
	}

}
