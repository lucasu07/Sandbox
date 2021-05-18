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

import com.zup.zupantan.domain.repository.UsuarioRepository;
import com.zup.zupantan.domain.service.CadastroUsuarioService;
import com.zup.zupantan.domain.model.UsuarioModel;

@RestController
public class UsuarioController {
	
	@Autowired
	public CadastroUsuarioService cadastroUsuario;
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping(path="/api/usuario/{id}")
	public ResponseEntity<UsuarioModel>  consultar(@PathVariable("id") Long id) {
		
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
		
	}
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/api/usuario/")
	public UsuarioModel salvar(@RequestBody UsuarioModel usuario) {
		
		return cadastroUsuario.salvar (usuario)	;
	}
}
