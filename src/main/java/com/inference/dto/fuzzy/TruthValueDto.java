package com.inference.dto.fuzzy;

import java.util.List;


public class TruthValueDto {

	Integer value;

	Double answer;

	String criterioAnswer;

	List<FuzzyCriterio> criterios;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Double getAnswer() {
		return answer;
	}

	public void setAnswer(Double answer) {
		this.answer = answer;
	}

	public String getCriterioAnswer() {
		return criterioAnswer;
	}

	public void setCriterioAnswer(String criterioAnswer) {
		this.criterioAnswer = criterioAnswer;
	}

	public List<FuzzyCriterio> getCriterios() {
		return criterios;
	}

	public void setCriterios(List<FuzzyCriterio> criterios) {
		this.criterios = criterios;
	}


	

}
