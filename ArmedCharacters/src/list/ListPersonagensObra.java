package list;

import java.util.List;
import model.Personagem;
/*
 * Autor: Diego Souza Silva
 * Data: 05/06/2017;
 */

public interface ListPersonagensObra {
	
	public List<Personagem> instanciarLista();
	
	public void adicionarArma(Personagem p);
	
	public void listarArmas(String tituloObra);
	
	public Personagem removerArma(Personagem p);
	
}
