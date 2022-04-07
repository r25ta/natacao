package br.com.natacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.natacao.model.Modalidade;
import br.com.natacao.repository.ModalidadeRepository;

@Service
public class ModalidadeService {

	@Autowired
	ModalidadeRepository modalidadeRepository;
	
	@Transactional(readOnly = true)
	public List<Modalidade> findAll(){
		return modalidadeRepository.findAll();
		
	}
}
