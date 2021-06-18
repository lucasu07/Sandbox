package com.zup.vehicles.api.validator;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.zup.vehicles.domain.model.UserModel;
import com.zup.vehicles.domain.service.UserService;


@Component
public class UserValidator implements Validator{
	

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> aClass) {
		return UserModel.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required");
		// 1
		if (errors.hasErrors()) {
			return;
		}

	}

}
