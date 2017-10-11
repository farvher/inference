package com.inference.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inference.dto.fuzzy.FuzzyCriterio;
import com.inference.dto.fuzzy.TruthValueDto;
import com.inference.services.FuzzyService;

@Controller
public class FuzzyController {

	@Autowired
	FuzzyService fuzzyService;

	private static String FUZZY_VIEW = "fuzzy";

	@GetMapping("/fuzzy")
	public String getIndex(Model m) {

		return FUZZY_VIEW;

	}

	@PostMapping("/fuzzy-process")
	public String getIndex(@RequestParam Integer input1, @RequestParam Integer input2, 
			@RequestParam String crit1 , @RequestParam Integer critValue1,
			@RequestParam String crit2 , @RequestParam Integer critValue2,
			@RequestParam String crit3 , @RequestParam Integer critValue3,
			Model m) {

		TruthValueDto tv = new TruthValueDto();
		
		List<FuzzyCriterio> list1 = new ArrayList<>();
		list1.add(new FuzzyCriterio(crit1,critValue1));
		list1.add(new FuzzyCriterio(crit2,critValue2));
		list1.add(new FuzzyCriterio(crit3,critValue3));
		tv.setValue(input1);
		tv.setCriterios(list1);

		TruthValueDto tv2 = new TruthValueDto();
		List<FuzzyCriterio> list2 = new ArrayList<>();
		list2.add(new FuzzyCriterio("Alto",10));
		list2.add(new FuzzyCriterio("Medio",5));
		list2.add(new FuzzyCriterio("Bajo",1));

		tv2.setValue(input2);
		tv2.setCriterios(list2);

		String answer = fuzzyService.fuzzyAnd(tv, tv2);

		m.addAttribute("answer", answer);
		m.addAttribute("precio", input1);
		m.addAttribute("calidad", input2);
		m.addAttribute("economia", fuzzyService.fuzzy(tv));
		m.addAttribute("quality", fuzzyService.fuzzy(tv2));

		return FUZZY_VIEW;

	}

}
