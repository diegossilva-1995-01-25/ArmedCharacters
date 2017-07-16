package view;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.CtrFabricante;
import model.Arma;
import model.Calibre;
import model.Fabricante;
import model.Personagem;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;

public class TelaFabricante extends Tela implements ActionListener, ListSelectionListener {
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtOrigem;
	private JTextField txtAnoFundacao;
	private JTable tableFabricante;
	private JTextField txtFundador;
	private JScrollPane rolagem;
	private Fabricante fabricante;
	private CtrFabricante controleFabricante;
	private String pass;
	
	/**
	 * Create the frame.
	 */
	public TelaFabricante(String senha) {
		pass = senha;
		
		setTitle("Tela de Cadastro de Fabricantes");
		setResizable(false);
		setBounds(100, 100, 600, 600);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 5, 5));
		
		JLabel lblId = new JLabel("Id");
		panel.add(lblId);
		
		txtId = new JTextField();
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		panel.add(txtNome);
		
		JLabel lblOrigem = new JLabel("Origem");
		panel.add(lblOrigem);
		
		txtOrigem = new JTextField();
		txtOrigem.setColumns(10);
		panel.add(txtOrigem);
		
		JLabel lblAnoFundacao = new JLabel("Ano de Funda\u00E7\u00E3o");
		panel.add(lblAnoFundacao);
		
		txtAnoFundacao = new JTextField();
		txtAnoFundacao.setColumns(10);
		panel.add(txtAnoFundacao);
		
		JLabel lblFundador = new JLabel("Fundador");
		panel.add(lblFundador);
		
		txtFundador = new JTextField();
		txtFundador.setColumns(10);
		panel.add(txtFundador);
		
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
		
		controleFabricante = new CtrFabricante(pass);
		
		rolagem = new JScrollPane();
		tableFabricante = new JTable(controleFabricante);
		tableFabricante.getSelectionModel().addListSelectionListener(this);
		rolagem.getViewport().add(tableFabricante); // Esta linha
		getContentPane().add(rolagem, BorderLayout.CENTER);
		
		controleFabricante.consultarFabricante("");
		atualizarTabela();

	}
	
	public Fabricante telaParaFabricante(Fabricante f) {
		f.setId(Integer.parseInt(txtId.getText()));
		f.setNome(txtNome.getText());
		f.setOrigem(txtOrigem.getText());
		f.setAnoFundacao(Integer.parseInt(txtAnoFundacao.getText()));
		f.setFundador(txtFundador.getText());
		
		return f;
	}
	
	public void fabricanteParaTela(Fabricante f) {
		txtId.setText(String.valueOf(f.getId()));
		txtNome.setText(f.getNome());
		txtOrigem.setText(f.getOrigem());
		txtAnoFundacao.setText(String.valueOf(f.getAnoFundacao()));
		txtFundador.setText(f.getFundador());
	}

	@Override
	public void limparTela() {
		// TODO Auto-generated method stub
		txtId.setText("");
		txtNome.setText("");
		txtOrigem.setText("");
		txtAnoFundacao.setText("");
		txtFundador.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		
		if(comando.equals("Adicionar")) {
			fabricante = new Fabricante();
			fabricante = telaParaFabricante(fabricante);
			controleFabricante.adicionarFabricante(fabricante);
			controleFabricante.consultarFabricante("");
			atualizarTabela();
			limparTela();
			
		} else if(comando.equals("Alterar")) {
			fabricante = new Fabricante();
			fabricante = telaParaFabricante(fabricante);
			controleFabricante.alterarFabricante(fabricante);
			controleFabricante.consultarFabricante("");
			atualizarTabela();
			limparTela();
			
		} else if(comando.equals("Consultar")) {
			//fabricante = new Fabricante();
			//fabricante = telaParaFabricante(fabricante);
			controleFabricante.consultarFabricante(txtNome.getText());
			atualizarTabela();
			limparTela();
			
		} else if(comando.equals("Excluir")) {
			fabricante = new Fabricante();
			fabricante = telaParaFabricante(fabricante);
			fabricante = controleFabricante.excluirFabricante(fabricante);
			controleFabricante.consultarFabricante("");
			atualizarTabela();
			limparTela();
			
		}
		
		
	}
	
	public void atualizarTabela() {
		tableFabricante.invalidate();
		tableFabricante.revalidate();
		tableFabricante.repaint();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		int linha = tableFabricante.getSelectedRow();
		Fabricante f = controleFabricante.retornarLinha(linha);
		fabricanteParaTela(f);
	}

}