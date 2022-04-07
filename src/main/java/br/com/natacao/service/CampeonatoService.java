package br.com.natacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.natacao.model.Campeonato;
import br.com.natacao.repository.CampeonatoRepository;

@Service
public class CampeonatoService {
	
	@Autowired
	CampeonatoRepository campeonatoRepository;
	
	@Transactional(readOnly = true)
	public List<Campeonato> findAll(){
		
		List<Campeonato> campeonatos = campeonatoRepository.findAll();
		
		return campeonatos;
	}
}
