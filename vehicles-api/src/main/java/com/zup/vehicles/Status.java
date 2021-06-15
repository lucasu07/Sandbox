package com.zup.vehicles;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class Status {
	
	@GetMapping(path = "/status")
	@ResponseBody
	public String online() {
		
		return "'Hello, You are a Wizard Harry'";
				
	} 

}
