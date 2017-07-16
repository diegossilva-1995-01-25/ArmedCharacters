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

import control.CtrObra;
import control.CtrSerie;
import model.Arma;
import model.Fabricante;
import model.Obra;
import obrachildren.ObraVisual;
import obrachildren.obravisualchildren.Game;
import obrachildren.obravisualchildren.Serie;
import view.TelaObra;

import javax.swing.JButton;
import javax.swing.JTable;

public class PanelSerie extends PanelObraVisual implements ActionListener, ListSelectionListener {
	private final JTextField txtNumEpisodios = new JTextField();
	private JTextField txtNumTemporadas;
	private JTextField txtTipoSerie;
	private final JButton btnConsultar = new JButton("Consultar");
	private JTable tableSerie;
	private JScrollPane rolagem;
	private TelaObra tO;
	private ObraVisual obraVisual;
	private Serie serie;
	private CtrSerie controleSerie;
	private CtrObra controleObra;
	private Obra obra;

	/**
	 * Create the panel.
	 */
	public PanelSerie(Obra o, ObraVisual oV) {
		super(o);
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 5, 5));
		
		JLabel lblNumEpisodios = new JLabel("N\u00FAmero de Epis\u00F3dios");
		panel.add(lblNumEpisodios);
		panel.add(txtNumEpisodios);
		txtNumEpisodios.setColumns(10);
		
		JLabel lblNumTemporadas = new JLabel("N\u00FAmero de Temporadas");
		panel.add(lblNumTemporadas);
		
		txtNumTemporadas = new JTextField();
		txtNumTemporadas.setColumns(10);
		panel.add(txtNumTemporadas);
		
		JLabel lblTipoSerie = new JLabel("Tipo de S\u00E9rie");
		panel.add(lblTipoSerie);
		
		txtTipoSerie = new JTextField();
		txtTipoSerie.setColumns(10);
		panel.add(txtTipoSerie);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		panel.add(btnAdicionar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(this);
		panel.add(btnAlterar);
		btnConsultar.addActionListener(this);
		panel.add(btnConsultar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(this);
		panel.add(btnExcluir);
		
		controleSerie = new CtrSerie();
		
		rolagem = new JScrollPane();
		tableSerie = new JTable(controleSerie);
		tableSerie.getSelectionModel().addListSelectionListener(this);
		rolagem.getViewport().add(tableSerie); // Esta linha
		add(rolagem, BorderLayout.CENTER);
		
		tO = new TelaObra();
		obra = o;
		obraVisual = oV;
		
		serie = new Serie();
		controleObra = new CtrObra();
		
		controleSerie.consultarSerie(tO.txtTitulo.getText());
		atualizarTabela();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		
		if(comando.equals("Adicionar")) {
			serie = new Serie();
			serie = telaParaSerie(serie);
			controleObra.adicionarObra(obra);
			controleSerie.adicionarSerie(serie);
			limparTela();
			
		} else if(comando.equals("Alterar")) {
			serie = new Serie();
			serie = telaParaSerie(serie);
			controleObra.adicionarObra(obra);
			controleSerie.alterarSerie(serie);
			limparTela();
			
		} else if(comando.equals("Consultar")) {
			//serie = new Serie();
			//serie = telaParaSerie(serie);
			//controleObra.consultarObra(obra.getTitulo());
			controleSerie.consultarSerie(tO.txtTitulo.getText());
			atualizarTabela();
			limparTela();
			
		} else if(comando.equals("Excluir")) {
			serie = new Serie();
			serie = telaParaSerie(serie);
			obra = controleObra.excluirObra(obra);
			serie = controleSerie.excluirSerie(serie);
			limparTela();
			
		}
	}
	
	public void atualizarTabela() {
		tableSerie.invalidate();
		tableSerie.revalidate();
		tableSerie.repaint();
	}
	
	public Serie telaParaSerie(Serie s) {
		s.setId(Integer.parseInt(tO.txtId.getText()));
		s.setTitulo(tO.txtTitulo.getText());
		s.setAno(Integer.parseInt(tO.txtAno.getText()));
		s.setGenero(tO.txtGenero.getText());
		s.setDistribuidora(txtDistribuidora.getText());
		s.setFranquia(txtFranquia.getText());
		s.setNumEpisodios(Integer.parseInt(txtNumEpisodios.getText()));
		s.setNumTemporadas(Integer.parseInt(txtNumTemporadas.getText()));
		s.setTipoSerie(txtTipoSerie.getText());
		
		return s;
	}
	
	public void serieParaTela(Serie s) {
		tO.txtId.setText(String.valueOf(s.getId()));
		tO.txtTitulo.setText(s.getTitulo());
		tO.txtAno.setText(String.valueOf(s.getAno()));
		tO.txtGenero.setText(s.getGenero());
		txtDistribuidora.setText(s.getDistribuidora());
		txtFranquia.setText(s.getFranquia());
		txtNumEpisodios.setText(String.valueOf(s.getNumEpisodios()));
		txtNumTemporadas.setText(String.valueOf(s.getNumTemporadas()));
		txtTipoSerie.setText(s.getTipoSerie());
	}
	
	public void limparTela() {
		tO.txtId.setText("");
		tO.txtTitulo.setText("");
		tO.txtAno.setText("");
		tO.txtGenero.setText("");
		txtDistribuidora.setText("");
		txtFranquia.setText("");
		txtNumEpisodios.setText("");
		txtNumTemporadas.setText("");
		txtTipoSerie.setText("");
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		int linha = tableSerie.getSelectedRow();
		Serie s = controleSerie.retornarLinha(linha);
		serieParaTela(s);
	}
	
}
