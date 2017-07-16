package view;

import javax.swing.JFrame;

public abstract class Tela extends JFrame {
	protected int vertical;
	protected int horizontal;
	
	public Tela() {
		vertical = 600;
		horizontal = 600;
	}
	
	// Este m�todo nos leva ao padr�o Strategy
	public abstract void limparTela();
	
}
