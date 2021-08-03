package died.Grafos;



public class Arista<T> {
	
	//Atributos
	private Vertice<T> inicio;
	private Vertice<T> fin;
	private Integer distancia;
	private Integer cantidadMaxima;
	private String estado;
	private float costo;
	
	
	
	//Constructores
	public Arista(){
		
	} 
	
	public Arista(Vertice<T> ini, Vertice<T> fin,  Integer d,Integer c, String es, float co){
		this.inicio = ini;
		this.fin = fin;
		distancia = d;
		cantidadMaxima = c;
		estado=es;
		costo = co;
	}
	
	
	//Getters y Setters
	public Vertice<T> getInicio() {
		return inicio;
	}
	
	public void setInicio(Vertice<T> inicio) {
		this.inicio = inicio;
	}
	
	public Vertice<T> getFin() {
		return fin;
	}
	
	public void setFin(Vertice<T> fin) {
		this.fin = fin;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

		
	public Integer getCantidadMaxima() {
		return cantidadMaxima;
	}

	public void setCantidadMaxima(Integer cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	//Métodos
	@Override
	public String toString() {
		return "( "+this.inicio.getValor()+" --> "+this.fin.getValor()+" )";
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Arista<?>) && 
			   ((Arista<?>)obj).getDistancia().equals(this.getDistancia()) &&
			   ((Arista<?>)obj).getCantidadMaxima() .equals(this.getCantidadMaxima()) &&
			   ((Arista<?>)obj).getDistancia() .equals(this.getDistancia()) &&
			   ((Arista<?>)obj).getEstado() .equals(this.getEstado()) &&
			   ((Arista<?>)obj).getCosto()==(this.getCosto());
	}
}
	