package com.fatec.ed;

public class Registro {

	/**
	 	ID
	 	Estados
	 	Prod. Lixo a.a. (milhoes ton.)
	 	Postos de Coleta
	 	% de Reciclagem
	 	Economia em R$ (milhoes)
	 	Qtde de empregos gerados
	 */
	
	private int id;
	private String uf;
	private float prodLixo;
	private int postosColeta;
	private float porcentagemReciclagem;
	private float economiaEmValores;
	private int qtdeEmpregosGerados;
	
	// -------------------------------------------------------------------------------------------
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public float getProdLixo() {
		return prodLixo;
	}
	
	public void setProdLixo(float prodLixo) {
		this.prodLixo = prodLixo;
	}
	
	public int getPostosColeta() {
		return postosColeta;
	}
	
	public void setPostosColeta(int postosColeta) {
		this.postosColeta = postosColeta;
	}
	
	public float getPorcentagemReciclagem() {
		return porcentagemReciclagem;
	}
	
	public void setPorcentagemReciclagem(float porcentagemReciclagem) {
		this.porcentagemReciclagem = porcentagemReciclagem;
	}
	
	public float getEconomiaEmValores() {
		return economiaEmValores;
	}
	
	public void setEconomiaEmValores(float economiaEmValores) {
		this.economiaEmValores = economiaEmValores;
	}
	
	public int getQtdeEmpregosGerados() {
		return qtdeEmpregosGerados;
	}
	
	public void setQtdeEmpregosGerados(int qtdeEmpregosGerados) {
		this.qtdeEmpregosGerados = qtdeEmpregosGerados;
	}
	
	
}
