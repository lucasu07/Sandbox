package com.wizardry.witchcraft.domain.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

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
		return iWizardingSchoolRepository.findAll();
	}
	
	public WizardingSchoolModel findOne(Long Id) {
		
		try {
			return iWizardingSchoolRepository.findById(Id).get();	
			
		} catch (NoSuchElementException e){
			throw new EntityNotFoundException(String.format("FindError: School registration non-existent %d", Id)); 
		}
	}
	
	public WizardingSchoolModel register(WizardingSchoolModel wizardingSchoolModel) {
		return iWizardingSchoolRepository.save(wizardingSchoolModel);
	}
	
	
	public void remove(Long Id) {
		
		try {
			iWizardingSchoolRepository.deleteById(Id);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException(
				String.format("Remove-FindError: School registration non-existent %d", Id));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(
				String.format("School registration %d cannot be removed, it's in use", Id));
		}
	}
	
}
