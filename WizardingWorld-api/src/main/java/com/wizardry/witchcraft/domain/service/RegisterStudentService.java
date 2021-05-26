package com.wizardry.witchcraft.domain.service;

import java.util.List;

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
		return iStudentRepository.listItAll();		
	}	
	
	public StudentModel findOne(Long id) {
		
		try {
			return iStudentRepository.findOne(id);	
		
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException (String.format("FindError: Student registration non-existent"));
		
		}					
	}	
	
	public StudentModel register(StudentModel studentModel) {		
		try {

			 Long schoolId = studentModel.getWizardingSchoolModel().getId();
			 WizardingSchoolModel wizardingSchoolModel = iWizardingSchoolRepository
						.findOne(schoolId);
			 studentModel.setWizardingSchoolModel(wizardingSchoolModel);

				return iStudentRepository.saveOne(studentModel);	
			 
		} catch (EmptyResultDataAccessException e) {
			throw new EntitySchoolNotFoundException (String.format("FindSchoolError: School registration non-existent"));
		}				
	}	
	 
	public void remove(Long studentId) {				
		try {
		iStudentRepository.deleteOne(studentId);		
		 
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException (String.format("Remove-FindError: Student registration non-existent"));
			}
		
		}
		

}
