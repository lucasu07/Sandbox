package com.zup.vehicles.client.fipe.endpoint;

 
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
 
import com.zup.vehicles.client.fipe.dto.requests.CarModelDto;
import com.zup.vehicles.client.fipe.dto.requests.ModelDto;


@FeignClient(name = "${feign.tabela_fipe}" , url = "${feign.url_tabela_fipe}")
public interface GetFipeModels {

	@GetMapping("/carros/marcas")
	public List<CarModelDto> getCarBrandCode();	
		 
	@GetMapping(path = "/carros/marcas/{id}/modelos", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ModelDto getCarModels(@PathVariable(name ="id") String id);	
 
}
