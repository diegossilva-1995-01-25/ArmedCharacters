package model;

/*
 * Autor: Diego Souza Silva
 * Data: 05/06/2017;
 */

public class Obra {
	private int id;
	private String titulo;
	private int ano;
	private String genero;
	
	public int getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public int getAno() {
		return ano;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
