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

import br.com.natacao.model.Categoria;
import br.com.natacao.service.CategoriaService;

@Controller
@ComponentScan
@RequestMapping("/categoria")
public class CategoriaController {

	private CategoriaService categoriaService;
	
	@Autowired
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap modelMap) {
		List<Categoria> categorias = categoriaService.findAll();
		
		modelMap.addAttribute("categorias", categorias);
		
		return "/categorias/listar_categoria";
	}
}
