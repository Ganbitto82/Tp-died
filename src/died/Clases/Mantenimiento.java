package died.Clases;

import java.time.LocalDate;

public class Mantenimiento {
    private Integer id;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String observaciones;
	
			
	
	
	
	public Mantenimiento(Integer id, LocalDate fechaInicio, LocalDate fechaFin, String observaciones,
			Estacion estacion) {
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.observaciones = observaciones;
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	
}
