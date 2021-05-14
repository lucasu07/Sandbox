package com.wizardry.witchcraft.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "student")
//@Table(name = "")
public class StudentModel {
	
	/* 
	 * public Student (Long id, String name, String familyName, String email) {
	 * this.id = id; this.name = name; this.familyName = familyName; this.email =
	 * email; }
	 */ 
	
	@EqualsAndHashCode.Include
	@Id	  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@ManyToOne
	@JoinColumn(name = "wizarding_school_id")
	public WizardingSchoolModel wizardingSchoolModel;
	
	@Column(nullable= false, length = 50) 
	public String name;
	
	public String nationalServiceNumber;
	
	public String familyName;
	
	public Boolean isMomWizard;
	
	public Boolean isDadWizard;

	public String email;
	
	public String DateBirth;


	
}
