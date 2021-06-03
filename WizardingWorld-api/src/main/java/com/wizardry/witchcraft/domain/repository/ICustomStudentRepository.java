package com.wizardry.witchcraft.domain.repository;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;

import com.wizardry.witchcraft.domain.model.StudentModel;

@NoRepositoryBean
public interface ICustomStudentRepository {

	List<StudentModel> find2(String name);

}