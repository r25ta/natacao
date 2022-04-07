/*
 * 28.03.2022 Ronaldo da Conceicao 
 * Copyright (c) 2022 R25TA. All Rights Reserved.
 */

package br.com.natacao.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@ComponentScan
@Controller
public class HomeController {
	@RequestMapping("/")	
	public String home() {
		return "/home";
	}
	
	
}
