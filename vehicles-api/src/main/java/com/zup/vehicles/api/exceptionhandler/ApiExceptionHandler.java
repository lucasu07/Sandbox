package com.zup.vehicles.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.zup.vehicles.domain.exception.EntityInvalid;

import feign.FeignException;

@ControllerAdvice
public class ApiExceptionHandler {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(MethodArgumentNotValidException.class) 
	public 	ResponseEntity<?> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {

		List<ObjectError> globalErrors = e.getBindingResult().getGlobalErrors();
		List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
		List<Error> erroResponses = new ArrayList<>();

		globalErrors.forEach(erro -> {
			Error error = Error.builder() 
					.problem("GlobalError")
					.dateHour(LocalDateTime.now())
					.message(getErrorMessage(erro)) 
					.build();
			erroResponses.add(error);
		});

		fieldErrors.forEach(erro -> {
			Error error = Error.builder()
					.problem(erro.getField())
					.dateHour(LocalDateTime.now())
					.message(getErrorMessage(erro)) 
					.build();

			erroResponses.add(error);
		});

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroResponses);

	}

	@ExceptionHandler(EntityInvalid.class) 
	public ResponseEntity<?> EntityInvalidHandler (EntityInvalid e) {

		Error error = Error.builder() 
				.problem("Invalid parameter")
				.dateHour(LocalDateTime.now())
				.message(e.getMessage()) 
				.build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	
	@ExceptionHandler(FeignException.class) 
	public  ResponseEntity<?> FeignStatusExceptionHandler (FeignException e, HttpServletResponse response) {
		Error error = Error.builder() 
				.problem("Year, Model or Brand Not Found")
				.dateHour(LocalDateTime.now())
				.message(e.getMessage()) 
				.build();
		
         
        return ResponseEntity.status(e.status()).body(error);

    }


	
	private String getErrorMessage(ObjectError error) {
		return messageSource.getMessage(error, LocaleContextHolder.getLocale());
	}
}
