package model;

/*
 * Autor: Diego Souza Silva
 * Data: 05/06/2017;
 */

public class Arma {
	private int id;
	private String modelo;
	private String nomeNaObra;
	private double peso;
	private double comprimentoCm;
	private int alcance;
	private String equipamentos;
	private int capacidade;
	private int personagem;
	private int calibre;
	private int fabricante;
	
	public int getId() {
		return id;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public String getNomeNaObra() {
		return nomeNaObra;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public double getComprimentoCm() {
		return comprimentoCm;
	}
	
	public int getAlcance() {
		return alcance;
	}
	
	public String getEquipamentos() {
		return equipamentos;
	}
	
	public int getCapacidade() {
		return capacidade;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public void setNomeNaObra(String nomeNaObra) {
		this.nomeNaObra = nomeNaObra;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public void setComprimentoCm(double comprimentoCm) {
		this.comprimentoCm = comprimentoCm;
	}
	
	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}
	
	public void setEquipamentos(String equipamentos) {
		this.equipamentos = equipamentos;
	}
	
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}	
	
	public int getPersongem() {
		return personagem;
	}

	public int getCalibre() {
		return calibre;
	}

	public int getFabricante() {
		return fabricante;
	}

	public void setPersongem(int persongem) {
		this.personagem = persongem;
	}

	public void setCalibre(int calibre) {
		this.calibre = calibre;
	}

	public void setFabricante(int fabricante) {
		this.fabricante = fabricante;
	}
	
}
