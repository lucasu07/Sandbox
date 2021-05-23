package com.wizardry.witchcraft.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wizardry.witchcraft.api.model.WizardingSchoolRepresentationModel;
import com.wizardry.witchcraft.domain.exception.EntityInUseException;
import com.wizardry.witchcraft.domain.exception.EntityNotFoundException;
import com.wizardry.witchcraft.domain.model.WizardingSchoolModel;
import com.wizardry.witchcraft.domain.service.RegisterWizardingSchoolService;

@RestController
@RequestMapping(value = "/schools")
public class WizardingSchoolController {

	@Autowired
	private RegisterWizardingSchoolService registerWizardingSchoolService;

	/*
	 * Content negotiation podemos fazer 2 mapeamentos para o mesmo endPoint
	 * especificando metodos diferentes é o MediaType aceito pela requisição No caso
	 * abaixo para o tipo de midia escolhida pelo cliente.
	 */

	@ResponseStatus(HttpStatus.ACCEPTED)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<WizardingSchoolModel> listJson() {
		return registerWizardingSchoolService.listItAll();
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public WizardingSchoolRepresentationModel listXml() {
		return new WizardingSchoolRepresentationModel(registerWizardingSchoolService.listItAll());
	}
	
	
	//Criar uma exceção para os metodos find a responsabilidade de saber se o ID existe ou não
	//não é do controller
	@GetMapping("/{id}")
	public ResponseEntity<?> listById(@PathVariable(value = "id") Long schoolId) {
		
		try {
			WizardingSchoolModel wizardingSchoolModel = (registerWizardingSchoolService.find(schoolId));
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(wizardingSchoolModel);
		
		
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());			
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public WizardingSchoolModel register(@RequestBody WizardingSchoolModel wizardingSchoolModel) {
		return registerWizardingSchoolService.register(wizardingSchoolModel);

	}

	// Risco de dar merge de duas escolas colocando o mesmo nome, pois é um foreign
	// key da tabela alunos.
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(value = "id") Long schoolId,
			@RequestBody WizardingSchoolModel wizardingSchoolModelOne) {

		try {
			WizardingSchoolModel wizardingSchoolModelZero = (registerWizardingSchoolService.find(schoolId));
			BeanUtils.copyProperties(wizardingSchoolModelOne, wizardingSchoolModelZero, "id");

			return ResponseEntity.status(HttpStatus.ACCEPTED)
					.body(registerWizardingSchoolService.register(wizardingSchoolModelZero));
			
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			
		}
		

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long schoolId) {
		try {
			registerWizardingSchoolService.remove(schoolId);
			return ResponseEntity.noContent().build();
 
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND) 
					.body(e.getMessage()); 
				
		} catch (EntityInUseException e) { 
			return ResponseEntity.status(HttpStatus.CONFLICT) 
				.body(e.getMessage()); 
		}
				 

		}

	}

