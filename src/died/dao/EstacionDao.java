package died.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import died.Clases.Estacion;
import died.Clases.EstadoEstacion;
import died.Clases.Mantenimiento;
import died.Clases.Trayecto;



public class EstacionDao implements IEstacionDao{
	
	private Connection con;
	private static final String insert = " INSERT INTO estacion (nombre,inicio,cierre,estado)" + "VALUES (?,?,?,?)";
	private static final String delete = "DELETE FROM estacion WHERE id_estacion = ?";
	private static final String update = "UPDATE estacion SET nombre = ?, inicio = ?, cierre = ?, estado = ? where id_estacion = ?";
	private static final String selectAll = "SELECT * FROM estacion";
	private static final String search = "SELECT * FROM estacion WHERE ";
	private static final String searchMantenimiento= "SELECT * FROM mantenimiento WHERE id_estacion=? ";
	private static final String serchTrayecto="select t.* from estacion_trayecto et, trayecto t where et.id_estacion= ? and et.id_trayecto=? ";
	private static final String serchNombre= "SELECT * FROM estacion WHERE nombre=?";
	@Override
	public void altaEstacion(Estacion e) throws Exception  {
		
		
		PreparedStatement pr = null;
		
		try {
			   con = Conexion.getConexion();	
			    pr = con.prepareStatement(insert);
		        pr.setString(1, e.getNombre());
				pr.setString(2, e.getInicio().toString());
				pr.setString(3, e.getCierre().toString());
				pr.setString(4,e.getEstado().toString());
				pr.executeUpdate();		
			
		} catch(Exception ex) { 
			
			 throw new Exception("Error al guardar una estacion en la Base de datos.");
		}finally {
			try {
				con.close();
			} catch(Exception x) {
				x.printStackTrace();
			}
		}
		
		}

	@Override
	public void bajaEstacion(Integer id) throws Exception {
		Connection con = null;
		con = Conexion.conectar();
		PreparedStatement pr = null;
		try {
			pr = con.prepareStatement(delete);
			pr.setInt(1, id);
			pr.executeUpdate();
		} catch(Exception ex) { 
			
			 throw new Exception("Error al dar de baja una estacion en la Base de datos.");
		}
		
	}

	@Override
	public void editarEstacion(Estacion e) throws Exception  {
		con = Conexion.conectar();
		PreparedStatement pr = null;
		
			try {
				
				if(e.getId() != null && e.getId() > 0 ) {
				pr = con.prepareStatement(update);
				pr.setString(1, e.getNombre());
				pr.setTime(2,e.getInicio());
				pr.setTime(3, e.getCierre());
				pr.setString(4,e.getEstado().toString());
				pr.setInt(5, e.getId());
				pr.executeUpdate();	}
		
				
			} catch(Exception ex) { 
				
				 throw new Exception("Error al modificacion una estacion en la Base de datos.");
			}
			
		
	}
	@Override
	public List<Estacion> buscarTodos(String s) throws Exception {
		List<Estacion> lista = new ArrayList<Estacion>();
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
				Estacion e = new Estacion();
				e.setId(rs.getInt("id_estacion"));
				e.setInicio(rs.getTime("inicio"));
				e.setCierre(rs.getTime("cierre"));
				String t = rs.getString("estado");
				EstadoEstacion Enum = EstadoEstacion.valueOf(t);
				e.setEstado(Enum);
				lista.add(e);
			}
						
		} catch(Exception ex) { 
			
			 throw new Exception("Error al buscar todas las estaciones en la Base de datos.");
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

	
	@Override
	public List<Mantenimiento> buscarMantenimientos(Integer id_estacion) throws Exception {
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		List<Mantenimiento> resultado = new ArrayList<Mantenimiento>();
		
		try {
			con = Conexion.getConexion();
			pr = con.prepareStatement(searchMantenimiento);
			pr.setInt(1,  id_estacion);
			rs = pr.executeQuery();
			while(rs.next()) {
				
					Mantenimiento m= new Mantenimiento();
					m.setId(rs.getInt("id_mantenimiento"));
					m.setFechaInicio(m.convertirFecha(rs.getDate("fecha_inicio")));
					m.setFechaInicio(m.convertirFecha(rs.getDate("fecha_fin")));
					m.setObservaciones(rs.getString("observaciones"));
					resultado.add(m);
				
				
			}
		}catch(Exception ex) { 
			
			 throw new Exception("Error al buscar  en la Base de datos.");
		} finally {
			try {
			if(pr!=null)pr.close();
			if(con!=null)con.close();
			if(rs!=null)rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return resultado;
	}
	
	
	@Override
	public List<Trayecto> buscarTrayectos(Integer id_estacion,Integer id_trayecto) throws Exception {
		List <Trayecto> trayectos=new ArrayList<Trayecto> ();
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			con = Conexion.getConexion();
			pr = con.prepareStatement(serchTrayecto);
			pr.setInt(1, id_estacion);
			pr.setInt(2, id_trayecto);
			rs = pr.executeQuery();
			while(rs.next()) {
				Trayecto trayecto =new Trayecto();
				trayecto.setId(rs.getInt("id_trayecto"));
				trayecto.setDistancia(rs.getInt("distancia"));
				trayecto.setCantMaxPasajeros(rs.getInt("cantidad_Max"));
				Estacion estacionOrigen=new Estacion();
				Estacion estacionDestino=new Estacion();
				estacionOrigen.setId(rs.getInt("origen"));
				estacionDestino.setId(rs.getInt("destino"));
				trayecto.setOrigen(estacionOrigen);
				trayecto.setDestino(estacionDestino);
				trayecto.setCosto(rs.getFloat("costo"));
				trayectos.add(trayecto);
				
			}			
		}
		catch(Exception ex) { 
			
			 throw new Exception("Error al buscar en la Base de datos.");
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pr!=null) pr.close();
				if(con!=null) con.close();				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return trayectos;
	}

	@Override
	public Estacion buscarPorNombre(String nombre) throws Exception {
		Estacion estacion= new Estacion();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = Conexion.getConexion();
			pstmt= conn.prepareStatement(serchNombre+nombre);
			rs = pstmt.executeQuery();
			estacion.setId(rs.getInt("id_estacion"));
			estacion.setInicio(rs.getTime("inicio"));
			estacion.setCierre(rs.getTime("cierre"));
			String t = rs.getString("estado");
			EstadoEstacion Enum = EstadoEstacion.valueOf(t);
			estacion.setEstado(Enum);
		}
		catch (Exception ex)
		{
			throw new Exception("Error al buscar en la Base de datos.");
		
	}
		return estacion;
	

	
		
	}


}