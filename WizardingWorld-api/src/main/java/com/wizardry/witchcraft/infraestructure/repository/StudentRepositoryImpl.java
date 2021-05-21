package com.wizardry.witchcraft.infraestructure.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.wizardry.witchcraft.domain.model.StudentModel;

import com.wizardry.witchcraft.domain.repository.IStudentRepository;


@Component
public class StudentRepositoryImpl implements IStudentRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override 
	public List<StudentModel> listItAll(){ 
		  return  manager.createQuery("from student", StudentModel.class).getResultList();
	  
	}
	
	@Override
	public StudentModel findOne (Long id)	{
		return manager.find(StudentModel.class, id);
		
	}	
	
	 // No contexto do Hibernate quando adicionamos um record e passamos a
	 // propriedade id , o proprio HIBERNATE faz um SELECT e encontrando um record já
	 // no db, faz um UPDATE ao invés de um INSERT.

	@Transactional
	@Override
	public StudentModel saveOne(StudentModel student) {
		return manager.merge(student);
	}

	@Transactional
	@Override
	public void deleteOne(Long id) {
		 
		 StudentModel student = findOne(id);
		 manager.remove(student);		
	}
		
}
