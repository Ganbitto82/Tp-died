package died.Clases;

public class Trayecto {

	private Estacion origen;
	private Estacion destino;
	private Integer distancia;
	private Integer cantMaxPasajeros;
	private EstadoRuta estado;
	private Float costo;
	
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
