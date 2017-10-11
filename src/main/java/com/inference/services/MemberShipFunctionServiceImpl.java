package com.inference.services;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.inference.dto.fuzzy.FuzzyCriterio;
import com.inference.dto.fuzzy.TruthValueDto;


@Service
public class MemberShipFunctionServiceImpl implements MemberShipFunctionService {

	@Override
	public Double triangular(Integer value, List<FuzzyCriterio> criterios) {
		Double a, b, c;
		a = criterios.stream().mapToInt(i -> i.getFrom()).asDoubleStream().min().getAsDouble();
		c = criterios.stream().mapToInt(i -> i.getFrom()).asDoubleStream().max().getAsDouble();
		b = criterios.stream().mapToInt(i -> i.getFrom()).asDoubleStream().filter(i -> i != a && i != c).findFirst()
				.getAsDouble();
		Double answer = 0D;
		if (value <= a) {
			answer = 0D;
		} else if (a <= value && value <= b) {
			answer = (value - a) / (b - a);
		} else if (b <= value && value < c) {
			answer = (c - value) / (c - b);
		} else if (c <= value) {
			answer = 0D;
		}

		return answer;
	}

	@Override
	public Double trapezoidal(Integer value, List<FuzzyCriterio> criterios) {
		Double a, b;
		a = criterios.stream().mapToInt(i -> i.getFrom()).asDoubleStream().min().getAsDouble();
		b = criterios.stream().mapToInt(i -> i.getFrom()).asDoubleStream().max().getAsDouble();
	
		Double answer = 0D;
		if (value <= a) {
			answer = 0D;
		} else if (a <= value && value <= b) {
			answer = (value - a) / (b - a);
		} else if (b >= value) {
			answer = 1D;
		}

		return answer;
	}

}
