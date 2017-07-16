package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;

public class Menu extends MenuConstrutor {

	private JPanel contentPane;
	private TelaArma ta;
	private TelaFabricante tf;
	private TelaPersonagem tp;
	private TelaCalibre tc;
	private TelaFilme tm;
	private TelaGame tg;
	private TelaSerie ts;
	private TelaObraEscrita toe;
	private String pass;
	
	private JDesktopPane painelTelas;

	/**
	 * Create the frame.
	 */
	public Menu(String senha) {
		
		pass = senha;
		setTitle("Armed Characters - Menu Principal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(5, 5, 800, 800);
		
		JMenuBar barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		JMenu menuTelas = new JMenu("Telas");
		barraMenu.add(menuTelas);
		
		JMenu menuItemArma = new JMenu("Arma");
		menuItemArma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				criarTelaA(ta);				
			}
		});
		menuTelas.add(menuItemArma);
		
		JMenu menuItemCalibre = new JMenu("Calibre");
		menuItemCalibre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				criarTelaC(tc);
			}
		});
		menuTelas.add(menuItemCalibre);
		
		JMenu menuItemFabricante = new JMenu("Fabricante");
		menuItemFabricante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				criarTelaF(tf);
			}
		});
		menuTelas.add(menuItemFabricante);
		
		JMenu menuItemPersonagem = new JMenu("Personagem");
		menuItemPersonagem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				criarTelaP(tp);
			}
		});
		menuTelas.add(menuItemPersonagem);
		
		JMenu menuItemObraEscrita = new JMenu("Obra Escrita");
		menuItemObraEscrita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				criarTelaOE(toe);
			}
		});
		menuTelas.add(menuItemObraEscrita);
		
		JMenu menuItemFilme = new JMenu("Filme");
		menuItemFilme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				criarTelaM(tm);
			}
		});
		menuTelas.add(menuItemFilme);
		
		JMenu menuItemGame = new JMenu("Game");
		menuItemGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				criarTelaG(tg);
			}
		});
		menuTelas.add(menuItemGame);
		
		JMenu menuItemSerie = new JMenu("S\u00E9rie");
		menuItemSerie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				criarTelaS(ts);
			}
		});
		menuTelas.add(menuItemSerie);
		
		JMenu menuSistema = new JMenu("Sistema");
		
		
		barraMenu.add(menuSistema);
		
		JMenu menuItemSair = new JMenu("Sair");
		menuItemSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent eventoMouse) {
				System.exit(0);
			}
		});
		menuSistema.add(menuItemSair);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane painelTelas = new JDesktopPane();
		contentPane.add(painelTelas, BorderLayout.CENTER);
	}
	
	public void criarTelaC(TelaCalibre tCal) {
		tCal = new TelaCalibre(pass);
		exibirTela(tCal);
	}
	
	public void criarTelaA(TelaArma tArma) {
		tArma = new TelaArma(pass);
		exibirTela(tArma);
	}

	public void criarTelaP(TelaPersonagem tPer) {
		tPer = new TelaPersonagem(pass);
		exibirTela(tPer);
	}
	
	public void criarTelaF(TelaFabricante tFab) {
		tFab = new TelaFabricante(pass);
		exibirTela(tFab);
	}
	
	public void criarTelaM(TelaFilme tFil) {
		tFil = new TelaFilme(pass);
		exibirTela(tFil);
	}
	
	public void criarTelaG(TelaGame tGame) {
		tGame = new TelaGame(pass);
		exibirTela(tGame);
	}
	
	public void criarTelaS(TelaSerie tSerie) {
		tSerie = new TelaSerie(pass);
		exibirTela(tSerie);
	}
	
	public void criarTelaOE(TelaObraEscrita tOE) {
		tOE = new TelaObraEscrita(pass);
		exibirTela(tOE);
	}

	@Override
	public void exibirTela(Tela t) {
		// TODO Auto-generated method stub
		t.setVisible(true);
		t.requestFocus();
	}

}
