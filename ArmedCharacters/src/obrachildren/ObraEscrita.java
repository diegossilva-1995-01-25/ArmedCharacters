package obrachildren;


import model.Obra;
/*
 * Autor: Diego Souza Silva
 * Data: 05/06/2017;
 */

public class ObraEscrita extends Obra {
	private String tituloTraduzido;
	private String autor;
	private String tipoObraEscrita;
	private String editora;
	
	public String getTituloTraduzido() {
		return tituloTraduzido;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public String getTipoObraEscrita() {
		return tipoObraEscrita;
	}
	
	public String getEditora() {
		return editora;
	}
	
	public void setTituloTraduzido(String tituloTraduzido) {
		this.tituloTraduzido = tituloTraduzido;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public void setTipoObraEscrita(String tipoObraEscrita) {
		this.tipoObraEscrita = tipoObraEscrita;
	}
	
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
}
