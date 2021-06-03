package com.wizardry.witchcraft.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wizardry.witchcraft.domain.model.WizardingSchoolModel;
 
@Repository
public interface IWizardingSchoolRepository extends JpaRepository<WizardingSchoolModel, Long> {
	

	
}
