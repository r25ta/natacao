/*
 * 28.03.2022 Ronaldo da Conceicao 
 * Copyright (c) 2022 R25TA. All Rights Reserved.
 */

package br.com.natacao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/natacao")
public class Index {
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}

}
