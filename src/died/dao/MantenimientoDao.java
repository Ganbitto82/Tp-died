package died.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import died.Clases.Mantenimiento;


public class MantenimientoDao implements IMantenientoDao{
	private Connection con;
	private static final String insert = " INSERT INTO mantenimiento (fecha_inicio,fecha_fin,observaciones)" + "VALUES (?,?,?)";
	private static final String delete = "DELETE FROM  mantenimiento WHERE id_mantenimiento = ?";
	private static final String update = "UPDATE mantenimiento SET fecha_incio = ?, fecha_fin = ?, observaciones = ?, id_estacion= ? where id_mantenimiento = ?";
	private static final String selectAll = "SELECT * FROM mantenimiento";

	
	
		
	@Override
	public void altaManteniento(Mantenimiento m) throws Exception {
    PreparedStatement pr = null;
		
		try {
			   con = Conexion.getConexion();	
			    pr = con.prepareStatement(insert);
			    pr.setString(1,m.getFechaInicio().toString() );
				pr.setString(2,m.getFechaFin().toString());
				pr.setString(3,m.getObservaciones());
				pr.executeUpdate();		
			
		} catch(Exception ex) { 
			
			 throw new Exception("Error al buscar Competencia en la Base de datos.");
		}finally {
			try {
				con.close();
			} catch(Exception x) {
				x.printStackTrace();
			}
		}
		
	}

	@Override
	public void bajaManteniento(Integer id) throws Exception {
		Connection con = null;
		con = Conexion.conectar();
		PreparedStatement pr = null;
		try {
			pr = con.prepareStatement(delete);
			pr.setInt(1, id);
			pr.executeUpdate();
		} catch(Exception ex) { 
			
			 throw new Exception("Error al buscar Competencia en la Base de datos.");
		}
		
		
	}

	@Override
	public void editarMantenimiento(Mantenimiento m, Integer id) throws Exception {
		con= Conexion.conectar();
		PreparedStatement pr = null;
		
			try {
				
				if(m.getId() != null && m.getId() > 0 ) {
				pr = con.prepareStatement(update);
				pr.setString(1, m.getFechaInicio().toString());
				pr.setString(2,m.getFechaFin().toString());
				pr.setString(3, m.getObservaciones());
				pr.setInt(4, id);
				pr.executeUpdate();	}
		
				
			} catch(Exception ex) { 
				
				 throw new Exception("Error al buscar Competencia en la Base de datos.");
			}
			
		
	}

	@Override
	public List<Mantenimiento> buscarTodos() throws Exception {
		List<Mantenimiento> lista = new ArrayList<Mantenimiento>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = Conexion.getConexion();
			
				pstmt= conn.prepareStatement(selectAll);
				rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Mantenimiento m = new Mantenimiento();
				m.setId(rs.getInt("id_mantenimiento"));
				m.setFechaInicio(m.convertirFecha(rs.getDate("fecha_inicio")));
				m.setFechaFin(m.convertirFecha(rs.getDate("fecha_fin")));
				m.setObservaciones(rs.getString("observaciones"));
				lista.add(m);
			}
						
		} catch(Exception ex) { 
			
			 throw new Exception("Error al buscar Competencia en la Base de datos.");
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}	
		return lista;	
	}

	
}
