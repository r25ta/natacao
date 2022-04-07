package br.com.natacao.model;

public enum Sexo {
	M("M","Masculino"), 
	F("F","Feminino");
	
	private String sigla;
	private String descrição;
	
	public String getSigla() {
		return sigla;
	}
	public String getDescrição() {
		return descrição;
	}
	
	private Sexo(String sigla, String descrição) {
		this.sigla = sigla;
		this.descrição = descrição;
	}
	
	
	
	
}
