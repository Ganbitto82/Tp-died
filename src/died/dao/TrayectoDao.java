package died.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import died.Clases.Estacion;
import died.Clases.EstadoEstacion;
import died.Clases.EstadoRuta;
import died.Clases.Trayecto;

public class TrayectoDao implements ITrayectoDao{
	private Connection con;
	private static final String insert = " INSERT INTO trayecto (distancia, cantidad_Max, origen ,destino ,estado ,costo) VALUES (?,?,?,?,?,?)  ";
	private static final String serchEstacion= "SELECT e.* from estacion_trayecto et, estacion e WHERE et.id_trayecto= ? and et.id_estacion= ? " ;
	private static final String searchLinea= "SELECT * FROM trayecto WHERE id_linea=? ";
	@Override
	public void altaTrayecto(Trayecto t) throws Exception {
          PreparedStatement pr = null;
		
		try {
			   con = Conexion.getConexion();	
			    pr = con.prepareStatement(insert);
		        pr.setInt(1, t.getDistancia()); 
				pr.setInt(2, t.getCantMaxPasajeros());
				pr.setInt(3, t.getOrigen().getId());
				pr.setInt(4, t.getDestino().getId());
				pr.setString(5, t.getEstado().toString() );
				pr.setDouble(6, t.getCosto());
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
	public List<Estacion> buscarEstaciones(Integer id_trayecto, Integer id_estacion) throws Exception {
		List <Estacion> estaciones=new ArrayList<Estacion> ();
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		try {
			con = Conexion.getConexion();
			pr = con.prepareStatement(serchEstacion);
			pr.setInt(1, id_trayecto);
			pr.setInt(2, id_estacion);
			rs = pr.executeQuery();
			while(rs.next()) {
				Estacion estacion =new Estacion();
				estacion.setId(rs.getInt("id_estacion"));
				estacion.setNombre(rs.getString("nombre"));
				estacion.setInicio(rs.getTime("inicio"));
				estacion.setCierre(rs.getTime("cierre"));
				String t = rs.getString("estado");
				EstadoEstacion Enum = EstadoEstacion.valueOf(t);
				estacion.setEstado(Enum);
				estaciones.add(estacion);
				
			}			
		}
		catch(Exception ex) { 
			
			 throw new Exception("Error al buscar Competencia en la Base de datos.");
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pr!=null) pr.close();
				if(con!=null) con.close();				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return estaciones;
	}

	@Override
	public List<Trayecto> buscarLineas(Integer id_linea) throws Exception {
		Connection con = null;
		PreparedStatement pr = null;
		ResultSet rs = null;
		List<Trayecto> resultado = new ArrayList<Trayecto>();
		
		try {
			con = Conexion.getConexion();
			pr = con.prepareStatement(searchLinea);
			pr.setInt(1,  id_linea);
			rs = pr.executeQuery();
			while(rs.next()) {
				
					Trayecto t= new Trayecto();
					
					t.setId(rs.getInt("id_trayecto"));
					t.setDistancia(rs.getInt("distancia"));
					t.setCantMaxPasajeros(rs.getInt("cantidad_Max"));
					Estacion origen=new Estacion();
					Estacion destino=new Estacion();
					origen.setNombre(rs.getString("origen"));
					destino.setNombre(rs.getString("destino"));
					t.setOrigen(origen);
					t.setDestino(destino);
					String e = rs.getString("estado");
					EstadoRuta Enum = EstadoRuta.valueOf(e);
					t.setEstado(Enum);
					t.setCosto(rs.getFloat("costo"));
					resultado.add(t);
				
				
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
}


