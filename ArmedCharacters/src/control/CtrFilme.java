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
import model.Arma;
import model.Calibre;
import model.Fabricante;
import model.Personagem;
import obrachildren.obravisualchildren.Filme;

public class CtrFilme implements ListPersonagensObra, TableModel {

	private Filme filme;
	private List<Filme> listaFilmes;
	private Connection conex;
	private String pass;
	
	public CtrFilme(String senha) {
		pass = senha;
		listaFilmes = new ArrayList<>();
		conex = DAOConexaoSingleton.getInstanciaUnica(pass).getConexao();
		filme = new Filme();
	}
	
	public void adicionarFilme(Filme f) {
		String sql = "INSERT INTO filme (id, titulo, ano, genero, distribuidora, "
				+ "franquia, tituloDublado, diretor) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement statem = conex.prepareStatement(sql);
			statem.setInt(1, f.getId());
			statem.setString(2, f.getTitulo());
			statem.setInt(3, f.getAno());
			statem.setString(4, f.getGenero());
			statem.setString(5, f.getDistribuidora());
			statem.setString(6, f.getFranquia());
			statem.setString(7, f.getTituloDublado());
			statem.setString(8, f.getDiretor());
			statem.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alterarFilme(Filme f) {
		String sql = "UPDATE filme SET id = ?, titulo = ?, ano = ?, genero = ?, "
				+ "distribuidora = ?, franquia = ?, tituloDublado = ?, diretor = ?";
		
		try {
			PreparedStatement statem = conex.prepareStatement(sql);
			statem.setInt(1, f.getId());
			statem.setString(2, f.getTitulo());
			statem.setInt(3, f.getAno());
			statem.setString(4, f.getGenero());
			statem.setString(5, f.getDistribuidora());
			statem.setString(6, f.getFranquia());
			statem.setString(7, f.getTituloDublado());
			statem.setString(8, f.getDiretor());
			statem.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Filme excluirFilme(Filme f) {
		String sql = "DELETE FROM filme WHERE id = ?";

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
	
	public List<Filme> consultarFilme(String titulo) {
		listaFilmes = new ArrayList<Filme>();
		String sql = "SELECT * FROM filme WHERE titulo LIKE ?";
		
		try {
			PreparedStatement statem = conex.prepareStatement(sql);
			statem.setString(1, "%" + titulo + "%");
			ResultSet rs = statem.executeQuery();
			
			while(rs.next()) {
				Filme f = new Filme();
				
				f.setId(rs.getInt("id"));
				f.setTitulo(rs.getString("titulo"));
				f.setAno(rs.getInt("ano"));
				f.setGenero(rs.getString("genero"));
				f.setDistribuidora(rs.getString("distribuidora"));
				f.setFranquia(rs.getString("franquia"));
				f.setTituloDublado(rs.getString("tituloDublado"));
				f.setDiretor(rs.getString("diretor"));
				listaFilmes.add(f);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaFilmes;
	}
	
	public int contarFilmes() {
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
						
		}
	
		return String.class;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 8;
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
			case 6: return "T�tulo Dublado";
			case 7: return "Diretor";
		
		}
	
		return "";
		
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaFilmes.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Filme f = listaFilmes.get(rowIndex);
		
		
		switch (columnIndex) {
		
			case 0: return f.getId();
			case 1: return f.getTitulo();
			case 2: return f.getAno();
			case 3: return f.getGenero();
			case 4: return f.getDistribuidora();
			case 5: return f.getFranquia();
			case 6: return f.getTituloDublado();
			case 7: return f.getDiretor();
			
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
	
	public Filme retornarLinha(int linha) {
		return listaFilmes.get(linha);
	}
	
}
