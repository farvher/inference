package com.inference.services;

import java.util.List;

import com.inference.dto.fuzzy.TruthValueDto;

public interface FuzzyService {
	

	
	
	String fuzzyOR(TruthValueDto... tv );
	
	String fuzzyAnd(TruthValueDto... tv);
	
	String fuzzy(TruthValueDto tv);
	
	String DienesRichardImplication(TruthValueDto tv,TruthValueDto tv2);
	
	String ZadethImplication(TruthValueDto tv);
	
	String MandariImplication(TruthValueDto tv);
	
}
