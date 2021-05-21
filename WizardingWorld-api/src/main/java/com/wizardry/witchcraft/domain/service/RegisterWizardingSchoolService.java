package com.wizardry.witchcraft.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import com.wizardry.witchcraft.domain.exception.EntityInUseException;
import com.wizardry.witchcraft.domain.exception.EntityNotFoundException;
import com.wizardry.witchcraft.domain.model.WizardingSchoolModel;
import com.wizardry.witchcraft.domain.repository.IWizardingSchoolRepository;

@Service
public class RegisterWizardingSchoolService {
	
	@Autowired
	private IWizardingSchoolRepository iWizardingSchoolRepository;
	
	public List<WizardingSchoolModel> listItAll(){
		return iWizardingSchoolRepository.listItAll();
	}
	
	public WizardingSchoolModel find(Long Id) {
		return iWizardingSchoolRepository.findOne(Id);		 
	}
	
	public WizardingSchoolModel register(WizardingSchoolModel wizardingSchoolModel) {
		return iWizardingSchoolRepository.saveOne(wizardingSchoolModel);
	}
	
	
	public void remove(Long Id) {
		
		try {
			iWizardingSchoolRepository.deleteOne(Id);
			
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException(
				String.format("School registration non-existent %d", Id));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(
				String.format("School registration %d cannot be removed, it's in use", Id));
		}
	}
	
}
