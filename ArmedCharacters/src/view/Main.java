package view;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		String senha = JOptionPane.showInputDialog("Bem-vindo ao Armed Characters,\n"
				+ "Digite sua senha no MySQL:");
		Menu menu = new Menu(senha);
		menu.setVisible(true);
	}

}
