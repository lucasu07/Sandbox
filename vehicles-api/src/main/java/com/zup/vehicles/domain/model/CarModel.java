package com.zup.vehicles.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Repository;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "car")
public class CarModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@ManyToOne 
	@JoinColumn(name = "user_id")
	private UserModel userModel;
	
	@NotBlank
	@Column(length = 60,nullable = false)
	private String brand;
	
	@NotBlank
	@Column(length = 50,nullable = false)
	private String model;
	
	@NotNull
	@Column(length = 50,nullable = false)
	private int Ano;
	
	private String dayOfWeek;
	
	private Boolean isCarActive;
	

	 
		
}
