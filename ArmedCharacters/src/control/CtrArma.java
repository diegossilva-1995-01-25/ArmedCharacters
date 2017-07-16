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
import model.Arma;
import model.Fabricante;

/*
 * Autor: Diego Souza Silva
 * Data: 05/06/2017;
 */

public class CtrArma implements TableModel {
	private Arma arma;
	private List<Arma> listaArmas;
	Connection conex;
	private String pass;
	
	public CtrArma(String senha) {
		pass = senha;
		listaArmas = new ArrayList<>();
		conex = DAOConexaoSingleton.getInstanciaUnica(pass).getConexao();
		arma = new Arma();
	}
	
	public void adicionarArma(Arma a) {
		String sql = "INSERT INTO arma (id, modelo, nomeNaObra, peso, comprimento, "
				+ "alcance, equipamentos, capacidade, personagem, calibre, fabricante) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement statem = conex.prepareStatement(sql);
			statem.setInt(1, a.getId());
			statem.setString(2, a.getModelo());
			statem.setString(3, a.getNomeNaObra());
			statem.setDouble(4, a.getPeso());
			statem.setDouble(5, a.getComprimentoCm());
			statem.setInt(6, a.getAlcance());
			statem.setString(7, a.getEquipamentos());
			statem.setInt(8, a.getCapacidade());
			statem.setInt(9, a.getPersongem());
			statem.setInt(10, a.getCalibre());
			statem.setInt(11, a.getFabricante());
			statem.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void alterarArma(Arma a) {
		String sql = "UPDATE arma SET id = ?, modelo = ?, nomeNaObra = ?, peso = ?, comprimento = ?, "
				+ "alcance = ?, equipamentos = ?, capacidade = ?, personagem = ?, calibre = ?, fabricante = ?";
		
		try {
			PreparedStatement statem = conex.prepareStatement(sql);
			statem.setInt(1, a.getId());
			statem.setString(2, a.getModelo());
			statem.setString(3, a.getNomeNaObra());
			statem.setDouble(4, a.getPeso());
			statem.setDouble(5, a.getComprimentoCm());
			statem.setInt(6, a.getAlcance());
			statem.setString(7, a.getEquipamentos());
			statem.setInt(8, a.getCapacidade());
			statem.setInt(9, a.getPersongem());
			statem.setInt(10, a.getCalibre());
			statem.setInt(11, a.getFabricante());
			statem.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Arma excluirArma(Arma a) {
		String sql = "DELETE FROM arma WHERE id = ?";
		
		try {
			PreparedStatement statem = conex.prepareStatement(sql);
			statem.setInt(1, a.getId());
			statem.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
		
	}
	
	public List<Arma> consultarArma(String modelo) {
		listaArmas = new ArrayList<Arma>();
		String sql = "SELECT * FROM arma WHERE modelo LIKE ?";
		
		try {
			PreparedStatement statem = conex.prepareStatement(sql);
			statem.setString(1, "%" + modelo + "%");
			ResultSet rs = statem.executeQuery();
			
			while(rs.next()) {
				Arma a = new Arma();
				
				a.setId(rs.getInt("id"));
				a.setModelo(rs.getString("modelo"));
				a.setNomeNaObra(rs.getString("nomeNaObra"));
				a.setPeso(rs.getDouble("peso"));
				a.setComprimentoCm(rs.getDouble("comprimento"));
				a.setAlcance(rs.getInt("alcance"));
				a.setEquipamentos(rs.getString("equipamentos"));
				a.setCapacidade(rs.getInt("capacidade"));
				a.setPersongem(rs.getInt("personagem"));
				a.setCalibre(rs.getInt("calibre"));
				a.setFabricante(rs.getInt("fabricante"));
				listaArmas.add(a);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return listaArmas;
	}
	
	public int contarArmas() {
		int contagem = 0;
		
		
		
		return contagem;
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
			case 3: return Double.class;
			case 4: return Double.class;
			case 5: return Integer.class;
			case 6: return String.class;
			case 7: return Integer.class;
			case 8: return Integer.class;
			case 9: return Integer.class;
			case 10: return Integer.class;			
			
		}
	
		return String.class;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 11;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		
			case 0: return "Id";
			case 1: return "Modelo";
			case 2: return "Nome na Obra";
			case 3: return "Peso";
			case 4: return "Comprimento (cm)";
			case 5: return "Alcance";
			case 6: return "Equipamentos";
			case 7: return "Capacidade";
			case 8: return "Personagem";
			case 9: return "Calibre";
			case 10: return "Fabricante";
			
		}
		
		return "";
	
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaArmas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Arma a = listaArmas.get(rowIndex);
		
		
		switch (columnIndex) {
		
			case 0: return a.getId();
			case 1: return a.getModelo();
			case 2: return a.getNomeNaObra();
			case 3: return a.getPeso();
			case 4: return a.getComprimentoCm();
			case 5: return a.getAlcance();
			case 6: return a.getEquipamentos();
			case 7: return a.getCapacidade();
			case 8: return a.getPersongem();
			case 9: return a.getCalibre();
			case 10: return a.getFabricante();
		
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
	
	public Arma retornarLinha(int linha) {
		return listaArmas.get(linha);
	}
	
}
