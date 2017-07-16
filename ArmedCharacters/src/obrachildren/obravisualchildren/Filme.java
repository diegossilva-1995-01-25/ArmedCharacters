package obrachildren.obravisualchildren;

import obrachildren.ObraVisual;
/*
 * Autor: Diego Souza Silva
 * Data: 05/06/2017;
 */

public class Filme extends ObraVisual {
	private String tituloDublado;
	private String diretor;
	
	public String getTituloDublado() {
		return tituloDublado;
	}
	
	public String getDiretor() {
		return diretor;
	}
	
	public void setTituloDublado(String tituloDublado) {
		this.tituloDublado = tituloDublado;
	}
	
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	
}
