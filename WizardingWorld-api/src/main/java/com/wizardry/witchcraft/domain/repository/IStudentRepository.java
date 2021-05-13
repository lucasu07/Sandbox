package com.wizardry.witchcraft.domain.repository;

import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.wizardry.witchcraft.domain.model.StudentModel;

@Repository
public interface IStudentRepository extends CrudRepository<StudentModel, Id>{
	
	
}
