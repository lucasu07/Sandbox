package com.wizardry.witchcraft.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Data
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "state")
public class StateModel {
	

	@EqualsAndHashCode.Include
	@Id	  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "country_id")
	public CountryModel countryModel;
		
	//@JsonProperty("nome do aluno")
	@Column(nullable= false, length = 50) 
	public String name;

	

	
}
