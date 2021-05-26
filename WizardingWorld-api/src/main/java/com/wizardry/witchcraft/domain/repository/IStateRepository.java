package com.wizardry.witchcraft.domain.repository;

import java.util.List;

import com.wizardry.witchcraft.domain.model.StateModel;

public interface IStateRepository {
	
	List<StateModel> findAll();
	StateModel findOne(Long id);
	StateModel registerOne(StateModel stateModel);
	void deleteOne(Long id);
	
}
