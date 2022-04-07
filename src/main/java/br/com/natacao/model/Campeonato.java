package br.com.natacao.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "campeonato")
@ToString
@EqualsAndHashCode
public class Campeonato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Column(name = "id_campeonato")
	private Long id;
	
	@Getter
	@Setter
	@Column(name = "nome_campeonato")
	private String nome;
	
	@Getter
	@Setter
	@Column(name = "dtinclu_campeonato")
	private Timestamp dtInclu;
	
	public Campeonato() {
		
	}
	
	public Campeonato(String nome, Timestamp dtInclu) {
		this.nome = nome;
		this.dtInclu = dtInclu;
	}
}
