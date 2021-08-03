package died.Grafos;

import java.util.List;

import died.Clases.Estacion;
import died.Clases.Trayecto;



public class GrafoRutas extends Grafo<Estacion> {

	public void armarGrafo(List<Trayecto> trayectos) {
		for(Trayecto t: trayectos) {
			if(!this.getVertices().isEmpty()) {
				if(!this.getVertices().contains(this.getNodo(t.getOrigen()))) { this.addNodo(t.getOrigen());};
				if(!this.getVertices().contains(this.getNodo(t.getDestino()))) { this.addNodo(t.getDestino());}
			}
			else {
				this.addNodo(t.getOrigen());
				this.addNodo(t.getDestino());
			}
			this.conectar(t.getOrigen(), t.getDestino(), t.getDistancia(), t.getCantMaxPasajeros(),t.getEstado().toString(),t.getCosto());	
		}
	}

	
	
}
