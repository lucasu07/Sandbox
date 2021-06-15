package com.zup.vehicles.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.vehicles.domain.exception.EntityInvalid;
import com.zup.vehicles.domain.model.UserModel;

import com.zup.vehicles.domain.service.UserService;

 
@RestController
@RequestMapping(path = "/usuarios")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<UserModel> listAllUser() {
		return userService.listAllUser();	
	}	
	
	@PostMapping
	public UserModel register(@RequestBody @Valid UserModel userModel) {
			return userService.register(userModel);
		
	}
	

	
}