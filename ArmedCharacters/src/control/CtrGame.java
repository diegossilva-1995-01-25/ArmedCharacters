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
import list.ListPersonagensObra;
import model.Fabricante;
import model.Personagem;
import obrachildren.obravisualchildren.Filme;
import obrachildren.obravisualchildren.Game;

public class CtrGame implements ListPersonagensObra, TableModel {

	private Game game;
	private List<Game> listaGames;
	private Connection conex;
	private String pass;
	
	public CtrGame(String senha) {
		pass = senha;
		listaGames = new ArrayList<>();
		conex = DAOConexaoSingleton.getInstanciaUnica(pass).getConexao();
		game = new Game();
	}
	
	public void adicionarGame(Game g) {
		String sql = "INSERT INTO game (id, titulo, ano, genero, distribuidora, "
				+ "franquia, plataformas, criador, desenvolvedoras) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement statem = conex.prepareStatement(sql);
			statem.setInt(1, g.getId());
			statem.setString(2, g.getTitulo());
			statem.setInt(3, g.getAno());
			statem.setString(4, g.getGenero());
			statem.setString(5, g.getDistribuidora());
			statem.setString(6, g.getFranquia());
			statem.setString(7, g.getPlataformas());
			statem.setString(8, g.getCriador());
			statem.setString(9, g.getDesenvolvedoras());
			statem.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alterarGame(Game g) {
		String sql = "UPDATE game SET id = ?, titulo = ?, ano = ?, genero = ?, "
				+ "distribuidora = ?, franquia = ?, plataformas = ?, criador = ? "
				+ "desenvolvedoras = ?";
		
		try {
			PreparedStatement statem = conex.prepareStatement(sql);
			statem.setInt(1, g.getId());
			statem.setString(2, g.getTitulo());
			statem.setInt(3, g.getAno());
			statem.setString(4, g.getGenero());
			statem.setString(5, g.getDistribuidora());
			statem.setString(6, g.getFranquia());
			statem.setString(7, g.getPlataformas());
			statem.setString(8, g.getCriador());
			statem.setString(9, g.getDesenvolvedoras());
			statem.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Game excluirGame(Game g) {
		String sql = "DELETE FROM game WHERE id = ?";

		try {
			PreparedStatement statem = conex.prepareStatement(sql);
			statem.setInt(1, g.getId());
			statem.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return g;
	}
	
	public List<Game> consultarGame(String titulo) {
		listaGames = new ArrayList<Game>();
		String sql = "SELECT * FROM game WHERE titulo LIKE ?";
		
		try {
			PreparedStatement statem = conex.prepareStatement(sql);
			statem.setString(1, "%" + titulo + "%");
			ResultSet rs = statem.executeQuery();
			
			while(rs.next()) {
				Game g = new Game();
				
				g.setId(rs.getInt("id"));
				g.setTitulo(rs.getString("titulo"));
				g.setAno(rs.getInt("ano"));
				g.setGenero(rs.getString("genero"));
				g.setDistribuidora(rs.getString("distribuidora"));
				g.setFranquia(rs.getString("franquia"));
				g.setPlataformas(rs.getString("plataformas"));
				g.setCriador(rs.getString("criador"));
				g.setDesenvolvedoras(rs.getString("desenvolvedoras"));
				listaGames.add(g);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaGames;
	}
	
	public int contarGames() {
		int contagem = 0;
		
		
		
		return contagem;
	}

	@Override
	public List<Personagem> instanciarLista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void adicionarArma(Personagem p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarArmas(String tituloObra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Personagem removerArma(Personagem p) {
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
			case 2: return Integer.class;
			case 3: return String.class;
			case 4: return String.class;
			case 5: return String.class;
			case 6: return String.class;
			case 7: return String.class;
			case 8: return String.class;
			
		}
	
		return String.class;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 9;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		switch (columnIndex) {
		
			case 0: return "Id";
			case 1: return "T�tulo";
			case 2: return "Ano";
			case 3: return "G�nero";
			case 4: return "Distribuidora";
			case 5: return "Franquia";
			case 6: return "Plataformas";
			case 7: return "Criador";
			case 8: return "Desenvolvedoras";
		
		}
		
		return "";
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaGames.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Game g = listaGames.get(rowIndex);
		
		
		switch (columnIndex) {
		
			case 0: return g.getId();
			case 1: return g.getTitulo();
			case 2: return g.getAno();
			case 3: return g.getGenero();
			case 4: return g.getDistribuidora();
			case 5: return g.getFranquia();
			case 6: return g.getPlataformas();
			case 7: return g.getCriador();
			case 8: return g.getDesenvolvedoras();
			
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
	
	public Game retornarLinha(int linha) {
		return listaGames.get(linha);
	}
	
}
