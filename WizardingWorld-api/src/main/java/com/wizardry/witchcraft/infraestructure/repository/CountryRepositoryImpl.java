package com.wizardry.witchcraft.infraestructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wizardry.witchcraft.domain.model.CountryModel;
import com.wizardry.witchcraft.domain.model.StateModel;
import com.wizardry.witchcraft.domain.repository.ICountryRepository;

@Component
public class CountryRepositoryImpl implements ICountryRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<CountryModel> findAll() {
		List<CountryModel> resultList = entityManager
				.createQuery("from country",CountryModel.class).getResultList();
		return resultList;
	}

	@Override
	public CountryModel findOne(Long id) {
		return entityManager.find(CountryModel.class,id);
		
	}

	@Transactional
	@Override
	public CountryModel registerOne(CountryModel countryModel) {
		return entityManager.merge(countryModel);
	}

	@Transactional
	@Override
	public void deleteOne(Long id) {
		CountryModel countryModel =  entityManager.find(CountryModel.class,id);
		if (countryModel==null) {
			throw new EmptyResultDataAccessException(1);
		}
		entityManager.remove(countryModel);
	}
		
}
	
	 
		