package died.Clases;

public class Linea {
	private String nombre;
	private String color;
	private EstadoRuta estado;
	
	
	public Linea(String nombre, String color, EstadoRuta estado) {
		super();
		this.nombre = nombre;
		this.color = color;
		this.estado = estado;
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
