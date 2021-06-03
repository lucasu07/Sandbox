package com.wizardry.witchcraft.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wizardry.witchcraft.domain.model.CountryModel;

@Repository
public interface ICountryRepository extends JpaRepository<CountryModel, Long>{
	

	
}
