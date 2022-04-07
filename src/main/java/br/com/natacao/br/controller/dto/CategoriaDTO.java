package br.com.natacao.br.controller.dto;

import java.io.Serializable;

import br.com.natacao.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class CategoriaDTO implements Serializable {
	private Long id;
	private String nome;

	public CategoriaDTO() {
		
	}
	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}
}
