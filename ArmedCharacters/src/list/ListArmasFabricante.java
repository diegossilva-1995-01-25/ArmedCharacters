package list;

import java.util.List;

import model.Arma;
/*
 * Autor: Diego Souza Silva
 * Data: 05/06/2017;
 */

public interface ListArmasFabricante {
	
	public List<Arma> instanciarLista();
	
	public void adicionarArma(Arma a);
	
	public void listarArmas(String nomeFabricante);
	
	public Arma removerArma(Arma a);
	
}
