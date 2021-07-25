package died.Aplicacion;



import java.sql.Time;
import java.time.LocalTime;


import died.Clases.Estacion;
import died.Clases.EstadoEstacion;
import died.Controlador.EstacionContralador;

public class prueba {

	
	

	public static void main(String[] args) {
	  
		Time t = Time.valueOf(LocalTime.now());
		Estacion e=new Estacion("Burzaco",t ,t, EstadoEstacion.OPERATIVA);
		Estacion e1=new Estacion("Constitucion",t ,t, EstadoEstacion.OPERATIVA);
		EstacionContralador ec=new EstacionContralador();

	    ec.guardar(e);
		
		
		
	}
	
	

}
