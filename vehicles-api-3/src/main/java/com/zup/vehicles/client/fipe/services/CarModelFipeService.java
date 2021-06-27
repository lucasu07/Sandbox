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
import com.zup.vehicles.client.fipe.dto.requests.PriceDto;
import com.zup.vehicles.client.fipe.endpoint.GetFipeModels;
import java.util.List;

@Service
public class CarModelFipeService {
	
	@Autowired
	private GetFipeModels getFipeModels;

	public String getCarFipePrice(String brand, String model, int year) {
		
		//int year = Integer.parseInt(yearString);
		
		//Get car id_brand
		CarModelDto brandChar = new CarModelDto(); 
		var brandHashmap = new HashMap<String, String>();		
		getFipeModels.getCarBrandCode().forEach(car -> brandHashmap.put(car.getNome(),car.getCodigo()));
		brandChar.setNome(brand);
		brandChar.setCodigo(brandHashmap.get(brand));
		String id_brand = brandChar.getCodigo();		
		
		//Get car id_model
		ModelDto modelCharWrapped = getFipeModels.getCarModels(id_brand);
		CarModelDto modelChar = new CarModelDto(); 
		var ModelHashmap = new HashMap<String, String>();
		modelCharWrapped.getModelos().forEach(car -> ModelHashmap.put(car.getNome(),car.getCodigo()));
		modelChar.setNome(model);
		modelChar.setCodigo(ModelHashmap.get(model));
		String id_model = modelChar.getCodigo();
		
		
		//Get car id_year
		CarModelDto yearChar = new CarModelDto();
		var yearHashmap = new HashMap<String, String>();		
		
		// Get just the year from property name
		List<CarModelDto> listyearChar = getFipeModels.getCarYears(id_brand, id_model);		
		listyearChar.forEach(car -> car.setNome(car.getNome().split(" ")[0].trim()));
		listyearChar.forEach(car -> yearHashmap.put(car.getNome(),car.getCodigo()));
		
		yearChar.setNome(String.valueOf(year));
		yearChar.setCodigo(yearHashmap.get(String.valueOf(year)));	
 
		String id_year = yearChar.getCodigo();
	 
		
		return getFipeModels.getCarPrice(id_brand, id_model, id_year).getValor();
		
	}
	
	
}	
	

 
