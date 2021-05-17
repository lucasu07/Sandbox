package com.wizardry.witchcraft.domain.repository;


import java.util.List;

import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.wizardry.witchcraft.domain.model.StudentModel;

@Repository
public interface IStudentRepository {
	
	List<StudentModel> listar();
	StudentModel findCustom(Long id);
	StudentModel saveCustom(StudentModel studentModel);
	void delete(StudentModel studentModel);
		
	
}
