/*
 * R25ta - 2022
 * Ronaldo da Conceição
 */
package br.com.natacao.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.natacao.br.controller.dto.AtletaDTO;
import br.com.natacao.br.controller.dto.CategoriaDTO;
import br.com.natacao.model.Atleta;
import br.com.natacao.model.Categoria;
import br.com.natacao.service.AtletaService;
import br.com.natacao.service.CategoriaService;

@Controller
@ComponentScan
@RequestMapping("/atleta")
public class AtletaController implements WebMvcConfigurer{

	private static final Logger LOGGER = LoggerFactory.getLogger(AtletaController.class);
	
	private AtletaService atletaService;
	private CategoriaService categoriaService;
	
	@Autowired
	public AtletaController(AtletaService atletaService, CategoriaService categoriaService) {
		this.atletaService = atletaService;
		this.categoriaService = categoriaService;
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(AtletaDTO atletaDTO, ModelMap modelMap) {
		
		if(atletaDTO.getNome()!=null) {
			Atleta atleta = convertDtoToModel(atletaDTO);
			
		}
		List<Categoria> categorias = categoriaService.findAll();
		modelMap.addAttribute("categorias", categorias);
		return "/atletas/cadastrar_atleta";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap modelMap) {
		List<Atleta> lstAtleta = atletaService.findAll();
		List<AtletaDTO> lstAtletaDTO = lstAtleta.stream().map( atleta -> new AtletaDTO(atleta) ).collect(Collectors.toList());
		modelMap.addAttribute("atletas",lstAtletaDTO);
		return "/atletas/listar_atleta";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") long id, ModelMap modelMap) {
		Atleta atleta = atletaService.findById(id);
		List<Categoria> categorias = categoriaService.findAll();
		modelMap.addAttribute("categorias", categorias);
		modelMap.addAttribute("atletaDTO", new AtletaDTO(atleta));
		
		return "/atletas/cadastrar_atleta";
	}
	
	@PostMapping("/editar")
	public String editar(AtletaDTO atletaDTO) {
		//RECUPERA INFORMAÇÕES DA CATEGORIA
		Categoria cat = categoriaService.getById(atletaDTO.getCategoriaAtleta().getId());
		atletaDTO.setCategoriaAtleta(new CategoriaDTO(cat));

		Atleta atleta = convertDtoToModel(atletaDTO);
		
		atletaService.save(atleta);		
		
		return "redirect:/atleta/listar";
	}

	@GetMapping("/")
	public ModelAndView index(ModelMap modelMap){
		List<Atleta> lstAtleta = atletaService.findAll();
		List<AtletaDTO> lstAtletaDTO = lstAtleta.stream().map(atleta -> new AtletaDTO(atleta)).collect(Collectors.toList());
		
		List<Categoria> categorias = categoriaService.findAll();
		
		modelMap.addAttribute("atleta",new AtletaDTO());
		modelMap.addAttribute("categorias",categorias);
		modelMap.addAttribute("atletas",lstAtletaDTO);
		
		return new ModelAndView("/atletas/cadastrar_atleta",modelMap);
	}
	
	@PostMapping("/salvar")
	public String salvar(AtletaDTO atletaDTO) {
		Atleta at = atletaService.findByNomeAndDtNasc(atletaDTO.getNome(), atletaDTO.getDtNascimento());
		
		//RECUPERA INFORMAÇÕES DA CATEGORIA
		Categoria cat = categoriaService.getById(atletaDTO.getCategoriaAtleta().getId());
		atletaDTO.setCategoriaAtleta(new CategoriaDTO(cat));
		
		if(at!=null) {
			LOGGER.info("ATLETA JÁ CADASTRADO!");			
	
		}
		else {
			Atleta atleta = convertDtoToModel(atletaDTO);
			LOGGER.info("Gravar Atleta na base de dados!");
			atletaService.save(atleta);
	
		}
		return "redirect:/atleta/cadastrar";
		
	}
	
	@GetMapping(value="/excluir")
	public String excluir(RedirectAttributes redirectAttributes
								, @RequestParam(name="id") long id
								, @RequestParam(name="nome") String nome) {
		atletaService.delete(id);
		
		redirectAttributes.addFlashAttribute("mensagem", "Atleta ".concat(nome).concat(" excluido definitivamente!"));
		
		LOGGER.info("Atleta " + nome +" excluido definitivamente!");
		
		return "redirect:/atleta/listar";
		
	}
	private Atleta convertDtoToModel(AtletaDTO atletaDTO) {
		Atleta atletaModel = new Atleta(atletaDTO);

		return atletaModel;
	
	}
	
}