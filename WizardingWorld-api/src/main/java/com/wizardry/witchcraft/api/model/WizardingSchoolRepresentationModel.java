package com.wizardry.witchcraft.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.wizardry.witchcraft.domain.model.WizardingSchoolModel;

import lombok.Data;
import lombok.NonNull;


/*
 * Classe criada para modelar a representação da resposta no MediaType=application/xml.
*/


@JacksonXmlRootElement(localName = "wizardingSchool")
@Data
public class WizardingSchoolRepresentationModel {
	
	@JsonProperty("school")
	@JacksonXmlElementWrapper(useWrapping = false) // Usado para truncar o elemento intermediário usado pela
	@NonNull									   //representação application/xml
	private List<WizardingSchoolModel> schools;

}
