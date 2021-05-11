package com.wizardry.witchcraft.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;

import com.wizardry.witchcraft.domain.model.Student;

public interface IStudentRepository extends CrudRepository<Student, Long>{
	
	
}
