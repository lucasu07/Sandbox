package com.wizardry.witchcraft.infraestructure.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.wizardry.witchcraft.WizardingWorldApiApplication;
import com.wizardry.witchcraft.domain.model.StudentModel;
import com.wizardry.witchcraft.domain.repository.ICustomJpaRepository;
import com.wizardry.witchcraft.infraestructure.repository.StudentRepositoryImpl;


public class QueryStudentMain {
	
	 
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(WizardingWorldApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		ICustomJpaRepository iCustomJpaRepository = applicationContext.getBean(StudentRepositoryImpl.class);
		
		
		List<StudentModel> students = iCustomJpaRepository.listar();
		
		for(StudentModel student: students) {
			System.out.println(student.getName());			
			
		}
		
	}

}
