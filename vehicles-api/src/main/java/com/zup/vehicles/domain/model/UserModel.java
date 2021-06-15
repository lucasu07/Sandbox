package com.zup.vehicles.domain.model;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name = "user")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(length = 50,nullable = false)
	private String name;
	
	@NotNull
	@Email
	@Column(length = 50,nullable = false)
	private String email;
	
	//@CPF
	@Column(length = 11,nullable = false)
	private String cpf;
	
	@Past
	@NotNull
	@Column(nullable = false)
	private LocalDate birthDate;

}
