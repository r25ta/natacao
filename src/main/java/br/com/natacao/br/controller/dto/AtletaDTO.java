package br.com.natacao.br.controller.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.com.natacao.model.Atleta;
import br.com.natacao.model.Sexo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class AtletaDTO implements Serializable {
	private Long id;
	private String nome;
	private String apelido;
	private Sexo sexo;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dtNascimento;
	private CategoriaDTO categoriaAtleta;
	
	
	public AtletaDTO(){
		
	}
	public AtletaDTO(Atleta atleta) {
		this.id = atleta.getId();
		this.nome = atleta.getNome();
		this.apelido = atleta.getApelido();
		this.sexo = atleta.getSexo();
		this.dtNascimento = atleta.getDtNascimento();
		this.categoriaAtleta = new CategoriaDTO(atleta.getCategoriaAtleta().getId(), atleta.getCategoriaAtleta().getNome());
	}
	
}
