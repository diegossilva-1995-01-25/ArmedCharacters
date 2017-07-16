package view;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.event.ChangeListener;

import model.Obra;
import obrachildren.obravisualchildren.Filme;
import view.obrapanels.PanelObraEscrita;
import view.obrapanels.PanelObraVisual;

import javax.swing.event.ChangeEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaObra extends Tela implements ActionListener {
	public JTextField txtId;
	public JTextField txtTitulo;
	public JTextField txtAno;
	public JTextField txtGenero;
	
	public JRadioButton rdObraEscrita;
	public JRadioButton rdObraVisual;
	private PanelObraEscrita pOE;
	private PanelObraVisual pOV;
	
	private Obra obra;
	
	
	/**
	 * Create the frame.
	 */
	public TelaObra() {
		setTitle("Tela de Cadastro de Obras");
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
		
		rdObraEscrita = new JRadioButton("Obra Escrita");
		rdObraEscrita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdObraEscrita.setSelected(true);
				rdObraVisual.setSelected(false);
			}
		});
		rdObraEscrita.addActionListener(this);
		panel.add(rdObraEscrita);
		
		rdObraVisual = new JRadioButton("Obra Visual");
		rdObraVisual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rdObraVisual.setSelected(true);
				rdObraEscrita.setSelected(false);
			}
		});
		rdObraVisual.addActionListener(this);
		panel.add(rdObraVisual);
		
		obra = new Obra();

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String origem = e.getActionCommand();
		obra = telaParaObra(obra);
		
		if(origem.equals("Obra Escrita")) {
			
			if(rdObraEscrita.isSelected() == true) {
				
				if(pOE == null) { 
					pOE = new PanelObraEscrita(obra);
				}
								
				if(pOV != null) {
					getContentPane().remove(pOV);
				}
				
				getContentPane().add(pOE, BorderLayout.CENTER);
				atualizarTela();
			}
			
			
		} else if(origem.equals("Obra Visual")) {
			
			if(rdObraVisual.isSelected() == true) {
				
				if(pOV == null) { 
					pOV = new PanelObraVisual(obra);
				}
				
				if(pOE != null) {
					getContentPane().remove(pOE);
				}
				
				getContentPane().add(pOV, BorderLayout.CENTER);
				atualizarTela();
			}
			
			
		} 
		
	}
	
	private void atualizarTela() {
		getContentPane().invalidate();
		getContentPane().revalidate();
		getContentPane().repaint();
	}


	@Override
	public void limparTela() {
		// TODO Auto-generated method stub
		
	}
	
	public Obra telaParaObra(Obra o) {
		o.setId(Integer.parseInt(txtId.getText()));
		o.setTitulo(txtTitulo.getText());
		o.setAno(Integer.parseInt(txtAno.getText()));
		o.setGenero(txtGenero.getText());
		
		return o;
	}
	
	public void obraParaTela(Obra o) {
		txtId.setText(String.valueOf(o.getId()));
		txtTitulo.setText(o.getTitulo());
		txtAno.setText(String.valueOf(o.getAno()));
		txtGenero.setText(o.getGenero());
		
	}

}
