package com.wizardry.witchcraft.domain.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.wizardry.witchcraft.domain.model.StudentModel;

@Repository
public interface IStudentRepository 
		extends JpaRepository<StudentModel, Long>, ICustomStudentRepository {
	

	
	  List<StudentModel> queryByName(String name, @Param ("id") Long school);
	  
	  List<StudentModel> queryFirstByNameContaining(String name);
	  
	  List<StudentModel> queryTop2ByNameContaining(String name);
	  
	  int countByWizardingSchoolModelId(Long school);
	 
	  
}

//o Jpa cria uma inplementação em que tudo o que vem depois de By é a 
//propriedade a ser procurada e tudo o que está entre Find e By é ignorado.

	//@Query("from student where name like %:name% and wizardingSchoolModel.id = :id")
	