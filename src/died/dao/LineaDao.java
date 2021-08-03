package died.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import died.Clases.EstadoRuta;
import died.Clases.Linea;

public class LineaDao implements ILineaDao {

	
	private Connection con;
	private static final String insert = " INSERT INTO Linea (nombre,color,estado) VALUES (?,?,?)";
	private static final String delete = "DELETE FROM Linea WHERE id_linea = ?";
	private static final String update = "UPDATE linea SET nombre = ?, color = ?, estado = ? where id_linea = ?";
	private static final String selectAll = "SELECT * FROM linea";
	private static final String search = "SELECT * FROM linea WHERE ";
	
	@Override
	public void altaLinea(Linea l) throws Exception {
		PreparedStatement pr = null;
		
		try {
			   con = Conexion.getConexion();	
			    pr = con.prepareStatement(insert);
		        pr.setString(1, l.getNombre());
				pr.setString(2, l.getColor());
				pr.setString(3, l.getEstado().toString());
				
				pr.executeUpdate();		
			
		} catch(Exception ex) { 
			
			 throw new Exception("Error al guardar una linea en la Base de datos.");
		}finally {
			try {
				con.close();
			} catch(Exception x) {
				x.printStackTrace();
			}
		}
	}

	@Override
	public void bajaLinea(Integer id) throws Exception {
		Connection con = null;
		con = Conexion.conectar();
		PreparedStatement pr = null;
		try {
			pr = con.prepareStatement(delete);
			pr.setInt(1, id);
			pr.executeUpdate();
		} catch(Exception ex) { 
			
			 throw new Exception("Error al dar de baja una linea en la Base de datos.");
		}
	}

	@Override
	public void editarLinea(Linea l) throws Exception {
		con = Conexion.conectar();
		PreparedStatement pr = null;
		
			try {
				
				if(l.getId() != null && l.getId() > 0 ) {
				pr = con.prepareStatement(update);
				pr.setString(1, l.getNombre());
				pr.setString(2, l.getColor());
				pr.setString(3,l.getEstado().toString());
				
				pr.executeUpdate();	}
		
				
			} catch(Exception ex) { 
				
				 throw new Exception("Error al editar una linea en la Base de datos.");
			}
			
	}

	@Override
	public List<Linea> buscarTodos(String s) throws Exception {
		List<Linea> lineas = new ArrayList<Linea>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = Conexion.getConexion();
			if(!s.isEmpty()) {
				pstmt= conn.prepareStatement(search+s);
				rs = pstmt.executeQuery();
			}
			else {
				pstmt= conn.prepareStatement(selectAll);
				rs = pstmt.executeQuery();
			}
			while(rs.next()) {
				Linea l = new Linea();
				l.setId(rs.getInt("id_linea"));
				l.setNombre(rs.getString("origen"));
				l.setColor(rs.getString("destino"));
				String t = rs.getString("estado");
				EstadoRuta Enum = EstadoRuta.valueOf(t);
				l.setEstado(Enum);
				lineas.add(l);
			}
						
		} catch(Exception ex) { 
			
			 throw new Exception("Error al buscar en la Base de datos.");
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}	
		return lineas;
	}



}
