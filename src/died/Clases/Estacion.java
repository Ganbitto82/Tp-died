package died.Clases;


import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Estacion {

	private Integer id;
	private String nombre;
	private Time inicio;
	private Time cierre;
	private EstadoEstacion estadoEstacion;
	private List<Mantenimiento> mantenimientos;
	private List<Trayecto> trayectos;
	private Boleto boleto;

	public Estacion () {
		this.mantenimientos=new ArrayList<Mantenimiento>();
		this.trayectos=new ArrayList<Trayecto>();
	}
	
	public Estacion( String nombre, Time  inicio, Time  cierre, EstadoEstacion estadoEstacion) {
		super();
		
		this.nombre = nombre;
		this.inicio = inicio;
		this.cierre = cierre;
		this.estadoEstacion = estadoEstacion;
		this.mantenimientos=new ArrayList<Mantenimiento>();
		this.trayectos=new ArrayList<Trayecto>();
		
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
	
	
	public Time getInicio() {
		return inicio;
	}

	public void setInicio(Time inicio) {
		this.inicio = inicio;
	}

	public Time getCierre() {
		return cierre;
	}

	public void setCierre(Time cierre) {
		this.cierre = cierre;
	}

	public List<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}

	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

	public List<Trayecto> getTrayectos() {
		return trayectos;
	}

	public void setTrayectos(List<Trayecto> trayectos) {
		this.trayectos = trayectos;
	}

	public Boleto getBoleto() {
		return boleto;
	}

	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}
	
}
		

