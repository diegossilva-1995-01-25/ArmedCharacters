package model;

/*
 * Autor: Diego Souza Silva
 * Data: 05/06/2017;
 */

public class Fabricante {
	private int id;
	private String nome;
	private String origem;
	private int anoFundacao;
	private String fundador;
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getOrigem() {
		return origem;
	}
	
	public int getAnoFundacao() {
		return anoFundacao;
	}
	
	public String getFundador() {
		return fundador;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	public void setAnoFundacao(int anoFundacao) {
		this.anoFundacao = anoFundacao;
	}
	
	public void setFundador(String fundador) {
		this.fundador = fundador;
	}
	
}
