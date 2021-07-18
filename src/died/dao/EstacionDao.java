package died.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import died.Clases.Estacion;



public class EstacionDao implements IEstacionDao{
	
	private Connection con;
	
	public void altaEstacion(Estacion e) {
		con = null;
		PreparedStatement pr = null;
		try {
				pr = con.prepareStatement( " INSERT INTO estacion (nombre)");
				pr.setString(1, e.getNombre());
							
			pr.executeUpdate();
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
			con.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}

}
