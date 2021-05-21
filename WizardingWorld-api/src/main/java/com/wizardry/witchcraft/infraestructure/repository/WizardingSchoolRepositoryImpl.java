package com.wizardry.witchcraft.infraestructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wizardry.witchcraft.domain.model.WizardingSchoolModel;
import com.wizardry.witchcraft.domain.repository.IWizardingSchoolRepository;

@Component
public class WizardingSchoolRepositoryImpl implements IWizardingSchoolRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<WizardingSchoolModel> listItAll(){
		 return manager.createQuery("from wizardingschool",WizardingSchoolModel.class).getResultList();
	}
	
	@Override
	public WizardingSchoolModel findOne(Long Id) {
		return manager.find(WizardingSchoolModel.class, Id);		
	}
	
		
	@Transactional
	@Override
	public WizardingSchoolModel saveOne(WizardingSchoolModel wizardingschoolModel) {
		return manager.merge(wizardingschoolModel);
	}
	
	@Transactional
	@Override
	public void deleteOne (Long id) {
		
		WizardingSchoolModel wizardingschoolModel = findOne(id);
		
		if(wizardingschoolModel ==null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(wizardingschoolModel);				
	}
	
	
}
