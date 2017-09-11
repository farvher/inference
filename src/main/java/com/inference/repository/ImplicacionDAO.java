package com.inference.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inference.entity.Implicacion;

@Repository
public interface ImplicacionDAO extends CrudRepository<Implicacion, Long> {

	Implicacion findFirstByPreposicionIdAndImplicacionId(Long pid, Long iid);
	
	List<Implicacion> findByPreposicionId(Long pid);
	List<Implicacion> findByImplicacionId(Long pid);

}
