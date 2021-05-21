package com.wizardry.witchcraft.domain.repository;


import java.util.List;

import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.wizardry.witchcraft.domain.model.StudentModel;

@Repository
public interface IStudentRepository {
	
	List<StudentModel> listItAll();
	StudentModel findOne(Long id);
	StudentModel saveOne(StudentModel studentModel);
	void deleteOne(Long Id);
	
}
