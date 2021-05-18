package com.wizardry.witchcraft.domain.repository;

 
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wizardry.witchcraft.domain.model.WizardingSchoolModel;
 

@Repository
public interface IWizardingSchoolRepository {
	
	List<WizardingSchoolModel> listItAll();
	WizardingSchoolModel findOne(Long Id);
	WizardingSchoolModel saveOne(WizardingSchoolModel wizardingschoolModel);
	void deleteOne (Long id);
	
}
