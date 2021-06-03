package com.wizardry.witchcraft.infraestructure.repository;
 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.wizardry.witchcraft.domain.model.StudentModel;
import com.wizardry.witchcraft.domain.repository.ICustomStudentRepository;

@Repository(value = "IStudentRepositoryImpl")
public class StudentRepositoryImpl implements ICustomStudentRepository {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<StudentModel> find2(String name){
		
		var jpql = "from student where name like :name";
		
		return manager.createQuery(jpql, StudentModel.class)
				.setParameter("name", "%"+ name +"%")
				.getResultList();
		
	}

} 