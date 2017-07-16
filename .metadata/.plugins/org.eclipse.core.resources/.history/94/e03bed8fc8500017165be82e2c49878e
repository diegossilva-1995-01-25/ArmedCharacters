package view.obrapanels;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.Obra;
import obrachildren.ObraVisual;

import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelObraVisual extends PanelAbstrato implements ActionListener {
	public JTextField txtDistribuidora;
	public JTextField txtFranquia;
	
	private PanelFilme pF;
	private PanelGame pG;
	private PanelSerie pS;

	private JRadioButton rdFilme;
	private JRadioButton rdGame;
	private JRadioButton rdSerie;
	
	private Obra obra;
	private ObraVisual obraVisual;
	
	/**
	 * Create the panel.
	 */
	public PanelObraVisual(Obra o) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 5, 5));
		
		JLabel lblDistribuidora = new JLabel("Distribuidora");
		panel.add(lblDistribuidora);
		
		txtDistribuidora = new JTextField();
		panel.add(txtDistribuidora);
		txtDistribuidora.setColumns(10);
		
		JLabel lblFranquia = new JLabel("Franquia");
		panel.add(lblFranquia);
		
		txtFranquia = new JTextField();
		txtFranquia.setColumns(10);
		panel.add(txtFranquia);
		
		rdFilme = new JRadioButton("Filme");
		rdFilme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdFilme.setSelected(true);
				rdGame.setSelected(false);
				rdSerie.setSelected(false);
			}
		});
		rdFilme.addActionListener(this);
		panel.add(rdFilme);
		
		rdGame = new JRadioButton("Game");
		rdGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdFilme.setSelected(false);
				rdGame.setSelected(true);
				rdSerie.setSelected(false);
			}
		});
		rdGame.addActionListener(this);
		panel.add(rdGame);
		
		rdSerie = new JRadioButton("S\u00E9rie");
		rdSerie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdFilme.setSelected(false);
				rdGame.setSelected(false);
				rdSerie.setSelected(true);
			}
		});
		rdSerie.addActionListener(this);
		panel.add(rdSerie);
		
		obra = o;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String origem = e.getActionCommand();
		obraVisual = telaParaObraVisual(obraVisual);
		
		if(origem.equals("Filme")) {
			
			if(rdFilme.isSelected() == true) {
				
				if(pF == null) {
					pF = new PanelFilme(obra, obraVisual);
				}
				
				if(pG != null) {
					this.remove(pG);
				}
				
				if(pS != null) {
					this.remove(pS);
				}
				
				this.add(pF, BorderLayout.CENTER);
				
				atualizarTela();
				
			}
			
		} else if(origem.equals("Game")) {
			
			if(rdGame.isSelected() == true) {
				
				if(pG == null) {
					pG = new PanelGame(obra, obraVisual);
				}
				
				if(pF != null) {
					this.remove(pF);
				}
				
				if(pS != null) {
					this.remove(pS);
				}
				
				this.add(pG, BorderLayout.CENTER);
				
				atualizarTela();
				
			}
			
		} else if(origem.equals("Série")) {
			
			if(rdSerie.isSelected() == true) {
				
				if(pS == null) {
					pS = new PanelSerie(obra, obraVisual);
				}
				
				if(pF != null) {
					this.remove(pF);
				}
				
				if(pG != null) {
					this.remove(pG);
				}
				
				this.add(pS, BorderLayout.CENTER);
				
				atualizarTela();
				
			}
			
		}
		
	}
	
	private void atualizarTela() {
		this.invalidate();
		this.revalidate();
		this.repaint();
	}

	@Override
	public void obraParaTela(Obra o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Obra telaParaObra(Obra o) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ObraVisual telaParaObraVisual(ObraVisual oV) {
		oV.setDistribuidora(txtDistribuidora.getText());
		oV.setFranquia(txtFranquia.getText());
		
		return oV;
	}
	
	public void obraVisuakParaTela(ObraVisual oV) {
		txtDistribuidora.setText(oV.getDistribuidora());
		txtFranquia.setText(oV.getFranquia());
		
	}

}
