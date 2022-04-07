package br.com.natacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.natacao.model.Campeonato;
import br.com.natacao.service.CampeonatoService;

@Controller
@ComponentScan
@RequestMapping("/campeonato")
public class CampeonatoController {

	private CampeonatoService campeonatoService;
	
	@Autowired
	public CampeonatoController(CampeonatoService campeonatoService) {
		this.campeonatoService = campeonatoService;
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap modelMap) {
		List<Campeonato> campeonatos = campeonatoService.findAll();
		
		modelMap.addAttribute("campeonatos", campeonatos);
		
		return "/campeonatos/listar_campeonato";
	}
}
