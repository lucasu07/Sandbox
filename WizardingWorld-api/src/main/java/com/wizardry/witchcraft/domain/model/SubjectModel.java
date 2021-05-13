package com.wizardry.witchcraft.domain.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name  ="subject")
public class SubjectModel {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long Id;
	
	public String name;
	
	public String yearClass;
	
	public String startDate;
	
	public String endDate;


}
