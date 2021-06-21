package com.zup.vehicles.client.fipe.endpoint;

 
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
 
import com.zup.vehicles.client.fipe.dto.requests.CarModelDto;
import com.zup.vehicles.client.fipe.dto.requests.ModelDto;
import com.zup.vehicles.client.fipe.dto.requests.PriceDto;
 

@FeignClient(name = "${feign.tabela_fipe}" , url = "${feign.url_tabela_fipe}")
public interface GetFipeModels {

	@GetMapping("/carros/marcas")
	public List<CarModelDto> getCarBrandCode();	
		 
	@GetMapping(path = "/carros/marcas/{id_brand}/modelos"
			, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ModelDto getCarModels(@PathVariable(name ="id_brand") String id);	
	
	@GetMapping(path = "/carros/marcas/{id_brand}/modelos/{id_model}/anos"
			,consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<CarModelDto> getCarYears(
			@PathVariable(name ="id_brand") String id_brand
			,@PathVariable(name ="id_model") String id_model);	
	
	@GetMapping(path = "/carros/marcas/{id_brand}/modelos/{id_model}/anos/{id_year}"
			,consumes=MediaType.APPLICATION_JSON_VALUE)	
	public PriceDto getCarPrice(
			@PathVariable(name ="id_brand") String id_brand
			,@PathVariable(name ="id_model") String id_model
			,@PathVariable(name ="id_year") String id_year);	
 
	
}
 