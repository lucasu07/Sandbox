package com.wizardry.witchcraft.infraestructure.repository;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.wizardry.witchcraft.domain.model.StudentModel;
import com.wizardry.witchcraft.domain.repository.ICustomJpaRepository;


@Component
public class StudentRepositoryImpl implements ICustomJpaRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<StudentModel> listar(){
		return manager.createQuery("from student", StudentModel.class).getResultList();
		
	}
	
	@Override
	public StudentModel find (Long id)	{
		return manager.find(StudentModel.class, id);
		
	}	
	
	/*
	 * No contexto do Hibernate quando adicionamos um record e passamos a
	 * propriedade id , o proprio HIBERNATE faz um SELECT e encontrando um record já
	 * no db, faz um UPDATE ao invés de um INSERT.
	 */
	
	@Transactional
	@Override
	public StudentModel save(StudentModel student) {
		return manager.merge(student);
		
	}
	
	 @Transactional
	 @Override
	public void delete(StudentModel student) {
		student = find(student.getId());
		 manager.remove(student);
		
	}
	
	
		
}
