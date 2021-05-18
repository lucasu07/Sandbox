package com.zup.zupantan.domain.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zup.zupantan.domain.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{
	
	Optional<UsuarioModel> findByEmail(String email);
	Optional<UsuarioModel> findByCpf(String cpf);
}
 