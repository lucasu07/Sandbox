package com.wizardry.witchcraft.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wizardry.witchcraft.domain.model.StudentModel;
import com.wizardry.witchcraft.domain.repository.IStudentRepository;

@Service
public class RegisterStudentService {
	
	@Autowired
	private IStudentRepository iStudentRepository;
	
	public List<StudentModel> list(){
		return iStudentRepository.listItAll();		
	}	
	
	public StudentModel find(Long id) {
		return iStudentRepository.findOne(id);
	}	
	
	public StudentModel register(StudentModel studentModel) {		
		return iStudentRepository.saveOne(studentModel);		
	}	
	 
	public void remove(Long studentId) {		
		iStudentRepository.deleteOne(studentId);		
	}

}
