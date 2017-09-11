package com.inference.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="implicacion")
public class Implicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	Long preposicionId;

	Long implicacionId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPreposicionId() {
		return preposicionId;
	}

	public void setPreposicionId(Long preposicionId) {
		this.preposicionId = preposicionId;
	}

	public Long getImplicacionId() {
		return implicacionId;
	}

	public void setImplicacionId(Long implicacionId) {
		this.implicacionId = implicacionId;
	}


	
}
