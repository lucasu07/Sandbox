package com.zup.vehicles.api.exceptionhandler;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Error {

	private String problem;
	private String message;
	private LocalDateTime dateHour;

	public Error(String problem, String message, LocalDateTime dateHour) {
		this.problem = problem;
		this.message = message;
		this.dateHour = dateHour;
	} 

}
 