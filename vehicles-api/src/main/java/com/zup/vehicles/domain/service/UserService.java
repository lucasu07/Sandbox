package com.zup.vehicles.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.vehicles.domain.model.UserModel;
import com.zup.vehicles.domain.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserModel register(UserModel userModel) {
		return userRepository.save(userModel);
	
	}
	
	public List<UserModel> listAllUser() {
		return userRepository.findAll();	
	}
		
}


