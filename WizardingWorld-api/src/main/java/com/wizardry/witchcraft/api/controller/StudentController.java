package com.wizardry.witchcraft.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wizardry.witchcraft.domain.model.StudentModel;
import com.wizardry.witchcraft.domain.repository.IStudentRepository;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	
	@Autowired
	private IStudentRepository iStudentRepository;
	
	@GetMapping
	public  List<StudentModel> listar() {
		
		
		return null;		
	}
	
	

}
