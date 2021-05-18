package com.zup.zupantan.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zup.zupantan.domain.model.VacinaModel;

@Repository
public interface VacinaRepository extends CrudRepository<VacinaModel, Long> {

}
