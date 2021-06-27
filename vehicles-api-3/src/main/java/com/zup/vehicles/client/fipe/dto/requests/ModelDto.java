package com.zup.vehicles.client.fipe.dto.requests;

import java.util.List;

import lombok.Data;

@Data
public class ModelDto {

	private List<CarModelDto> modelos;
	
	private List<CarModelDto> anos;
}
