package com.infy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class M2TrainApplication {

	public static void main(String[] args) {
		SpringApplication.run(M2TrainApplication.class, args);
	}

}
