package com.wizardry.witchcraft.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

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
	@Column(nullable= false, length = 50) 
	public String name;
		
	public String nationalServiceNumber;
	
	public String familyName;
		
	public Boolean isMomWizard;
		
	public Boolean isDadWizard;

	public String email;
		
	public String dateBirth;

	
}
