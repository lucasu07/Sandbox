package com.wizardry.witchcraft.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wizardry.witchcraft.domain.exception.EntityInUseException;
import com.wizardry.witchcraft.domain.exception.EntityNotFoundException;
import com.wizardry.witchcraft.domain.model.CountryModel;
import com.wizardry.witchcraft.domain.model.StateModel;

import com.wizardry.witchcraft.domain.service.RegisterCountryService;
import com.wizardry.witchcraft.domain.service.RegisterStateService;


@RestController
@RequestMapping(path = "/states")
public class StateController {
	
	@Autowired
	public RegisterStateService registerStateService;
	
	@Autowired
	public RegisterCountryService registerCountryService;
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StateModel> listAllStates(){
		return registerStateService.listAllStates(); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StateModel> findOne(@PathVariable(name = "id") Long id) {
		try {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(registerStateService.findOne(id));
		
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
	
	}
	
	//Se colocarmos o nome da coluna errado criará um record null para o banco!
	@PostMapping
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> register (@RequestBody StateModel stateModel) {
		
		try { 
			return ResponseEntity.status(HttpStatus.CREATED).body(registerStateService.register(stateModel));		
			
		} catch(EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			
		}
	}
	
	
	@PutMapping("/{Id}")	
	public ResponseEntity<?> update (@PathVariable("Id") Long stateId,
			@RequestBody StateModel stateModelOne) {
		
		try { 
			StateModel stateModelZero = registerStateService.findOne(stateId);
			CountryModel countryModel = (registerCountryService
					.findOne(stateModelZero.getCountryModel().getId()));
	
			BeanUtils.copyProperties(stateModelOne, stateModelZero, "id");
			registerStateService.register(stateModelZero);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(stateModelZero);
		  
		  } catch (EmptyResultDataAccessException e) { return
		  ResponseEntity.notFound().build();
		  
		  }catch (EntityNotFoundException e) { return
		  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		  
		  }
		 
														
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable(name = "id") Long id) {
		try {
			registerStateService.remove(id);
			return ResponseEntity.noContent().build();
		} catch(EntityNotFoundException e){
			return ResponseEntity.notFound().build();			
		} catch(EntityInUseException e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());			
		}
		
	}	

	
	//Metodo criado como referencia de estudo
	@PatchMapping("/{Id}")	
	public ResponseEntity<?> patch (@PathVariable("Id") Long stateId,
			@RequestBody Map<String, Object> requestFields) {
	
		
		try {
			StateModel stateZero = registerStateService.findOne(stateId);
			merge(requestFields, stateZero);
			return update(stateId, stateZero);
			
			} catch (EmptyResultDataAccessException e) {
				return ResponseEntity.notFound().build();
			}
		
	}
	
	
	private void merge(Map<String, Object> requestFields, StateModel stateOne) {
		
		ObjectMapper objectMapper = new ObjectMapper();		
		StateModel stateZero = objectMapper.convertValue(requestFields, StateModel.class);
		
		requestFields.forEach((propertyName, propertyValue) -> {
		Field field = ReflectionUtils.findField(StateModel.class, propertyName);
		
		Object newValue = ReflectionUtils.getField(field, stateZero);
		
		ReflectionUtils.setField(field, stateOne, propertyValue);			
			
		});
		
	
	}
	
	
}
