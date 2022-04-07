/*
 * SonarQube, open source software quality management tool.
 * Copyright (C) 2008-2013 SonarSource
 * mailto:contact AT sonarsource DOT com
 *
 * SonarQube is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * SonarQube is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package br.com.natacao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.natacao.model.Atleta;

@Repository
public interface AtletaRepository extends CrudRepository<Atleta, Long> {

	@Query(nativeQuery = true
		   ,value="SELECT a.ATLETA_ID"
				+"	,a.NOME_ATLETA"
				+"	,a.APELIDO_ATLETA"
				+"	,a.SEXO_ATLETA"
				+"	,a.DTNASC_ATLETA"
				+"	,b.ID_CATEGORIA"
				+" FROM ATLETA a"
				+",ATLETA_CATEGORIA b"
				+" WHERE a.atleta_id = b.id_atleta"
				+" AND UPPER(a.NOME_ATLETA) = UPPER(:nome)"
				+" AND a.DTNASC_ATLETA = :dtNasc")
	Atleta findByNomeAndDtNasc(@Param("nome") String nome, @Param("dtNasc") Date dtNasc);

	@Query(nativeQuery = true
		   , value = "SELECT atleta_id"
  					+" ,a.nome_atleta"
  					+" ,a.apelido_atleta"
  					+" ,a.sexo_atleta"
  					+" ,a.dtnasc_atleta"
  					+" ,a.dtinclu_atleta"
  					+" ,b.id_categoria" 
					+" FROM ATLETA a"
					+" ,ATLETA_CATEGORIA b"
					+" WHERE a.atleta_id = b.id_atleta")	
	List<Atleta> findAll();	
	
}
