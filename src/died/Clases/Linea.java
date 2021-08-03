package died.Clases;

import java.util.ArrayList;
import java.util.List;

public class Linea {
	private Integer id;
	private String nombre;
	private String color;
	private EstadoRuta estado;
	private List<Trayecto> trayectos;
	
	
		
	public Linea( String nombre, String color, EstadoRuta estado) {
		super();
		
		this.nombre = nombre;
		this.color = color;
		this.estado = estado;
		this.trayectos= new ArrayList<Trayecto>();
	}
	
	

	public List<Trayecto> getTrayectos() {
		return trayectos;
	}



	public void setTrayectos(List<Trayecto> trayectos) {
		this.trayectos = trayectos;
	}



	public Linea() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public EstadoRuta getEstado() {
		return estado;
	}
	public void setEstado(EstadoRuta estado) {
		this.estado = estado;
	}

	
	

}
