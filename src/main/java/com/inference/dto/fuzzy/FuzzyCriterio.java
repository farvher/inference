package com.inference.dto.fuzzy;

public class FuzzyCriterio {

	private String name;

	private Integer from;


	

	public FuzzyCriterio(String name, Integer from) {
		super();
		this.name = name;
		this.from = from;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}


	
	

}
