package com.zup.vehicles.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zup.vehicles.domain.model.UserModel;
 
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{

}
