package com.wizardry.witchcraft.infraestructure.jpa;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.wizardry.witchcraft.WizardingWorldApiApplication;
import com.wizardry.witchcraft.domain.model.StudentModel;
import com.wizardry.witchcraft.infraestructure.repository.StudentRepositoryImpl;

public class DeleteStudentMain {
	
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(WizardingWorldApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		StudentRepositoryImpl studentRepositoryImpl = applicationContext.getBean(StudentRepositoryImpl.class);
		
		
		StudentModel student = new StudentModel();
		student.setId(1L);
		
		studentRepositoryImpl.delete(student);
	}

}
