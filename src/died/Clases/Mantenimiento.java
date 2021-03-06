package died.Clases;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Mantenimiento {
    private Integer id;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String observaciones;
	
	public Mantenimiento () {}
	
	
	
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

	
public  LocalDate convertirFecha(Date date) {
		
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Instant instant = date.toInstant();
		LocalDate localDate = instant
		        .atZone(defaultZoneId).toLocalDate();
	return localDate;
	}




	
}
