package com.inference.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.inference.entity.Implicacion;
import com.inference.entity.Proposicion;
import com.inference.repository.ImplicacionDAO;

public class Leyes {
	
	@Autowired
	private ImplicacionDAO implicacionDao;
	
	public void modusPones(Proposicion p, Proposicion q){
		Implicacion implicacion = implicacionDao.findFirstByPreposicionIdAndImplicacionId(p.getId(), q.getId());
		if (implicacion!=null){
			Boolean valor = p.getValor();
			q.setValor(valor);
		}
	}
	public void modusTollen(Proposicion p, Proposicion q){
		Implicacion implicacion = implicacionDao.findFirstByPreposicionIdAndImplicacionId(p.getId(), q.getId());
		if (implicacion!=null){
			Boolean valor = p.getValor();
			q.setValor(valor);
		}
	}
	

}
