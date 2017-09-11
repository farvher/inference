package com.inference.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inference.entity.Proposicion;
@Repository
public interface ProposicionDAO  extends CrudRepository<Proposicion, Long>{
	
	Proposicion findFirstByDefinicion(String definicion);

}
