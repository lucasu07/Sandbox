package com.wizardry.witchcraft.domain.repository;

import java.util.List;

import com.wizardry.witchcraft.domain.model.CountryModel;


public interface ICountryRepository {
	
	List<CountryModel> findAll();
	CountryModel findOne(Long id);
	CountryModel registerOne(CountryModel countryModel);
	void deleteOne(Long id);
	
}
