package com.wizardry.witchcraft.infraestructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wizardry.witchcraft.domain.model.StateModel;
import com.wizardry.witchcraft.domain.repository.IStateRepository;

@Component
public class StateRepositoryImpl implements IStateRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<StateModel> findAll(){
		List<StateModel> resultList = entityManager.createQuery("from state",StateModel.class).getResultList();
		return resultList;
				}
	@Override
	public StateModel findOne(Long id) {		
		return entityManager.find(StateModel.class,id);
	}
	
	@Transactional
	@Override
	public StateModel registerOne(StateModel stateModel) {		
		return entityManager.merge(stateModel);
	}
	
	@Transactional
	@Override
	public void deleteOne(Long id) {
				
		StateModel stateModel =  entityManager.find(StateModel.class,id);
		if (stateModel==null) {
			throw new EmptyResultDataAccessException(1);
		}
		entityManager.remove(stateModel);
	}
		

}
