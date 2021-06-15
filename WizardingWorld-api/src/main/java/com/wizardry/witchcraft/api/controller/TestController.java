package com.wizardry.witchcraft.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.wizardry.witchcraft.domain.model.StudentModel;
import com.wizardry.witchcraft.domain.repository.IStudentRepository;
import com.wizardry.witchcraft.domain.service.RegisterStudentService;
import com.wizardry.witchcraft.domain.service.RegisterWizardingSchoolService;

@RestController
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	private RegisterStudentService registerStudentService;

	@Autowired
	private RegisterWizardingSchoolService registerWizardingSchoolService;
	
	@Autowired
	private IStudentRepository iStudentRepository;
	

	
	@GetMapping
	public List<StudentModel> find2(String name
			,Boolean isDadWizard ,Boolean isMomWizard) {
		return iStudentRepository.find2(name,isDadWizard, isMomWizard);
		
	}


}
 