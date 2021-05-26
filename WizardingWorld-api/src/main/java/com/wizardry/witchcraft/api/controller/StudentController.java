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
import com.wizardry.witchcraft.domain.exception.EntityNotFoundException;
import com.wizardry.witchcraft.domain.exception.EntitySchoolNotFoundException;
import com.wizardry.witchcraft.domain.model.StudentModel;
import com.wizardry.witchcraft.domain.model.WizardingSchoolModel;
import com.wizardry.witchcraft.domain.service.RegisterStudentService;
import com.wizardry.witchcraft.domain.service.RegisterWizardingSchoolService;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

	@Autowired
	private RegisterStudentService registerStudentService;

	@Autowired
	private RegisterWizardingSchoolService registerWizardingSchoolService;

	/*
	 * Content negotiation podemos fazer 2 mapeamentos para o mesmo endPoint
	 * especificando metodos diferentes é o MediaType aceito pela requisição No caso
	 * abaixo para o tipo de midia escolhida pelo cliente.
	 */

	@ResponseStatus(HttpStatus.ACCEPTED)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StudentModel> listJson() {
		return registerStudentService.list();
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public StudentsRepresentationModel listXml() {
		return new StudentsRepresentationModel(registerStudentService.list());

	}

	// Criar uma exceção para os metodos find a responsabilidade de saber se o ID
	// existe ou não
	// não é do controller!
	@GetMapping("/{Id}")
	public ResponseEntity<?> find(@PathVariable("Id") Long studentId) {

		try {
			StudentModel student = registerStudentService.findOne(studentId);
			return ResponseEntity.status(HttpStatus.OK).body(student);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

		}
	}

	@PostMapping
	public ResponseEntity<?> register(@RequestBody StudentModel studentModel) {

		try {
			studentModel = registerStudentService.register(studentModel);

			return ResponseEntity.status(HttpStatus.CREATED).body(studentModel);

		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/{Id}")
	public ResponseEntity<?> update(@RequestBody StudentModel studentModelOne,
			@PathVariable("Id") Long studentId) {
		
		try {
			StudentModel studentModelZero = registerStudentService.findOne(studentId);
			WizardingSchoolModel wizardingSchoolModel = (registerWizardingSchoolService
					.find(studentModelZero.getWizardingSchoolModel().getId()));

			BeanUtils.copyProperties(studentModelOne, studentModelZero, "id");
			registerStudentService.register(studentModelZero);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentModelZero);

		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
		 catch (EntitySchoolNotFoundException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long studendId) {

		try {
			registerStudentService.remove(studendId);
			return ResponseEntity.noContent().build();

		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

		}

	}
}
