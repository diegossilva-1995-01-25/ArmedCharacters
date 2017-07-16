package model;

import java.util.Date;

/*
 * Autor: Diego Souza Silva
 * Data: 05/06/2017;
 */

public class Personagem {
	private int id;
	private String nome;
	private Date dataNasc;
	private String origem;
	private String corOlhos;
	private String corCabelo;
	private String raca;
	private String etnia;
	private String tipoPersonagem;
	private String biotipo;
	private int obra;
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Date getDataNasc() {
		return dataNasc;
	}
	
	public String getOrigem() {
		return origem;
	}
	
	public String getCorOlhos() {
		return corOlhos;
	}
	
	public String getCorCabelo() {
		return corCabelo;
	}
	
	public String getRaca() {
		return raca;
	}
	
	public String getEtnia() {
		return etnia;
	}
	
	public String getTipoPersonagem() {
		return tipoPersonagem;
	}
	
	public String getBiotipo() {
		return biotipo;
	}
	
	public int getObra() {
		return obra;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	public void setCorOlhos(String corOlhos) {
		this.corOlhos = corOlhos;
	}
	
	public void setCorCabelo(String corCabelo) {
		this.corCabelo = corCabelo;
	}
	
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}
	
	public void setTipoPersonagem(String tipoPersonagem) {
		this.tipoPersonagem = tipoPersonagem;
	}
	
	public void setBiotipo(String biotipo) {
		this.biotipo = biotipo;
	}
	
	public void setObra(int obra) {
		this.obra = obra;
	}
	
}
