package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import dao.DAOConexaoSingleton;
import list.ListArmasCalibre;
import list.ListArmasFabricante;
import model.Arma;
import model.Calibre;
import model.Fabricante;
import model.Personagem;

/*
 * Autor: Diego Souza Silva
 * Data: 05/06/2017;
 */

public class CtrFabricante implements ListArmasFabricante, TableModel {
	private Fabricante fabricante;
	private List<Fabricante> listaFabricantes = new ArrayList<>();
	private Connection conex;
	//private ListArmasCalibre armasCalibre;
	private List<Arma> listArmas;
	private Arma arma;
	private String pass;
	
	public CtrFabricante(String senha) {
		pass = senha;
		//listaFabricantes = new ArrayList<>();
		//listArmas = armasCalibre.instanciarLista();
		conex = DAOConexaoSingleton.getInstanciaUnica(pass).getConexao();
		arma = new Arma();
		fabricante = new Fabricante();
	}
	
	public void adicionarFabricante(Fabricante f) {
		String sql = "INSERT INTO fabricante (id, nome, origem, anoFundacao, fundador) "
				+ "VALUES (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement statem = conex.prepareStatement(sql);
			statem.setInt(1, f.getId());
			statem.setString(2, f.getNome());
			statem.setString(3, f.getOrigem());
			statem.setInt(4, f.getAnoFundacao());
			statem.setString(5, f.getFundador());
			statem.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alterarFabricante(Fabricante f) {
		String sql = "UPDATE fabricante SET id = ?, nome = ?, origem = ?, anoFundacao = ?,"
				+ "fundador = ?";
		
		try {
			PreparedStatement statem = conex.prepareStatement(sql);
			statem.setInt(1, f.getId());
			statem.setString(2, f.getNome());
			statem.setString(3, f.getOrigem());
			statem.setInt(4, f.getAnoFundacao());
			statem.setString(5, f.getFundador());
			statem.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Fabricante excluirFabricante(Fabricante f) {
		String sql = "DELETE FROM fabricante WHERE id = ?";
		
		try {
			PreparedStatement statem = conex.prepareStatement(sql);
			statem.setInt(1, f.getId());
			statem.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}
	
	public List<Fabricante> consultarFabricante(String nome) {
		listaFabricantes = new ArrayList<>();
		String sql = "SELECT * FROM fabricante WHERE nome LIKE ?";
		
		try {
			PreparedStatement statem = conex.prepareStatement(sql);
			statem.setString(1, "%" + nome + "%");
			ResultSet rs = statem.executeQuery();
			
			while(rs.next()) {
				Fabricante f = new Fabricante();
				
				f.setId(rs.getInt("id"));
				f.setNome(rs.getString("nome"));
				f.setOrigem(rs.getString("origem"));
				f.setAnoFundacao(rs.getInt("anoFundacao"));
				f.setFundador(rs.getString("fundador"));
				listaFabricantes.add(f);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaFabricantes;
	}
	
	public int contarFabricante() {
		int contagem = 0;
		
		
		
		return contagem;
	}

	@Override
	public List<Arma> instanciarLista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void adicionarArma(Arma a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarArmas(String nomeFabricante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Arma removerArma(Arma a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		
			case 0: return Integer.class;
			case 1: return String.class;
			case 2: return String.class;
			case 3: return Integer.class;
			case 4: return String.class;
			
		}
		
		return String.class;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		
			case 0: return "Id";
			case 1: return "Nome";
			case 2: return "Origem";
			case 3: return "Ano de Funda��o";
			case 4: return "Fundador";
			
		}
		
		return "";
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaFabricantes.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Fabricante f = listaFabricantes.get(rowIndex);
		
		switch (columnIndex) {
		
			case 0: return f.getId();
			case 1: return f.getNome();
			case 2: return f.getOrigem();
			case 3: return f.getAnoFundacao();
			case 4: return f.getFundador();
		
		}
	
		return "";
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}
	
	public Fabricante retornarLinha(int linha) {
		return listaFabricantes.get(linha);
	}
	
}
