package com.wizardry.witchcraft.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;
import lombok.EqualsAndHashCode;
 

//@JsonRootName("student")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "student")
//@Table(name = "")
public class StudentModel {
	
	
	@EqualsAndHashCode.Include
	@Id	  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	//@JsonIgnore
	@ManyToOne 
	@JoinColumn(name = "wizarding_school_id")
	public WizardingSchoolModel wizardingSchoolModel;
		
	//@JsonProperty("nome do aluno")
	
	
	@NotBlank(message = "Valid name required: NOTNULL,NOTBLANK,NOTEMPTY")
	@Column(nullable= false, length = 50) 
	public String name;
	
	//@UniqueElements(message = "CPF already registered")
	@Column(unique = true)
	@CPF
	public String nationalServiceNumber;
	
	@NotBlank(message = "Valid name required: NOTNULL,NOTBLANK,NOTEMPTY")
	public String familyName;
		
	public Boolean isMomWizard;
		
	public Boolean isDadWizard;
	
	//@UniqueElements(message = "Email already registered")
	@Column(unique = true)
	@NotNull
	@Email(message = "Valid email required")
	public String email;
	
	@Past
	public LocalDate dateBirth;

	
}
