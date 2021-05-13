package com.wizardry.witchcraft.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author lucas-SonyBlack
 * Outside of general education, the wizarding world offered specialised schools of learning as well. Such schools
 * include the Academy of Broom Flying, Charm School, Euro-Glyph School of Extraordinary Languages, Merge School of
 * Under-Water Spellage and the Wizarding Academy of Dramatic Arts.
 *
 */

@Entity(name = "wizardingschool")
public class WizardingSchoolModel {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	public String name;
	
	public String location;
	
	public Boolean isTheSchoolSpecialized;

	@Column(name = "rangelocation")
	public String range;
	
	public String dateFounded;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getDateFounded() {
		return dateFounded;
	}

	public void setDateFounded(String dateFounded) {
		this.dateFounded = dateFounded;
	}
	
	public Boolean getIsTheSchoolSpecialized() {
		return isTheSchoolSpecialized;
	}

	public void setIsTheSchoolSpecialized(Boolean isTheSchoolSpecialized) {
		this.isTheSchoolSpecialized = isTheSchoolSpecialized;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WizardingSchoolModel other = (WizardingSchoolModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
