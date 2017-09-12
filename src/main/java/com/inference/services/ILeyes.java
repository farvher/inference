package com.inference.services;

import com.inference.entity.Implicacion;
import com.inference.entity.Proposicion;

public interface ILeyes {

	public void modusPones(Proposicion p, Proposicion q);

	/**
	 * metodo para la modus tollens
	 * 
	 */
	public void modusTollen(Proposicion p, Proposicion q);

	/**
	 * metodo para la ley de simplificacion
	 * 
	 * @return
	 * 
	 */
	public Boolean simplificacion(Proposicion p, Proposicion q);

	/**
	 * metodo para la ley de adjuncion
	 * 
	 */
	public Boolean adjuncion(Proposicion p, Proposicion q);

	/**
	 * metodo para la ley de lo absurdo
	 * 
	 */
	public Boolean absurdo(Proposicion p);

	/**
	 * metodo para la ley de lo absurdo
	 * 
	 */
	public Boolean dobleNegacion(Proposicion p);

	/**
	 * metodo para silogismo hipotetico
	 * 
	 */
	public Boolean silogismoHipotetico(Proposicion p , Proposicion q, Proposicion r);
	
	
	/**
	 * metodo para la ley de lo absurdo
	 * 
	 */
	public Boolean adicion(Proposicion p , Proposicion q);
	
	/**
	 * metodo para contraposicion
	 * 
	 */
	public Boolean contraposicion(Proposicion p , Proposicion q);
	
	/**
	 * metodo para contraposicion
	 * 
	 */
	public Boolean dMorgan(Proposicion p , Proposicion q);
	
	/**
	 * metodo para doble implicacion
	 * 
	 */
	public Boolean dobleImplicacion(Proposicion p , Proposicion q);
	
}
