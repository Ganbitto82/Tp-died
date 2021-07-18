package died.Clases;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Estacion {

	private Integer id;
	private String nombre;
	private Instant inicio;
	private Instant cierre;
	private EstadoEstacion estadoEstacion;
	private List<Mantenimiento> mantenimientos;

	
	
	public Estacion( String nombre, Instant inicio, Instant cierre, EstadoEstacion estadoEstacion) {
		super();
		
		this.nombre = nombre;
		this.inicio = inicio;
		this.cierre = cierre;
		this.estadoEstacion = estadoEstacion;
		this.mantenimientos=new ArrayList<Mantenimiento>();
		
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoEstacion getEstadoEstacion() {
		return estadoEstacion;
	}

	public void setEstadoEstacion(EstadoEstacion estadoEstacion) {
		this.estadoEstacion = estadoEstacion;
	}

	public EstadoEstacion getEstado() {
		return estadoEstacion;
	}
	public void setEstado(EstadoEstacion estadoEstacion) {
		this.estadoEstacion = estadoEstacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Instant getInicio() {
		return inicio;
	}
	public void setInicio(Instant inicio) {
		this.inicio = inicio;
	}
	public Instant getCierre() {
		return cierre;
	}
	public void setCierre(Instant cierre) {
		this.cierre = cierre;
	}

	public List<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}

	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}


	
	
}
