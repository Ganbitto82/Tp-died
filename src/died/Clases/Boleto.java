package died.Clases;

import java.time.LocalDate;

public class Boleto {
	
	private Integer id;
	private Integer nroBoleto;
	private String email;
	private String nombreCliente;
	private LocalDate fechaVenta;
	private Estacion estacionOrigen;
	private Estacion estacionDestino;
	private Camino camino;
	private float costo;
	
	public Boleto() {}
	
	

	   public Boleto(Integer nroBoleto, String email, String nombreCliente, LocalDate fechaVenta,
			Estacion estacionOrigen, Estacion estacionDestino, Camino camino, float costo) {
		super();
		
		this.nroBoleto = nroBoleto;
		this.email = email;
		this.nombreCliente = nombreCliente;
		this.fechaVenta = fechaVenta;
		this.estacionOrigen = estacionOrigen;
		this.estacionDestino = estacionDestino;
		this.camino = camino;
		this.costo = costo;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNroBoleto() {
		return nroBoleto;
	}
	public void setNroBoleto(Integer nroBoleto) {
		this.nroBoleto = nroBoleto;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Estacion getEstacionOrigen() {
		return estacionOrigen;
	}

	public void setEstacionOrigen(Estacion estacionOrigen) {
		this.estacionOrigen = estacionOrigen;
	}

	public Estacion getEstacionDestino() {
		return estacionDestino;
	}

	public void setEstacionDestino(Estacion estacionDestino) {
		this.estacionDestino = estacionDestino;
	}

	public Camino getCamino() {
		return camino;
	}
	public void setCamino(Camino camino) {
		this.camino = camino;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	

}
