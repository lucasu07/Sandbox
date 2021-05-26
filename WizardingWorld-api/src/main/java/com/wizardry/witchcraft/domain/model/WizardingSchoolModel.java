package com.wizardry.witchcraft.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * @author lucas-SonyBlack
 * Outside of general education, the wizarding world offered specialised schools of learning as well. Such schools
 * include the Academy of Broom Flying, Charm School, Euro-Glyph School of Extraordinary Languages, Merge School of
 * Under-Water Spellage and the Wizarding Academy of Dramatic Arts.
 *
 */

@Data
@EqualsAndHashCode( onlyExplicitlyIncluded = true)
@Entity(name = "wizardingschool")
public class WizardingSchoolModel {	
	
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	
	public String name;
	
	public String location;
	 
	//@JsonIgnore
	public Boolean isTheSchoolSpecialized;

	@Column(name = "rangeLocation")
	public String rangeLocation;
	
	public String dateFounded;


}
