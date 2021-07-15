package died.Clases;

import java.time.Instant;

public class Estacion {

	private Integer id;
	private String nombre;
	private Instant inicio;
	private Instant cierre;
	private EstadoEstacion estadoEstacion;
	
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
	
}
