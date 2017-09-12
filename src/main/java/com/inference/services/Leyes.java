package com.inference.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inference.entity.Implicacion;
import com.inference.entity.Proposicion;
import com.inference.repository.ImplicacionDAO;
import com.inference.repository.ProposicionDAO;

@Service
public class Leyes implements ILeyes {

	@Autowired
	private ImplicacionDAO implicacionDao;
	
	@Autowired
	private ProposicionDAO proposicionDao;

	@Override
	public void modusPones(Proposicion p, Proposicion q) {
		Implicacion implicacion = implicacionDao.findFirstByPreposicionIdAndImplicacionId(p.getId(), q.getId());
		if (implicacion != null) {
			Boolean valor = p.getValor();
			q.setValor(valor);
		}
	}

	@Override
	public void modusTollen(Proposicion p, Proposicion q) {
		Implicacion implicacion = implicacionDao.findFirstByPreposicionIdAndImplicacionId(p.getId(), q.getId());
		if (implicacion != null) {
			Boolean valor = p.getValor();
			q.setValor(valor);
		}
	}

	@Override
	public Boolean simplificacion(Proposicion p, Proposicion q) {

		return p.getValor() || q.getValor();

	}

	/**
	 * metodo para la ley de adjuncion
	 * 
	 */
	@Override
	public Boolean adjuncion(Proposicion p, Proposicion q) {

		return p.getValor() && q.getValor();

	}

	@Override
	public Boolean absurdo(Proposicion p) {
		return p.getValor() && !p.getValor();

	}

	
	@Override
	public Boolean dobleNegacion(Proposicion p) {
		return !(!p.getValor());

	}

	@Override
	public Boolean silogismoHipotetico(Proposicion p, Proposicion q, Proposicion r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean adicion(Proposicion p, Proposicion q) {
		return p.getValor() || q.getValor();
	}

	@Override
	public Boolean contraposicion(Proposicion p, Proposicion q) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean dMorgan(Proposicion p, Proposicion q) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean dobleImplicacion(Proposicion p, Proposicion q) {
		// TODO Auto-generated method stub
		return false;
	}

}
