package com.wizardry.witchcraft.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.wizardry.witchcraft.domain.model.StudentModel;

import lombok.Data;
import lombok.NonNull;


/*
 * Classe criada para modelar a representação da resposta no MediaType=application/xml.
*/


@JacksonXmlRootElement(localName = "students")
@Data
public class StudentsRepresentationModel {
	
	@JsonProperty("student")
	@JacksonXmlElementWrapper(useWrapping = false) // Usado para
	@NonNull
	private List<StudentModel> student;

}
