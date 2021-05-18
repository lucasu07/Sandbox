package com.zup.zupantan.domain.service;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.zup.zupantan.domain.exception.NegocioException;
import com.zup.zupantan.domain.model.UsuarioModel;
import com.zup.zupantan.domain.repository.UsuarioRepository;

@Service
public class CadastroUsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EntityManager manager;
	
	@Transactional
	public  UsuarioModel salvar ( UsuarioModel usuario) {
		
		 manager.detach(usuario);
		
		Optional<UsuarioModel> emailExistente = usuarioRepository.findByEmail(usuario.getEmail());
		Optional<UsuarioModel> cpfExistente = usuarioRepository.findByCpf(usuario.getCpf());
		
		
		if ( (emailExistente.isPresent() && !emailExistente.get() .equals(usuario)) || 
				(cpfExistente.isPresent() && !cpfExistente.get() .equals(usuario))) {
		
			 throw new NegocioException(
					 String.format("Esse usuario já está cadastrado CPF:%s, EMAIL: %s",usuario.getCpf(),usuario.getEmail()));
			
		}
		
				
		return usuarioRepository.save(usuario);
	

}}
