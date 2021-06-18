package com.zup.vehicles.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.vehicles.domain.exception.EntityInvalid;
import com.zup.vehicles.domain.model.UserModel;
import com.zup.vehicles.domain.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserModel register(UserModel userModel) {

		Optional<UserModel> optionalUserEmail = userRepository.findByEmail(userModel.getEmail());
		Optional<UserModel> optionalUserCpf = userRepository.findByCpf(userModel.getCpf());

		if (optionalUserEmail.isPresent()) { 
			throw new EntityInvalid("Email already registered");
		}

		if (optionalUserCpf.isPresent()) { 
			throw new EntityInvalid("CPF already registered!");
		}

		return userRepository.save(userModel);

	}

	public List<UserModel> listAllUser() {
		return userRepository.findAll();	
	}


}


