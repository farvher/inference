package com.inference.services;

import java.util.List;

import com.inference.dto.fuzzy.FuzzyCriterio;
import com.inference.dto.fuzzy.TruthValueDto;

public interface MemberShipFunctionService {

	Double triangular(Integer value , List<FuzzyCriterio> criterios);
	
	Double trapezoidal(Integer value , List<FuzzyCriterio> criterios);

	
//	Double singleton(Integer value ,List<FuzzyCriterio>... criterios);
//	
//	Double gausiana(Integer value ,List<FuzzyCriterio>... criterios);
//	
//	Double bell(Integer value ,List<FuzzyCriterio>... criterios);
}
