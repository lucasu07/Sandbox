package com.zup.zupantan.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.zupantan.domain.model.VacinaModel;
import com.zup.zupantan.domain.repository.VacinaRepository;

@Service
public class CadastroVacinaService {
	
	@Autowired
	private VacinaRepository vacinaRepository;
	
	
	public VacinaModel salvar(VacinaModel vacina) {
		return vacinaRepository.save(vacina);
	}

}
