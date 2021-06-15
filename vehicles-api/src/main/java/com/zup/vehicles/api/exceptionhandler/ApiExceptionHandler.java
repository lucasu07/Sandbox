package com.zup.vehicles.api.exceptionhandler;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> MethodArgumentNotValidExceptionHandler (MethodArgumentNotValidException e) {
		
		Error error = Error.builder()
				.dateHour(LocalDateTime.now())
			
				.message("Argumentos Inválidos: Argumentos não podem ser nulos, vazios ou cpf/email invalidos")
				.build();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(error);
		
	}

}
