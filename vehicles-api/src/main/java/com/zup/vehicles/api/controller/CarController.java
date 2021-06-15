package com.zup.vehicles.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.vehicles.domain.model.CarModel;
import com.zup.vehicles.domain.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@GetMapping
	public List<CarModel> listAllCar(){
		return carService.listAllCar();
	}	
	
	@PostMapping
	public CarModel register(@RequestBody @Valid CarModel carModel) {
		return carService.register(carModel);
	}
		
	
	
}
