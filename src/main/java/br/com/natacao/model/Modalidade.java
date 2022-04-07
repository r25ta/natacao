package br.com.natacao.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "modalidade")
@ToString

public class Modalidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Getter
	@Column(name = "id_modalidade")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome_modalidade")
	@Getter
	@Setter
	private String nome;
	
	@Column(name="dtinclu_modalidade")
	@Getter
	@Setter
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private Timestamp dtInclu;

	public Modalidade() {
	}

	public Modalidade(String nome, Timestamp dtInclu) {
		super();
		this.nome = nome;
		this.dtInclu = dtInclu;
	}
	
	
	
}
