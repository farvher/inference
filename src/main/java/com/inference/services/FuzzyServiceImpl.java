package com.inference.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inference.dto.fuzzy.TruthValueDto;

@Service
public class FuzzyServiceImpl implements FuzzyService {

	private static final Double NO_ES = 0D;
	private static final Double ES = 1D;
	private static final Double ES_MUY = 0.9D;
	private static final Double ES_BASTANTE = 0.8D;
	private static final Double ES_CASI_BASTANTE = 0.7D;
	private static final Double ES_CASI = 0.6D;
	private static final Double ES_MEDIO = 0.5D;
	private static final Double ES_CASI_MEDIO_ = 0.4D;
	private static final Double CASI_NO_ES = 0.3D;
	private static final Double CASI_NO_ES_TAN = 0.2D;
	private static final Double NO_ES_PARA_NADA = 0.1D;

	private static Map<Double, String> respuestas = new HashMap<Double, String>() {
		{
			put(NO_ES, "NO ES");
			put(ES, "ES");
			put(ES_MUY, "ES MUY");
			put(ES_BASTANTE, "ES BASTANTE");
			put(ES_CASI_BASTANTE, "ES CASI BASTANTE");
			put(ES_CASI, "ES CASI");
			put(ES_MEDIO, "ES MEDIO");
			put(ES_CASI_MEDIO_, "ES CASI MEDIO");
			put(CASI_NO_ES, "CASI NO ES");
			put(CASI_NO_ES_TAN, "CASI NO ES TAN");
			put(NO_ES_PARA_NADA, "NO ES PARA NADA");

		}

	};

	@Autowired
	private MemberShipFunctionService memberShipFunction;

	@Override
	public String fuzzyOR(TruthValueDto... tv) {

		List<Double> truthValues = new ArrayList<>();

		Double answer1 = memberShipFunction.triangular(tv[0].getValue(), tv[0].getCriterios());
		truthValues.add(answer1);

		Double answer2 = memberShipFunction.trapezoidal(tv[1].getValue(), tv[1].getCriterios());
		truthValues.add(answer2);

		Double max = truthValues.stream().mapToDouble(i -> i).max().getAsDouble();

		return buildAnswer(max);
	}

	private String buildAnswer(Double max) {
		Double round = (double) Math.round(max * 10d) / 10d;
		return respuestas.containsKey(round) ? respuestas.get(round) : "no encontrada para : " + round;
	}

	@Override
	public String fuzzyAnd(TruthValueDto... tv) {
		List<Double> truthValues = new ArrayList<>();

		Double answer1 = memberShipFunction.triangular(tv[0].getValue(), tv[0].getCriterios());
		truthValues.add(answer1);

		Double answer2 = memberShipFunction.trapezoidal(tv[1].getValue(), tv[1].getCriterios());
		truthValues.add(answer2);

		Double max = truthValues.stream().mapToDouble(i -> i).min().getAsDouble();

		return buildAnswer(max);
	}

	@Override
	public String fuzzy(TruthValueDto t) {
		Double answer = memberShipFunction.trapezoidal(t.getValue(), t.getCriterios());
		return buildAnswer(answer);
	}

	@Override
	public String DienesRichardImplication(TruthValueDto tv, TruthValueDto tv2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ZadethImplication(TruthValueDto tv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String MandariImplication(TruthValueDto tv) {
		// TODO Auto-generated method stub
		return null;
	}

}
