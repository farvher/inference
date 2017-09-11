package com.inference.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.inference.dto.diagnosticoDTO;
import com.inference.dto.implicacionDTO;
import com.inference.entity.Implicacion;
import com.inference.entity.Proposicion;
import com.inference.repository.ImplicacionDAO;
import com.inference.repository.ProposicionDAO;

@Controller
public class IndexController {

	@Autowired
	private ProposicionDAO proposicionDao;

	@Autowired
	private ImplicacionDAO implicacionDao;

	@GetMapping("/")
	public String getIndex(Model model) {

		model.addAttribute("dto", new diagnosticoDTO());
		model.addAttribute("rules", proposicionDao.findAll());

		return "index2";
	}

	@GetMapping("/base")
	public String getBase(Model model) {

		model.addAttribute("dto", new implicacionDTO());
		model.addAttribute("rules", proposicionDao.findAll());
		return "index";
	}

	@PostMapping("/add")
	public String addRule(@ModelAttribute implicacionDTO implicacion, Model model) {

		Proposicion p = new Proposicion();
		Proposicion q = new Proposicion();

		p.setDefinicion(implicacion.getP());
		q.setDefinicion(implicacion.getQ());

		proposicionDao.save(p);
		proposicionDao.save(q);

		Proposicion r = proposicionDao.findFirstByDefinicion(implicacion.getP());
		Proposicion s = proposicionDao.findFirstByDefinicion(implicacion.getQ());

		Implicacion imp = new Implicacion();
		imp.setPreposicionId(r.getId());
		imp.setImplicacionId(s.getId());

		implicacionDao.save(imp);

		return "redirect:/base";
	}

	@PostMapping("/process")
	public String process(@ModelAttribute diagnosticoDTO diagnostico, Model model) {

		StringBuilder str = new StringBuilder();
		Long rule = diagnostico.getRule();

		List<Implicacion> implicaciones = implicacionDao.findByPreposicionId(rule);

		for (Implicacion i : implicaciones) {

			Optional<Proposicion> p = proposicionDao.findById(i.getImplicacionId());
			if (p.isPresent()) {
				str.append(p.get().getDefinicion());
				str.append(" ; ");
			}

		}

		diagnostico.setDiagnostico(str.toString());

		model.addAttribute("dto", diagnostico);
		model.addAttribute("rules", proposicionDao.findAll());

		return "index2";
	}
}
