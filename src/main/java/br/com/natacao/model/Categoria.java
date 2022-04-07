package br.com.natacao.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.natacao.br.controller.dto.CategoriaDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "categoria")
@ToString

public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Getter
	@Column(name = "id_categoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome_categoria")
	@Getter
	@Setter
	private String nome;
	
	@Column(name="dtinclu_categoria")
	@Getter
	@Setter
	@DateTimeFormat(pattern = "dd/MM/YYYY hh:mi:ss")
	private Timestamp dtInclu;

	public Categoria() {
	}

	public Categoria(String nome, Timestamp dtInclu) {
		super();
		this.nome = nome;
		this.dtInclu = dtInclu;
	}
	
	public Categoria(CategoriaDTO categoriaDTO) {
		this.id = categoriaDTO.getId();
		this.nome = categoriaDTO.getNome();
	}
	
	
}
