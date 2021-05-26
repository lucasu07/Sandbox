package com.wizardry.witchcraft.api.controller;

import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wizardry.witchcraft.domain.exception.EntityInUseException;
import com.wizardry.witchcraft.domain.exception.EntityNotFoundException;
import com.wizardry.witchcraft.domain.model.CountryModel;
import com.wizardry.witchcraft.domain.model.StateModel;
import com.wizardry.witchcraft.domain.service.RegisterCountryService;
import com.wizardry.witchcraft.domain.service.RegisterStateService;

@RestController
@RequestMapping(path = "/countries")
public class CountryController {
	
	@Autowired
	public RegisterCountryService registerCountryService;
	
	@GetMapping
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CountryModel> listAllCountry(){
		return registerCountryService.listAllCountry();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CountryModel> findOne(@PathVariable(name = "id") Long id) {
		try {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(registerCountryService.findOne(id));
		
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
	
	}
	
	//Se colocarmos o nome da coluna errado criará um record null para o banco!
	@PostMapping
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public CountryModel register (@RequestBody CountryModel countryModel) {
		return registerCountryService.register(countryModel);		
	}
	
	
	@PutMapping("/{id}")	
	public ResponseEntity<CountryModel> update (@PathVariable(name = "id") Long id,
			@RequestBody CountryModel countryModelOne) {
		
		try {
			CountryModel countryModelZero = registerCountryService.findOne(id);
			BeanUtils.copyProperties(countryModelOne, countryModelZero, "id");
			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(registerCountryService.register(countryModelZero));		
				
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();			
		
		}	
														
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable(name = "id") Long id) {
		try {
			registerCountryService.remove(id);
			return ResponseEntity.noContent().build();
		} catch(EntityNotFoundException e){
			return ResponseEntity.notFound().build();			
		} catch(EntityInUseException e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());			
		}
		
	}	
	
	
	
}
