package com.wizardry.witchcraft.domain.repository;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.wizardry.witchcraft.domain.model.StudentModel;
import com.wizardry.witchcraft.infraestructure.repository.StudentRepositoryImpl;
 

public interface ICustomJpaRepository{
		
	List<StudentModel> listar();
	StudentModel find(Long id);
	StudentModel save(StudentModel studentModel);
	void delete(StudentModel studentModel);
	
	
}
