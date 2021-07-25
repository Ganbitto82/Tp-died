package died.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import died.Clases.Estacion;
import died.Clases.EstadoEstacion;
import died.Clases.Linea;
import died.Clases.Mantenimiento;
import died.Clases.Trayecto;

public class EstacionDao implements IEstacionDao{
	
	private Connection con;
	private static final String insert = " INSERT INTO estacion (nombre,inicio,cierre,estado)" + "VALUES (?,?,?,?)";
	private static final String delete = "DELETE FROM estacion WHERE id_estacion = ?";
	private static final String update = "UPDATE estacion SET nombre = ?, inicio = ?, cierre = ?, estado = ? where id_estacion = ?";
	private static final String selectAll = "SELECT * FROM estacion";
	private static final String search = "SELECT * FROM estacion WHERE ";
	private static final String updateTrayecto = "UPDATE estacion SET id_trayecto= ? where id_estacion = ?";
	private static final String updateBoleto = "UPDATE estacion SET id_boleto= ? where id_estacion = ?";
		
	@Override
	public void altaEstacion(Estacion e)  {
		
		
		PreparedStatement pr = null;
		
		try {
			   con = Conexion.getConexion();	
			    pr = con.prepareStatement(insert);
		        pr.setString(1, e.getNombre());
				pr.setString(2, e.getInicio().toString());
				pr.setString(3, e.getCierre().toString());
				pr.setString(4,e.getEstado().toString());
				pr.executeUpdate();		
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				con.close();
			} catch(Exception x) {
				x.printStackTrace();
			}
		}
		
		}

	@Override
	public void bajaEstacion(Integer id) {
		Connection con = null;
		con = Conexion.conectar();
		PreparedStatement pr = null;
		try {
			pr = con.prepareStatement(delete);
			pr.setInt(1, id);
			pr.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void editarEstacion(Estacion e)  {
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
		
				
			} catch (SQLException ex) {
				
				ex.printStackTrace();
			}
			
		
	}
	@Override
	public List<Estacion> buscarTodos(String s) {
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
				e.setInicio((rs.getTime("inicio")));
				e.setInicio((rs.getTime("cierre")));
				String t = rs.getString("estado");
				EstadoEstacion Enum = EstadoEstacion.valueOf(t);
				e.setEstado(Enum);
				lista.add(e);
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
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
	public void editar_id_boleto(Estacion e) {
		con = Conexion.conectar();
		PreparedStatement pr = null;
		
		try {
			
			if(e.getId() != null && e.getId() > 0 ) {
			pr = con.prepareStatement(updateBoleto);
			pr.setInt(1, e.getId());
			pr.executeUpdate();	}
				
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		
	}

	@Override
	public List<Trayecto> buscarTrayectos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mantenimiento> buscarMantenimientos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Linea> buscarLineas() {
		// TODO Auto-generated method stub
		return null;
	}
		
	}


