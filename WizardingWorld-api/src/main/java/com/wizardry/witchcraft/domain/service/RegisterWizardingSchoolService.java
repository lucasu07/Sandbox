package com.wizardry.witchcraft.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wizardry.witchcraft.domain.model.WizardingSchoolModel;
import com.wizardry.witchcraft.domain.repository.IWizardingSchoolRepository;

@Service
public class RegisterWizardingSchoolService {
	
	@Autowired
	private IWizardingSchoolRepository iWizardingSchoolRepository;
	
	public List<WizardingSchoolModel> list(){
		return iWizardingSchoolRepository.listItAll();
	}
	
	public WizardingSchoolModel find(Long Id) {
		return iWizardingSchoolRepository.findOne(Id);
		
	}
	
	public WizardingSchoolModel add(WizardingSchoolModel wizardingSchoolModel) {
		return iWizardingSchoolRepository.saveOne(wizardingSchoolModel);
	}
	
	public void remove(Long Id) {
		iWizardingSchoolRepository.deleteOne(Id);
	}
	
	
	

}
