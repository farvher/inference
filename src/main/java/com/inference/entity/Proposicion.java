package com.inference.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proposicion")
public class Proposicion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID")
	Long id;

	@Column(name ="DEFINICION")
	String definicion;

	@Column(name ="VALOR")
	Boolean valor;

	@Column(name ="TIENEVALOR")
	Boolean tieneValor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDefinicion() {
		return definicion;
	}

	public void setDefinicion(String definicion) {
		this.definicion = definicion;
	}

	public Boolean getValor() {
		return valor;
	}

	public void setValor(Boolean valor) {
		this.valor = valor;
	}

	public Boolean getTieneValor() {
		return tieneValor;
	}

	public void setTieneValor(Boolean tieneValor) {
		this.tieneValor = tieneValor;
	}

	
	
}
