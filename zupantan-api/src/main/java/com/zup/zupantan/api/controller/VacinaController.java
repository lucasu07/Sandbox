package com.zup.zupantan.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zup.zupantan.domain.model.VacinaModel;
import com.zup.zupantan.domain.repository.VacinaRepository;

import com.zup.zupantan.domain.service.CadastroVacinaService;

@RestController
public class VacinaController {
	
	@Autowired
	private CadastroVacinaService cadastroVacinaService;
	
	@Autowired
	private VacinaRepository repository;
	
	@GetMapping(path="/api/vacina/{id}")
	public ResponseEntity<VacinaModel> consultar(@PathVariable("id") Long id){
		
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/api/vacina/")
	public VacinaModel salvar (@RequestBody VacinaModel vacina) {
		return cadastroVacinaService.salvar(vacina);
	}
		
	

}
