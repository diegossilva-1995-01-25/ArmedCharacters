package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.CtrFilme;
import control.CtrObra;
import model.Obra;
import obrachildren.obravisualchildren.Filme;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TelaFilme extends Tela implements ActionListener, ListSelectionListener {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtTitulo;
	private JTextField txtAno;
	private JTextField txtGenero;
	private JTextField txtDistribuidora;
	private JTextField txtFranquia;
	private JTextField txtTituloDublado;
	private JTextField txtDiretor;
	private JTable tableFilme;
	private CtrFilme controleFilme;
	private CtrObra controleObra;
	private JScrollPane rolagem;
	private Obra obra;
	private Filme filme;
	private String pass;

	/**
	 * Create the frame.
	 */
	public TelaFilme(String senha) {
		setTitle("Tela de Cadastro de Filmes");
		pass = senha;
		
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 5, 5));
		
		JLabel lblId = new JLabel("Id");
		panel.add(lblId);
		
		txtId = new JTextField();
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo");
		panel.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		panel.add(txtTitulo);
		
		JLabel lblAno = new JLabel("Ano");
		panel.add(lblAno);
		
		txtAno = new JTextField();
		txtAno.setColumns(10);
		panel.add(txtAno);
		
		JLabel lblGenero = new JLabel("G\u00EAnero");
		panel.add(lblGenero);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		panel.add(txtGenero);
		
		JLabel lblDistribuidora = new JLabel("Distribuidora");
		panel.add(lblDistribuidora);
		
		txtDistribuidora = new JTextField();
		txtDistribuidora.setColumns(10);
		panel.add(txtDistribuidora);
		
		JLabel lblFranquia = new JLabel("Franquia");
		panel.add(lblFranquia);
		
		txtFranquia = new JTextField();
		txtFranquia.setColumns(10);
		panel.add(txtFranquia);
		
		JLabel lblTituloDublado = new JLabel("T\u00EDtulo Dublado");
		panel.add(lblTituloDublado);
		
		txtTituloDublado = new JTextField();
		txtTituloDublado.setColumns(10);
		panel.add(txtTituloDublado);
		
		JLabel lblDiretor = new JLabel("Diretor");
		panel.add(lblDiretor);
		
		txtDiretor = new JTextField();
		txtDiretor.setColumns(10);
		panel.add(txtDiretor);
		
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
		
		JPanel panelTabela = new JPanel();
		contentPane.add(panelTabela, BorderLayout.CENTER);
		
		obra = new Obra();
		filme = new Filme();
		controleFilme = new CtrFilme(pass);
		controleObra = new CtrObra(pass);
		
		rolagem = new JScrollPane();
		tableFilme = new JTable(controleFilme);
		tableFilme.getSelectionModel().addListSelectionListener(this);
		rolagem.setViewportView(tableFilme);
		getContentPane().add(rolagem, BorderLayout.CENTER);
		
		controleFilme.consultarFilme("");
		atualizarTabela();
	}

	@Override
	public void limparTela() {
		// TODO Auto-generated method stub
		txtId.setText("");
		txtTitulo.setText("");
		txtAno.setText("");
		txtGenero.setText("");
		txtDistribuidora.setText("");
		txtFranquia.setText("");
		txtTituloDublado.setText("");
		txtDiretor.setText("");
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		int linha = tableFilme.getSelectedRow();
		Filme f = controleFilme.retornarLinha(linha);
		filmeParaTela(f);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		
		if(comando.equals("Adicionar")) {
			filme = new Filme();
			filme = telaParaFilme(filme);
			obra = new Obra();
			obra = telaParaObra(obra);
			controleObra.adicionarObra(obra);
			controleFilme.adicionarFilme(filme);
			controleFilme.consultarFilme("");
			atualizarTabela();
			limparTela();
			
		} else if(comando.equals("Alterar")) {
			filme = new Filme();
			filme = telaParaFilme(filme);
			obra = new Obra();
			obra = telaParaObra(obra);
			controleFilme.alterarFilme(filme);
			controleObra.alterarObra(obra);
			controleFilme.consultarFilme("");
			atualizarTabela();
			limparTela();
			
		} else if(comando.equals("Consultar")) {
			//filme = new Filme();
			//filme = telaParaFilme(filme);
			//controleObra.consultarObra(obra.getTitulo());
			controleFilme.consultarFilme(txtTitulo.getText());
			atualizarTabela();
			limparTela();
			
		} else if(comando.equals("Excluir")) {
			filme = new Filme();
			filme = telaParaFilme(filme);
			obra = new Obra();
			obra = telaParaObra(obra);
			filme = controleFilme.excluirFilme(filme);
			obra = controleObra.excluirObra(obra);
			controleFilme.consultarFilme("");
			atualizarTabela();
			limparTela();
			
		}
	}
	
	public Filme telaParaFilme(Filme f) {
		f.setId(Integer.parseInt(txtId.getText()));
		f.setTitulo(txtTitulo.getText());
		f.setAno(Integer.parseInt(txtAno.getText()));
		f.setGenero(txtGenero.getText());
		f.setDistribuidora(txtDistribuidora.getText());
		f.setFranquia(txtFranquia.getText());
		f.setTituloDublado(txtTituloDublado.getText());
		f.setDiretor(txtDiretor.getText());
		
		return f;
	}
	
	public void filmeParaTela(Filme f) {
		txtId.setText(String.valueOf(f.getId()));
		txtTitulo.setText(f.getTitulo());
		txtAno.setText(String.valueOf(f.getAno()));
		txtGenero.setText(f.getGenero());
		txtDistribuidora.setText(f.getDistribuidora());
		txtFranquia.setText(f.getFranquia());
		txtTituloDublado.setText(f.getTituloDublado());
		txtDiretor.setText(f.getDiretor());
	}
	
	public void atualizarTabela() {
		tableFilme.invalidate();
		tableFilme.revalidate();
		tableFilme.repaint();
	}
	
	public Obra telaParaObra(Obra o) {
		o.setId(Integer.parseInt(txtId.getText()));
		o.setTitulo(txtTitulo.getText());
		o.setAno(Integer.parseInt(txtAno.getText()));
		o.setGenero(txtGenero.getText());
		
		return o;
	}

}