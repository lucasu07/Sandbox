package com.wizardry.witchcraft.infraestructure.repository;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.wizardry.witchcraft.domain.model.StudentModel;
import com.wizardry.witchcraft.domain.repository.ICustomStudentRepository;

@Repository(value = "IStudentRepositoryImpl")
public class StudentRepositoryImpl implements ICustomStudentRepository {
	
	@PersistenceContext
	private EntityManager manager;
	
	
	public List<StudentModel> find1(String name
			,Boolean isDadWizard ,Boolean isMomWizard) {
		
		 var parameter = new HashMap<String, Object>(); 
		  StringBuilder str = new StringBuilder();
		  
		  str.append("from student where 0=0 ");
		  
		  if (StringUtils.hasLength(name)) { 
			  str.append("and name like :name ");
			  parameter.put("name", "%"+name+"%");
		  }
		  
		  if (isMomWizard!= null) { 
			  str.append("and isMomWizard = :isMomWizard ");	
			  parameter.put("isMomWizard", isMomWizard);	
		  }
		  
		  if (isDadWizard!= null) { 
			  str.append("and isDadWizard = :isDadWizard ");
			  parameter.put("isDadWizard", isDadWizard);
		  }
		 
		 
		TypedQuery<StudentModel> query = manager.createQuery(str.toString(), StudentModel.class);
		
		parameter.forEach((chave,valor) -> query.setParameter(chave,valor));
		
		return query.getResultList();
				
		
	}
	
	
	//Query dinamica criada para exemplificar o uso do Criteria builder, deixando o código mais
	//
	@Override
	public List<StudentModel> find2(String name
			,Boolean isDadWizard ,Boolean isMomWizard) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<StudentModel> criteria = builder.createQuery(StudentModel.class);
		
		Root<StudentModel> root = criteria.from(StudentModel.class);
		
		var predicates =new ArrayList<Predicate>();
		
		  if (StringUtils.hasText(name)) { 
			  predicates.add(builder.like(root.get("name"), "%"+name+"%"));			  
		  }
		  
		  if (isMomWizard!= null) { 
			  predicates.add(builder.equal(root.<Boolean> get("isMomWizard"), isMomWizard));
		  }
		  
		  if (isDadWizard!= null) { 
			  predicates.add(builder.equal(root.<Boolean> get("isDadWizard"),isDadWizard));
		  }
		   
		criteria.where(predicates.toArray( new Predicate[0]));
				
		TypedQuery<StudentModel> query = manager.createQuery(criteria);
				
		 
		return query.getResultList();
				
		
	}	

} 