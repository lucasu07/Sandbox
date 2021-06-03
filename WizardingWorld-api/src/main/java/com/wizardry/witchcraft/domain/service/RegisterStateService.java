package com.wizardry.witchcraft.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.wizardry.witchcraft.domain.exception.EntityInUseException;
import com.wizardry.witchcraft.domain.exception.EntityNotFoundException;
import com.wizardry.witchcraft.domain.model.StateModel;
import com.wizardry.witchcraft.domain.model.CountryModel;

import com.wizardry.witchcraft.domain.repository.IStateRepository;

@Service
public class RegisterStateService {

	@Autowired
	private IStateRepository iStateRepository;
 	
	@Autowired
	private RegisterCountryService registerCountryService;
	
	
	public List<StateModel> listAllStates(){
		return iStateRepository.findAll();
	}
	
	public StateModel findOne (Long id) {
		Optional<StateModel>  stateModel  =iStateRepository.findById(id);		
		
		if (stateModel.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return 	stateModel.get();
	}
	 
	
	
	public StateModel register(StateModel stateModel) {
		
		try {
			Long countryId = stateModel.getCountryModel().getId();
			CountryModel countryModel =  registerCountryService.findOne(countryId);
			stateModel.setCountryModel(countryModel);
			return iStateRepository.save(stateModel);
			 
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException (String.format("FindCountryError: Country registration non-existent"));
		}	
		
	}
	

	
	public void remove(Long id) {
		
		try {
			
			iStateRepository.deleteById(id);	
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException(String.format("State registration non-existent %d", id));
		} catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(String.format("State registration in use %d", id));			
		}
		
	}
		
}
	
	
	
	
	