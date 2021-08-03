package died.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import died.Clases.Boleto;

public class BoletoDao implements IBoleto{

	private Connection con;
	private static final String insert = " INSERT INTO boleto (nro_boleto,email,nombre_cliente,origen,destino,camino,costo) VALUES (?,?,?,?,?,?,?)";
	@Override
	public void altaBoleto(Boleto b) throws Exception {
       
		PreparedStatement pr = null;
		
		try {
			   con = Conexion.getConexion();	
			    pr = con.prepareStatement(insert);
		        pr.setInt(1, b.getNroBoleto());
				pr.setString(2,b.getEmail());
				pr.setString(3,b.getNombreCliente() );
				pr.setString(4,b.getEstacionOrigen().getNombre());
				pr.setString(5,b.getEstacionDestino().getNombre());
				pr.setString(6,b.getCamino().toString());
				pr.setDouble(7, b.getCosto());
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

}
