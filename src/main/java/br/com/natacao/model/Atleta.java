/*
 * 28.03.2022 Ronaldo da Conceicao 
 * Copyright (c) 2022 R25TA. All Rights Reserved.
 */
package br.com.natacao.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.com.natacao.br.controller.dto.AtletaDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Table(name = "atleta")
@ToString
@EqualsAndHashCode
public class Atleta implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="atleta_id")
	@Setter
	@Getter
	private Long id;
	
	@Column(name = "nome_atleta", nullable = false, unique = true)
	@Getter
	@Setter
	@NotNull(message = "Campo nome atleta obrigatorio!")
	private String nome;
	
	@Column(name = "apelido_atleta")
	@Getter
	@Setter
	private String apelido;
	
	@Column(name="sexo_atleta", nullable = false)
	@Getter
	@Setter
	@NotNull(message = "Campo sexo atleta obrigatorio!")
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Column(name="dtnasc_atleta", nullable = false, columnDefinition = "DATE" )
	@Getter
	@Setter
	@NotNull(message = "Campo data nascimento atleta obrigatorio!")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dtNascimento;
	
	@Column(name="dtinclu_atleta", nullable = false, columnDefinition = "TIMESTAMP")
	@Getter
	@Setter
	@DateTimeFormat(pattern = "dd-MM-yyyy hh:mi:ss")
	private Timestamp dtInclu;

	@OneToOne
	@Getter
	@Setter
	@NotNull(message = "Campo categoria atleta obrigatorio!")
	@JoinTable(name = "atleta_categoria"
				, joinColumns=@JoinColumn(name="id_atleta")
				, inverseJoinColumns = @JoinColumn(name="id_categoria"))
	private Categoria categoriaAtleta;
	
	public Atleta(String nome, String apelido, Sexo sexo, LocalDate dtNascimento, Categoria categoriaAtleta, Timestamp dtInclu){
		this.nome = nome;
		this.apelido = apelido;
		this.sexo = sexo;
		this.dtNascimento = dtNascimento;
		this.categoriaAtleta = categoriaAtleta;
		this.dtInclu = dtInclu;
	}

	public Atleta(){
	}
	
	public Atleta(AtletaDTO atletaDTO) {
		this.id = atletaDTO.getId();
		this.nome = atletaDTO.getNome();
		this.apelido = atletaDTO.getApelido();
		this.sexo = atletaDTO.getSexo();
		this.dtNascimento = atletaDTO.getDtNascimento();
		this.categoriaAtleta = new Categoria(atletaDTO.getCategoriaAtleta());
	}
	
}
