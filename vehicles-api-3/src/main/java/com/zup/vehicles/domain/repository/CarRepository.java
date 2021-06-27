package com.zup.vehicles.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zup.vehicles.domain.model.CarModel;

@Repository
public interface CarRepository extends JpaRepository<CarModel,Long>{

	@Query("from car where userModel.id = :id")
	List<CarModel> queryByUser(@Param("id") Long user);
	 
	
}
