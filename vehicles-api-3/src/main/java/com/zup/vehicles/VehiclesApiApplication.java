package com.zup.vehicles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VehiclesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehiclesApiApplication.class, args);
	}

}
