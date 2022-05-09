/*
 * R25ta - 2022
 * Ronaldo da Conceição
 */
package br.com.natacao.service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.natacao.model.Atleta;
import br.com.natacao.repository.AtletaRepository;

@Service
@ComponentScan
//ABRE TRANSAÇÃO E DEIXA A TABELA LOCKADA COM A PROPRIEDADE READONLY = FALSE [USAR EM OPERÇÃO DE ESCRITA]
@Transactional(readOnly = false) 
public class AtletaService {

	private AtletaRepository atletaRepository;
	
	@Autowired
	public AtletaService(AtletaRepository atletaRepository) {
		this.atletaRepository = atletaRepository;
		
	}
	
	//ATRIBUTO READONLY = TRUE DEVE SER UTILIZADO PARA OPERAÇÕES DE LEITURA
	@Transactional(readOnly = true)
	public Atleta findByNomeAndDtNasc(String nome, LocalDate dtNasc) {
		
		Atleta atleta = atletaRepository.findByNomeAndDtNasc(nome, dtNasc);
		
		return atleta;
	}
	
	@Transactional(readOnly = true)
	public List<Atleta> findAll(){
		List<Atleta> lstAtletas = atletaRepository.findAll();
		
		if(lstAtletas.isEmpty()){
			return Collections.emptyList();
			
		} else {
			return lstAtletas;
			
		}
		
	}

	@Transactional(readOnly = true)
	public Atleta findById(long idAtleta) {
		Atleta retornoAtleta = null;
		Optional<Atleta> atleta = atletaRepository.findById(idAtleta);
		
		if(atleta.isPresent()) {
			retornoAtleta = atleta.get();
			
		}
		
		return retornoAtleta;
	}
	
	
	public Atleta save(Atleta atleta) {
		
		atleta.setDtInclu(Timestamp.valueOf(LocalDateTime.now()));

		return atletaRepository.save(atleta);
		
	}
	
	public void delete(long idAtleta) {
		atletaRepository.deleteById(idAtleta);
	}
		
}
