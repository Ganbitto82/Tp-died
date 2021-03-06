package died.Grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;




public class Grafo<T> {
	
	//Atributos
	private List<Arista<T>> aristas;
	private List<Vertice<T>> vertices;

	//Constructor
	public Grafo(){
		this.aristas = new ArrayList<Arista<T>>();
		this.vertices = new ArrayList<Vertice<T>>();
	}
	
	//Getters y Setters
	public List<Arista<T>> getAristas() {
		return aristas;
	}

	public void setAristas(List<Arista<T>> aristas) {
		this.aristas = aristas;
	}

	public List<Vertice<T>> getVertices() {
		return vertices;
	}

	public void setVertices(List<Vertice<T>> vertices) {
		this.vertices = vertices;
	}
	
	
	//M?todos
	public void addNodo(T nodo){
		this.addNodo(new Vertice<T>(nodo));
	}

	private void addNodo(Vertice<T> nodo){
		this.vertices.add(nodo);
	}
	
	public void conectar(T n1,T n2, Integer d,Integer c, String es, Float float1){
		this.conectar(getNodo(n1), getNodo(n2), d, c, es,float1);
	}

	private void conectar(Vertice<T> nodo1, Vertice<T> nodo2, Integer d,Integer c, String es, float co){
		this.aristas.add(new Arista<T>(nodo1,nodo2,d,c,es, co));
	}
	
	public Vertice<T> getNodo(T valor){
		Vertice<T> nuevoVertice = new Vertice<T>(valor);
		if(vertices.indexOf(nuevoVertice) != -1){
			return this.vertices.get(vertices.indexOf(nuevoVertice));
		}
		else {
			return nuevoVertice;
		}
		
	}

	public List<T> getAdyacentes(T valor){ 
		Vertice<T> unNodo = this.getNodo(valor);
		List<T> salida = new ArrayList<T>();
		for(Arista<T> enlace : this.aristas){
			if( enlace.getInicio().equals(unNodo)){
				salida.add(enlace.getFin().getValor());
			}
		}
		return salida;
	}
	

	public List<Vertice<T>> getAdyacentesV(Vertice<T> unNodo){ 
		List<Vertice<T>> salida = new ArrayList<Vertice<T>>();
		for(Arista<T> enlace : this.aristas){
			if( enlace.getInicio().equals(unNodo)){
				salida.add(enlace.getFin());
			}
		}
		return salida;
	}
	
	public void imprimirAristas(){
		System.out.println(this.aristas.toString());
	}

	public Integer gradoEntrada(Vertice<T> vertice){
		Integer res =0;
		for(Arista<T> arista : this.aristas){
			if(arista.getFin().equals(vertice)) ++res;
		}
		return res;
	}

	public Integer gradoSalida(Vertice<T> vertice){
		Integer res =0;
		for(Arista<T> arista : this.aristas){
			if(arista.getInicio().equals(vertice)) ++res;
		}
		return res;
	}

	public List<T> recorridoAnchura(Vertice<T> inicio){
		List<T> resultado = new ArrayList<T>();
		//estructuras auxiliares
		Queue<Vertice<T>> pendientes = new LinkedList<Vertice<T>>();
		HashSet<Vertice<T>> marcados = new HashSet<Vertice<T>>();
		marcados.add(inicio);
		pendientes.add(inicio);
		
		while(!pendientes.isEmpty()){
			Vertice<T> actual = pendientes.poll();
			List<Vertice<T>> adyacentes = this.getAdyacentesV(actual);
			resultado.add(actual.getValor());
			for(Vertice<T> v : adyacentes){
				if(!marcados.contains(v)){ 
					pendientes.add(v);
					marcados.add(v);
				}
			}
		}		
		//System.out.println(resultado);
		return resultado;
 	}
	
	public List<T> recorridoProfundidad(Vertice<T> inicio){
		List<T> resultado = new ArrayList<T>();
		Stack<Vertice<T>> pendientes = new Stack<Vertice<T>>();
		HashSet<Vertice<T>> marcados = new HashSet<Vertice<T>>();
		marcados.add(inicio);
		pendientes.push(inicio);
		
		while(!pendientes.isEmpty()){
			Vertice<T> actual = pendientes.pop();
			List<Vertice<T>> adyacentes = this.getAdyacentesV(actual);
			resultado.add(actual.getValor());
			for(Vertice<T> v : adyacentes){
				if(!marcados.contains(v)){ 
					pendientes.push(v);
					marcados.add(v);
				}
			}
		}		
		//System.out.println(resultado);
		return resultado;
 	}
 	
	public List<T> recorridoTopologico(){
		List<T> resultado = new ArrayList<T>();
		Map<Vertice<T>,Integer> gradosVertice = new HashMap<Vertice<T>,Integer>();
		for(Vertice<T> vert : this.vertices){
			gradosVertice.put(vert, this.gradoEntrada(vert));
		}
		while(!gradosVertice.isEmpty()){
		
			List<Vertice<T>> nodosSinEntradas = gradosVertice.entrySet()
							.stream()
							.filter( x -> x.getValue()==0)
							.map( p -> p.getKey())
							.collect( Collectors.toList());
			
            if(nodosSinEntradas.isEmpty()) System.out.println("TIENE CICLOS");
            
			for(Vertice<T> v : nodosSinEntradas){
            	resultado.add(v.getValor());
            	gradosVertice.remove(v);
            	for(Vertice<T> ady: this.getAdyacentesV(v)){
            		gradosVertice.put(ady,gradosVertice.get(ady)-1);
            	}
            }
		}
		
		System.out.println(resultado);
		return resultado;
 	}
        
    public boolean esAdyacente(Vertice<T> origen,Vertice<T> destino){
    	List<Vertice<T>> ady = this.getAdyacentesV(origen);
        for(Vertice<T> unAdy : ady){
        	if(unAdy.equals(destino)) return true;
        }
        return false;
    }
    

    public Boolean hayCamino(Vertice<T> v1,Vertice<T> v2) {
    	List<Vertice<T>> adyacentes = getAdyacentesV(v1);
    	for(Vertice<T> vAdy : adyacentes) {
    		if(vAdy.equals(v2)) {
    			return true;
    		} else {
    			return hayCamino(vAdy, v2);
    		}
    	}
    	return false;
    }

    public Arista<T> arista(Vertice<T> v1, Vertice<T> v2){
    	for(Arista<T> a: this.aristas) {
    		if(v1.equals(a.getInicio()) && v2.equals(a.getFin())){
    			return a;
    		}
    	}
    	return null;
    }
    
  //Para PageRank
    public List<T> adyacentes(T valor){
    	Vertice<T> nodo = this.getNodo(valor);
    	List<T> salida = new ArrayList<T>();
		for(Arista<T> enlace : this.aristas){
			if(enlace.getInicio().equals(nodo)){
				salida.add(enlace.getFin().getValor());
			} else if(enlace.getFin().equals(nodo)) {
				salida.add(enlace.getInicio().getValor());
			}
		}
		return salida;
    }

    public List<Vertice<T>> adyacentes(Vertice<T> nodo){
    	List<Vertice<T>> salida = new ArrayList<Vertice<T>>();
		for(Arista<T> enlace : this.aristas){
			if(enlace.getInicio().equals(nodo)){
				salida.add(enlace.getFin());
			} else if(enlace.getFin().equals(nodo)) {
				salida.add(enlace.getInicio());
			}
		}
		return salida;
    }


    
}
	
	

