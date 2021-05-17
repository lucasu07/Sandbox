package com.wizardry.witchcraft.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wizardry.witchcraft.api.model.StudentsRepresentationModel;
import com.wizardry.witchcraft.domain.model.StudentModel;
import com.wizardry.witchcraft.domain.repository.IStudentRepository;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
	
	
	@Autowired
	private IStudentRepository iStudentRepository;
	
		
	/*
	 * Content negotiation podemos fazer 2 mapeamentos para o mesmo endPoint
	 * especificando metodos diferentes é o MediaType aceito pela requisição
	 * No caso abaixo para o tipo de midia escolhida pelo cliente.
	 */
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public  List<StudentModel> listJson() {
				
		return iStudentRepository.listar();		
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public  StudentsRepresentationModel listXml() {
				
		return new StudentsRepresentationModel(iStudentRepository.listar());
		
	}
	
		
	@GetMapping("/{Id}") 
	public ResponseEntity<StudentModel> Find(@PathVariable("Id") Long studentId) {
		  StudentModel student = iStudentRepository.findCustom(studentId);
		  
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
		
		return iStudentRepository.saveCustom(studentModel);
	}
	
	@PutMapping("/{Id}")
	public ResponseEntity<StudentModel> Update(@RequestBody StudentModel studentModelOne, @PathVariable("Id")
			Long studentId){
		StudentModel studentModelZero = iStudentRepository.findCustom(studentId);
		
		if(studentModelZero==null){				
			BeanUtils.copyProperties(studentModelOne, studentModelZero, "id");
			iStudentRepository.saveCustom(studentModelZero);		
			return ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.body(studentModelZero);
		
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	
	   
		
}
