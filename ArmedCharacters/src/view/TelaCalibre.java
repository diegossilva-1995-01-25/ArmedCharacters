package view;
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

import control.CtrCalibre;
import model.Arma;
import model.Calibre;
import model.Fabricante;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;

public class TelaCalibre extends Tela implements ActionListener, ListSelectionListener {
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtTipoMunicao;
	private JTextField txtDiametroProjetil;
	private JTable tableCalibre;
	private JTextField txtComprimento;
	private JScrollPane rolagem;
	private Calibre calibre;
	private CtrCalibre controleCalibre;
	private String pass;
	
	/**
	 * Create the frame.
	 */
	public TelaCalibre(String senha) {
		pass = senha;
		
		setTitle("Tela de Cadastro de Calibres");
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
		
		JLabel lblTipoMunicao = new JLabel("Tipo de Muni\u00E7\u00E3o");
		panel.add(lblTipoMunicao);
		
		txtTipoMunicao = new JTextField();
		txtTipoMunicao.setColumns(10);
		panel.add(txtTipoMunicao);
		
		JLabel lblDiametroProjetil = new JLabel("Di\u00E2metro do Projetil");
		panel.add(lblDiametroProjetil);
		
		txtDiametroProjetil = new JTextField();
		txtDiametroProjetil.setColumns(10);
		panel.add(txtDiametroProjetil);
		
		JLabel lblComprimento = new JLabel("Comprimento");
		panel.add(lblComprimento);
		
		txtComprimento = new JTextField();
		txtComprimento.setColumns(10);
		panel.add(txtComprimento);
		
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
		
		controleCalibre = new CtrCalibre(pass);
		
		rolagem = new JScrollPane();
		tableCalibre = new JTable(controleCalibre);
		tableCalibre.getSelectionModel().addListSelectionListener(this);
		rolagem.getViewport().add(tableCalibre);
		getContentPane().add(rolagem, BorderLayout.CENTER);
		
		controleCalibre.consultarCalibre("");
		atualizarTabela();

	}
	
	public Calibre telaParaCalibre(Calibre c) {
		c.setId(Integer.parseInt(txtId.getText()));
		c.setNome(txtNome.getText());
		c.setTipoMunicao(txtTipoMunicao.getText());
		c.setDiametroProjetil(Double.parseDouble(txtDiametroProjetil.getText()));
		c.setComprimento(Double.parseDouble(txtComprimento.getText()));
		
		return c;
	}
	
	public void calibreParaTela(Calibre c) {
		txtId.setText(String.valueOf(c.getId()));
		txtNome.setText(c.getNome());
		txtTipoMunicao.setText(c.getTipoMunicao());
		txtDiametroProjetil.setText(String.valueOf(c.getDiametroProjetil()));
		txtComprimento.setText(String.valueOf(c.getComprimento()));
	}

	@Override
	public void limparTela() {
		// TODO Auto-generated method stub
		txtId.setText("");
		txtNome.setText("");
		txtTipoMunicao.setText("");
		txtDiametroProjetil.setText("");
		txtComprimento.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		
		if(comando.equals("Adicionar")) {
			calibre = new Calibre();
			calibre = telaParaCalibre(calibre);
			controleCalibre.adicionarCalibre(calibre);
			controleCalibre.consultarCalibre("");
			atualizarTabela();
			limparTela();
			
		} else if(comando.equals("Alterar")) {
			calibre = new Calibre();
			calibre = telaParaCalibre(calibre);
			controleCalibre.alterarCalibre(calibre);
			controleCalibre.consultarCalibre("");
			atualizarTabela();
			limparTela();
			
		} else if(comando.equals("Consultar")) {
			calibre = new Calibre();
			//calibre = telaParaCalibre(calibre);
			controleCalibre.consultarCalibre(txtNome.getText());
			atualizarTabela();
			limparTela();
			
		} else if(comando.equals("Excluir")) {
			calibre = new Calibre();
			calibre = telaParaCalibre(calibre);
			calibre = controleCalibre.excluirCalibre(calibre);
			controleCalibre.consultarCalibre("");
			atualizarTabela();
			limparTela();
			
		}
		
		
	}
	
	public void atualizarTabela() {
		tableCalibre.invalidate();
		tableCalibre.revalidate();
		tableCalibre.repaint();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		int linha = tableCalibre.getSelectedRow();
		Calibre c = controleCalibre.retornarLinha(linha);
		calibreParaTela(c);
	}

}
