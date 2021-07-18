package died.Clases;

import java.util.ArrayList;
import java.util.List;

public class Trayecto {
    private Integer id;
	private Estacion origen;
	private Estacion destino;
	private Integer distancia;
	private Integer cantMaxPasajeros;
	private EstadoRuta estado;
	private Float costo;
	private List<Estacion> estaciones;
	
	
	public Trayecto(Estacion origen, Estacion destino, Integer distancia, Integer cantMaxPasajeros,
			EstadoRuta estado, Float costo) {
		super();
		
		this.origen = origen;
		this.destino = destino;
		this.distancia = distancia;
		this.cantMaxPasajeros = cantMaxPasajeros;
		this.estado = estado;
		this.costo = costo;
		this.estaciones=new ArrayList<Estacion>();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
	
	public List<Estacion> getEstaciones() {
		return estaciones;
	}

	public void setEstaciones(List<Estacion> estaciones) {
		this.estaciones = estaciones;
	}

	public Estacion getOrigen() {
		return origen;
	}
	public void setOrigen(Estacion origen) {
		this.origen = origen;
	}
	public Estacion getDestino() {
		return destino;
	}
	public void setDestino(Estacion destino) {
		this.destino = destino;
	}
	public Integer getDistancia() {
		return distancia;
	}
	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}
	public Integer getCantMaxPasajeros() {
		return cantMaxPasajeros;
	}
	public void setCantMaxPasajeros(Integer cantMaxPasajeros) {
		this.cantMaxPasajeros = cantMaxPasajeros;
	}
	public EstadoRuta getEstado() {
		return estado;
	}
	public void setEstado(EstadoRuta estado) {
		this.estado = estado;
	}
	public Float getCosto() {
		return costo;
	}
	public void setCosto(Float costo) {
		this.costo = costo;
	}

	
}
