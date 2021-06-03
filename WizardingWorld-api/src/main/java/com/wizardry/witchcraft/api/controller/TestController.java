package com.wizardry.witchcraft.api.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wizardry.witchcraft.api.model.StudentsRepresentationModel;
import com.wizardry.witchcraft.domain.exception.EntityNotFoundException;
import com.wizardry.witchcraft.domain.exception.EntitySchoolNotFoundException;
import com.wizardry.witchcraft.domain.model.StudentModel;
import com.wizardry.witchcraft.domain.model.WizardingSchoolModel;
import com.wizardry.witchcraft.domain.repository.IStateRepository;
import com.wizardry.witchcraft.domain.repository.IStudentRepository;
import com.wizardry.witchcraft.domain.service.RegisterStudentService;
import com.wizardry.witchcraft.domain.service.RegisterWizardingSchoolService;

@RestController
@RequestMapping(value = "/testes")
public class TestController {

	@Autowired
	private RegisterStudentService registerStudentService;

	@Autowired
	private RegisterWizardingSchoolService registerWizardingSchoolService;
	
	@Autowired
	private IStudentRepository iStudentRepository;
	

	
	@GetMapping
	public List<StudentModel> find2(String name) {
		return iStudentRepository.find2(name);
		
	}


}
 