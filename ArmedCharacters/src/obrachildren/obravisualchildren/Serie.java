package obrachildren.obravisualchildren;

import obrachildren.ObraVisual;
/*
 * Autor: Diego Souza Silva
 * Data: 05/06/2017;
 */

public class Serie extends ObraVisual {
	private int numEpisodios;
	private int numTemporadas;
	private String tipoSerie;
	
	public int getNumEpisodios() {
		return numEpisodios;
	}
	
	public int getNumTemporadas() {
		return numTemporadas;
	}
	
	public String getTipoSerie() {
		return tipoSerie;
	}
	
	public void setNumEpisodios(int numEpisodios) {
		this.numEpisodios = numEpisodios;
	}
	
	public void setNumTemporadas(int numTemporadas) {
		this.numTemporadas = numTemporadas;
	}
	
	public void setTipoSerie(String tipoSerie) {
		this.tipoSerie = tipoSerie;
	}
	
}
