package died.Aplicacion;

import java.sql.SQLException;

import died.dao.Conexion;



public class App {
	
	public static void main(String[] args) throws SQLException {
		Conexion.conectar();
	}


}
