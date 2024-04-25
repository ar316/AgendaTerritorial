package com.microservices.role;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class microserviceRole {

	public static void main(String[] args) {
		SpringApplication.run(microserviceRole.class, args);
	}

}
