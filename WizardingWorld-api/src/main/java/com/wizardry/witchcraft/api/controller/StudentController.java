package com.wizardry.witchcraft.api.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wizardry.witchcraft.api.model.StudentsRepresentationModel;
import com.wizardry.witchcraft.domain.model.StudentModel;
import com.wizardry.witchcraft.domain.repository.IStudentRepository;
import com.wizardry.witchcraft.domain.service.RegisterStudentService;


@RestController
@RequestMapping(value = "/students")
public class StudentController {
	
	
	@Autowired
	private IStudentRepository iStudentRepository;
	
	@Autowired
	private RegisterStudentService registerStudentService;
		
	/*
	 * Content negotiation podemos fazer 2 mapeamentos para o mesmo endPoint
	 * especificando metodos diferentes é o MediaType aceito pela requisição
	 * No caso abaixo para o tipo de midia escolhida pelo cliente.
	 */
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public  List<StudentModel> listJson() {
				
		return iStudentRepository.listItAll();		
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public  StudentsRepresentationModel listXml() {
				
		return new StudentsRepresentationModel(iStudentRepository.listItAll());
		
	}
		
	@GetMapping("/{Id}") 
	public ResponseEntity<StudentModel> find(@PathVariable("Id") Long studentId) {
		  StudentModel student = iStudentRepository.findOne(studentId);
		  
		  if (student != null){
			  return ResponseEntity 
				  .status(HttpStatus.OK) 
				  .body(student);
		  
		   }
		  
		  return ResponseEntity.notFound().build();
			  
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public StudentModel add(@RequestBody StudentModel studentModel) {
		
		return registerStudentService.register(studentModel);
	}
	
	@PutMapping("/{Id}")
	public ResponseEntity<StudentModel> update(@RequestBody StudentModel studentModelOne, @PathVariable("Id")
			Long studentId){
		StudentModel studentModelZero = iStudentRepository.findOne(studentId);
		
		if(studentModelZero!=null){				
			BeanUtils.copyProperties(studentModelOne, studentModelZero, "id");
			registerStudentService.register(studentModelZero);		
			return ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.body(studentModelZero);

		}
		
		return ResponseEntity.notFound().build();
		
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<StudentModel> delete(@PathVariable ("id") Long studendId){
		StudentModel studentModelZero = iStudentRepository.findOne(studendId);
				
		if(studentModelZero != null) {	
			registerStudentService.remove(studendId);			
			return ResponseEntity.noContent().build();			
		}
		
		return ResponseEntity.notFound().build();		
	} 			
}
