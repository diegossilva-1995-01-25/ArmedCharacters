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
import obrachildren.ObraEscrita;
import obrachildren.obravisualchildren.Serie;

public class CtrObraEscrita implements ListPersonagensObra, TableModel {
	
	private ObraEscrita obraEscrita;
	private List<ObraEscrita> listaObrasEscritas;
	private Connection conex;
	private String pass;
	
	public CtrObraEscrita(String senha) {
		pass = senha;
		listaObrasEscritas = new ArrayList<>();
		conex = DAOConexaoSingleton.getInstanciaUnica(pass).getConexao();
		obraEscrita = new ObraEscrita();
	}
	
	public void adicionarObraEscrita(ObraEscrita oE) {
		String sql = "INSERT INTO obraEscrita (id, titulo, ano, genero, tituloTraduzido, "
				+ "autor, tipoObraEscrita, editora) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement statem = conex.prepareStatement(sql);
			statem.setInt(1, oE.getId());
			statem.setString(2, oE.getTitulo());
			statem.setInt(3, oE.getAno());
			statem.setString(4, oE.getGenero());
			statem.setString(5, oE.getTituloTraduzido());
			statem.setString(6, oE.getAutor());
			statem.setString(7, oE.getTipoObraEscrita());
			statem.setString(8, oE.getEditora());
			statem.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void alterarObraEscrita(ObraEscrita oE) {
		String sql = "UPDATE obraEscrita SET id = ?, titulo = ?, ano = ?, genero = ?, "
				+ "tituloTraduzido = ?, autor = ?, tipoObraEscrita = ?, editora = ?";
		
		try {
			PreparedStatement statem = conex.prepareStatement(sql);
			statem.setInt(1, oE.getId());
			statem.setString(2, oE.getTitulo());
			statem.setInt(3, oE.getAno());
			statem.setString(4, oE.getGenero());
			statem.setString(5, oE.getTituloTraduzido());
			statem.setString(6, oE.getAutor());
			statem.setString(7, oE.getTipoObraEscrita());
			statem.setString(8, oE.getEditora());
			statem.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ObraEscrita excluirObraEscrita(ObraEscrita oE) {
		String sql = "DELETE FROM obraEscrita WHERE id = ?";

		try {
			PreparedStatement statem = conex.prepareStatement(sql);
			statem.setInt(1, oE.getId());
			statem.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return oE;
	}
	
	public List<ObraEscrita> consultarObraEscrita(String titulo) {
		listaObrasEscritas = new ArrayList<ObraEscrita>();
		String sql = "SELECT * FROM obraEscrita WHERE titulo LIKE ?";
		
		try {
			PreparedStatement statem = conex.prepareStatement(sql);
			statem.setString(1, "%" + titulo + "%");
			ResultSet rs = statem.executeQuery();
			
			while(rs.next()) {
				ObraEscrita oE = new ObraEscrita();
				
				oE.setId(rs.getInt("id"));
				oE.setTitulo(rs.getString("titulo"));
				oE.setAno(rs.getInt("ano"));
				oE.setGenero(rs.getString("genero"));
				oE.setTituloTraduzido(rs.getString("tituloTraduzido"));
				oE.setAutor(rs.getString("autor"));
				oE.setTipoObraEscrita(rs.getString("tipoObraEscrita"));
				oE.setEditora(rs.getString("editora"));
				listaObrasEscritas.add(oE);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaObrasEscritas;
	}
	
	public int contarObrasEscritas() {
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
			case 4: return "T�tulo Traduzido";
			case 5: return "Autor";
			case 6: return "Tipo de Obra Escrita";
			case 7: return "Editora";
		
		}
		
		return "";
		
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaObrasEscritas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		ObraEscrita oE = listaObrasEscritas.get(rowIndex);
		
		
		switch (columnIndex) {
		
			case 0: return oE.getId();
			case 1: return oE.getTitulo();
			case 2: return oE.getAno();
			case 3: return oE.getGenero();
			case 4: return oE.getTituloTraduzido();
			case 5: return oE.getAutor();
			case 6: return oE.getTipoObraEscrita();
			case 7: return oE.getEditora();
			
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
	
	public ObraEscrita retornarLinha(int linha) {
		return listaObrasEscritas.get(linha);
	}
	
}
