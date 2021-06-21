package com.zup.vehicles.api.controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

 
import com.zup.vehicles.client.fipe.services.CarModelFipeService;

import com.zup.vehicles.domain.service.CarService;

@RestController
@RequestMapping("/cars/fipe")
public class TestController {
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private CarModelFipeService carModelFipeService;
	
	

	
	@GetMapping("/price2")
	public String getCarFipePrice(@RequestParam int year ,@RequestParam String brand
			,@RequestParam String model) {
		return carModelFipeService.getCarFipePrice(brand, model, year);
	
	}
	
	
}
