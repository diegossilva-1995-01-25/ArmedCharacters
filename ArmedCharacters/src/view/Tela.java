package view;

import javax.swing.JFrame;

public abstract class Tela extends JFrame {
	protected int vertical;
	protected int horizontal;
	
	public Tela() {
		vertical = 600;
		horizontal = 600;
	}
	
	// Este método nos leva ao padrão Strategy
	public abstract void limparTela();
	
}
