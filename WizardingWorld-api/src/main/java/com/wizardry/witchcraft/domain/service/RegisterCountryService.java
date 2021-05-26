package com.wizardry.witchcraft.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.wizardry.witchcraft.domain.exception.EntityInUseException;
import com.wizardry.witchcraft.domain.exception.EntityNotFoundException;
import com.wizardry.witchcraft.domain.model.CountryModel;
import com.wizardry.witchcraft.domain.model.StateModel;
import com.wizardry.witchcraft.domain.repository.ICountryRepository;
import com.wizardry.witchcraft.domain.repository.IStateRepository;

@Service
public class RegisterCountryService {

	@Autowired
	private ICountryRepository iCountryRepository;
		
	
	public List<CountryModel> listAllCountry(){
		return iCountryRepository.findAll();
	}
	
	public CountryModel findOne (Long id) {
		CountryModel countryModel  =iCountryRepository.findOne(id);		
		
		if (countryModel ==null) {
			throw new EmptyResultDataAccessException(1);
		}
		return 	countryModel;
	}
	 
	public CountryModel register(CountryModel countryModel) {
		return iCountryRepository.registerOne(countryModel);	
	}
	 

	
	public void remove(Long id) {
		
		try {
			CountryModel countryModel  = findOne(id);		
			iCountryRepository.deleteOne(id);	
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException(String.format("Country registration non-existent %d", id));
		} catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(String.format("Country registration in use %d", id));			
		}
		
	}
		
}
	
	
	
	
	