/*
 * 28.03.2022 Ronaldo da Conceicao 
 * Copyright (c) 2022 R25TA. All Rights Reserved.
 */

package br.com.natacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.natacao.model.Modalidade;
import br.com.natacao.service.ModalidadeService;

@Controller
@ComponentScan
@RequestMapping("/modalidade")
public class ModalidadeController {
	
	private ModalidadeService modalidadeService;
	
	@Autowired
	public ModalidadeController(ModalidadeService modalidadeService) {
		this.modalidadeService = modalidadeService;
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap modelMap) {
		List<Modalidade> modalidades = modalidadeService.findAll();
		
		modelMap.addAttribute("modalidades", modalidades);
		
		return "/modalidades/listar_modalidade";
	}
}
