package com.wizardry.witchcraft.domain.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wizardry.witchcraft.api.model.StudentsRepresentationModel;
import com.wizardry.witchcraft.domain.exception.EntityNotFoundException;
import com.wizardry.witchcraft.domain.exception.EntitySchoolNotFoundException;
import com.wizardry.witchcraft.domain.model.StudentModel;
import com.wizardry.witchcraft.domain.model.WizardingSchoolModel;
import com.wizardry.witchcraft.domain.repository.IStudentRepository;
import com.wizardry.witchcraft.domain.repository.IWizardingSchoolRepository;

@Service
public class RegisterStudentService {
	
	@Autowired
	private IStudentRepository iStudentRepository;
	
	@Autowired
	private IWizardingSchoolRepository iWizardingSchoolRepository;
	
	
	public List<StudentModel> list(){
		return iStudentRepository.findAll();		
	}	
	
	public StudentModel findOne(Long id) {
		
		Optional<StudentModel> studentModel = iStudentRepository.findById(id);	
		
		if(studentModel.isEmpty()) {
			throw new EmptyResultDataAccessException(1); 			
		}			
		return studentModel.get();
			
	}	
	
	public StudentModel register(StudentModel studentModel) {
		
		Long schoolId = studentModel.getWizardingSchoolModel().getId();
		try {

			Optional<WizardingSchoolModel> wizardingSchoolModel = iWizardingSchoolRepository
						.findById(schoolId);
			studentModel.setWizardingSchoolModel(wizardingSchoolModel.get());

			return iStudentRepository.save(studentModel);	
			 
		} catch (NoSuchElementException e){			
			throw new EntityNotFoundException(String.format("FindError: School registration non-existent %d", schoolId)); 
		}				
	}	
	 
	public void remove(Long studentId) {				
		try {
		iStudentRepository.deleteById(studentId);		
		 
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException (String.format("Remove-FindError: Student registration non-existent"));
			}
		
		}
		

}
