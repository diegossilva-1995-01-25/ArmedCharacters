package view.obrapanels;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.CtrFilme;
import control.CtrGame;
import control.CtrObra;
import model.Fabricante;
import model.Obra;
import obrachildren.ObraVisual;
import obrachildren.obravisualchildren.Game;
import view.TelaObra;

import javax.swing.JButton;
import javax.swing.JTable;

public class PanelGame extends PanelObraVisual implements ActionListener, ListSelectionListener {
	private JTextField txtPlataformas;
	private JTextField txtCriador;
	private JTextField txtDesenvolvedoras;
	private JTable tableGame;
	private JScrollPane rolagem;
	private TelaObra tO;
	private ObraVisual obraVisual;
	private Game game;
	private Obra obra;
	private CtrGame controleGame;
	private CtrObra controleObra;
	

	/**
	 * Create the panel.
	 */
	public PanelGame(Obra o, ObraVisual oV) {
		super(o);
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 5, 5));
		
		JLabel lblPlataformas = new JLabel("Plataformas");
		panel.add(lblPlataformas);
		
		txtPlataformas = new JTextField();
		panel.add(txtPlataformas);
		txtPlataformas.setColumns(10);
		
		JLabel lblCriador = new JLabel("Criador");
		panel.add(lblCriador);
		
		txtCriador = new JTextField();
		txtCriador.setColumns(10);
		panel.add(txtCriador);
		
		JLabel lblDesenvolvedoras = new JLabel("Desenvolvedoras");
		panel.add(lblDesenvolvedoras);
		
		txtDesenvolvedoras = new JTextField();
		txtDesenvolvedoras.setColumns(10);
		panel.add(txtDesenvolvedoras);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		panel.add(btnAdicionar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(this);
		panel.add(btnAlterar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		panel.add(btnConsultar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(this);
		panel.add(btnExcluir);
		
		controleGame = new CtrGame();
		obra = o;
		obraVisual = oV;
		
		rolagem = new JScrollPane();
		tableGame = new JTable(controleGame);
		tableGame.getSelectionModel().addListSelectionListener(this);
		rolagem.getViewport().add(tableGame); // Esta linha
		add(rolagem, BorderLayout.CENTER);
		
		tO = new TelaObra();
		controleObra = new CtrObra();
		
		controleGame.consultarGame(tO.txtTitulo.getText());
		atualizarTabela();	

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		
		if(comando.equals("Adicionar")) {
			game = new Game();
			game = telaParaGame(game);
			controleObra.adicionarObra(obra);
			controleGame.adicionarGame(game);
			limparTela();
			
		} else if(comando.equals("Alterar")) {
			game = new Game();
			game = telaParaGame(game);
			controleObra.alterarObra(obra);
			controleGame.alterarGame(game);
			limparTela();
			
		} else if(comando.equals("Consultar")) {
			//game = new Game();
			//game = telaParaGame(game);
			//controleObra.consultarObra(obra.getTitulo());
			controleGame.consultarGame(tO.txtTitulo.getText());
			atualizarTabela();
			limparTela();
			
		} else if(comando.equals("Excluir")) {
			game = new Game();
			game = telaParaGame(game);
			obra = controleObra.excluirObra(obra);
			game = controleGame.excluirGame(game);
			limparTela();
			
		}
	}

	public void atualizarTabela() {
		tableGame.invalidate();
		tableGame.revalidate();
		tableGame.repaint();
	}
	
	public Game telaParaGame(Game g) {
		g.setId(Integer.parseInt(tO.txtId.getText()));
		g.setTitulo(tO.txtTitulo.getText());
		g.setAno(Integer.parseInt(tO.txtAno.getText()));
		g.setGenero(tO.txtGenero.getText());
		g.setDistribuidora(txtDistribuidora.getText());
		g.setFranquia(txtFranquia.getText());
		g.setPlataformas(txtPlataformas.getText());
		g.setCriador(txtCriador.getText());
		g.setDesenvolvedoras(txtDesenvolvedoras.getText());
		
		return g;
	}
	
	public void gameParaTela(Game g) {
		tO.txtId.setText(String.valueOf(g.getId()));
		tO.txtTitulo.setText(g.getTitulo());
		tO.txtAno.setText(String.valueOf(g.getAno()));
		tO.txtGenero.setText(g.getGenero());
		txtDistribuidora.setText(g.getDistribuidora());
		txtFranquia.setText(g.getFranquia());
		txtPlataformas.setText(g.getPlataformas());
		txtCriador.setText(g.getCriador());
		txtDesenvolvedoras.setText(g.getDesenvolvedoras());
	}
	
	public void limparTela() {
		tO.txtId.setText("");
		tO.txtTitulo.setText("");
		tO.txtAno.setText("");
		tO.txtGenero.setText("");
		txtDistribuidora.setText("");
		txtFranquia.setText("");
		txtPlataformas.setText("");
		txtCriador.setText("");
		txtDesenvolvedoras.setText("");
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		int linha = tableGame.getSelectedRow();
		Game g = controleGame.retornarLinha(linha);
		gameParaTela(g);
	}
	
}
