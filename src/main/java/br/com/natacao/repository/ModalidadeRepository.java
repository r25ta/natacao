package br.com.natacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.natacao.model.Modalidade;

@Repository
public interface ModalidadeRepository extends JpaRepository<Modalidade, Long> {

}
