package died.Grafos;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import died.Clases.Estacion;
import died.Clases.EstadoEstacion;
import died.Clases.EstadoRuta;
import died.Clases.Trayecto;

public class prueba {

	public static void main(String[] args) {
		
		Time t = Time.valueOf(LocalTime.now());
		GrafoRutas gr=new GrafoRutas();
		Estacion e=new Estacion("Glew",t ,t, EstadoEstacion.OPERATIVA);
		Estacion e1=new Estacion("Longchamps",t ,t, EstadoEstacion.OPERATIVA);
		List<Estacion> estaciones= new ArrayList<Estacion>();
		estaciones.add(e);
		estaciones.add(e1);
		Trayecto trayecto =new Trayecto();
		trayecto.setEstaciones(estaciones);
		trayecto.setDistancia(36);
		trayecto.setCantMaxPasajeros(100);
		trayecto.setEstado(EstadoRuta.ACTIVA);
		trayecto.setCosto(50.0f);
		List<Trayecto> trayectos= new ArrayList<Trayecto>();
		trayectos.add(trayecto);
		gr.armarGrafo(trayectos);
		gr.imprimirAristas();
	}

}
