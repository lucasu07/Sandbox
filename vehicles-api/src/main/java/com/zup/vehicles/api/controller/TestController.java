package com.zup.vehicles.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zup.vehicles.client.fipe.dto.requests.CarModelDto;
import com.zup.vehicles.client.fipe.dto.requests.ModelDto;
import com.zup.vehicles.client.fipe.services.CarModelFipeService;

import com.zup.vehicles.domain.service.CarService;

@RestController
@RequestMapping("/cars/fipe")
public class TestController {
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private CarModelFipeService carModelFipeService;
	
	
	@GetMapping
	public CarModelDto getcars(@RequestParam String brand) {
		System.out.println(brand);
		return carModelFipeService.getCarbrand(brand);
		
	}
	
	@GetMapping("/modelo")
	public CarModelDto getcarsModel(@RequestParam String brand, @RequestParam String id) {
		return carModelFipeService.getCarModel(brand, id);
	
	}


}
