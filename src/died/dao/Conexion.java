package died.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	static Connection con = null;
	public static Connection conectar() {
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/db_estacion", "root", "1234");
			
			
		}
		catch(ClassNotFoundException e) 
		{
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
		catch(SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}
		return con;
	
		
		
	}

	public static Connection getConexion() throws SQLException {
		
		return conectar();
	}
	
	
}