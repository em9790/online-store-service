package com.example.onlinestoreservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.onlinestoreservice"})
public class OnlineStoreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineStoreServiceApplication.class, args);
	}

}
