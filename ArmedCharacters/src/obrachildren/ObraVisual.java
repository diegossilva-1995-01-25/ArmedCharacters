package obrachildren;

import model.Obra;

/*
 * Autor: Diego Souza Silva
 * Data: 05/06/2017;
 */

public class ObraVisual extends Obra {
	private String distribuidora;
	private String franquia;
	
	public String getDistribuidora() {
		return distribuidora;
	}
	
	public String getFranquia() {
		return franquia;
	}
	
	public void setDistribuidora(String distribuidora) {
		this.distribuidora = distribuidora;
	}
	
	public void setFranquia(String franquia) {
		this.franquia = franquia;
	}

	
}
