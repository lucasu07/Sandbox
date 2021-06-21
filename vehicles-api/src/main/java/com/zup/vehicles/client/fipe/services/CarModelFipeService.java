package com.zup.vehicles.client.fipe.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zup.vehicles.client.fipe.dto.requests.CarModelDto;
import com.zup.vehicles.client.fipe.dto.requests.ModelDto;
import com.zup.vehicles.client.fipe.endpoint.GetFipeModels;

@Service
public class CarModelFipeService {
	
	@Autowired
	private GetFipeModels getFipeModels;

	
	public CarModelDto getCarbrand(String brand){
		CarModelDto car1 = new CarModelDto(); 
		
		 var parameter = new HashMap<String, String>();
		 getFipeModels.getCarBrandCode().forEach(car -> parameter.put(car.getNome(),car.getCodigo()));
	 
		// parameter.containsKey(brand);
		 car1.setNome(brand);
		 car1.setCodigo(parameter.get(brand));
		 
		 return car1;
				  
	}
	
	
	public CarModelDto getCarModel(String brand, String id) {
		ModelDto model = getFipeModels.getCarModels(id);
		CarModelDto car1 = new CarModelDto(); 
		
		var parameter = new HashMap<String, String>();
							
		model.getModelos().forEach(car -> parameter.put(car.getNome(),car.getCodigo()));
		car1.setNome(brand);
		 car1.setCodigo(parameter.get(brand));
		 
		 return car1;
		
		 
		  
	}
	

	
}	
	

 
