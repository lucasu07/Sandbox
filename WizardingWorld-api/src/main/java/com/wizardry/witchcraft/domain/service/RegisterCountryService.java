package com.wizardry.witchcraft.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.wizardry.witchcraft.domain.exception.EntityInUseException;
import com.wizardry.witchcraft.domain.exception.EntityNotFoundException;
import com.wizardry.witchcraft.domain.model.CountryModel;
import com.wizardry.witchcraft.domain.repository.ICountryRepository;

@Service
public class RegisterCountryService {

	@Autowired
	private ICountryRepository iCountryRepository;
		
	
	public List<CountryModel> listAllCountry(){
		return iCountryRepository.findAll();
	}
	
	public CountryModel findOne (Long id) {
		Optional<CountryModel> countryModel  =iCountryRepository.findById(id);		
		
		if (countryModel.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		 
		
		return 	countryModel.get();
	}
	 
	public CountryModel register(CountryModel countryModel) {
		return iCountryRepository.save(countryModel);	
	}
	 

	
	public void remove(Long id) {
		
		try {
			iCountryRepository.deleteById(id);	
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException(String.format("Country registration non-existent %d", id));
		} catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(String.format("Country registration in use %d", id));			
		}
		
	}
		
}
	
	
	
	
	