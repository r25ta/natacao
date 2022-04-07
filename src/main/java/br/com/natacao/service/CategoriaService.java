package br.com.natacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.natacao.model.Categoria;
import br.com.natacao.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Transactional(readOnly = true)
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
		
	}
	
	@Transactional(readOnly = true)
	public Categoria getById(Long id) {
		return categoriaRepository.getById(id);
		
	}
}
