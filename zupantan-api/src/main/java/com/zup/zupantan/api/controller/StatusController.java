package com.zup.zupantan.api.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
	
	@GetMapping(path = "/api/status")
	public String check() {
		return "online";
	}

}
