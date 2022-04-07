package br.com.natacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.natacao.model.Campeonato;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato, Long> {

}
