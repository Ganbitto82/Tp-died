package died.dao;

import java.util.List;

import died.Clases.Estacion;
import died.Clases.Trayecto;


public interface ITrayectoDao {
	public void altaTrayecto(Trayecto t) throws Exception;
	public List<Estacion> buscarEstaciones(Integer id_trayecto,Integer id_estacion) throws Exception;
	public List<Trayecto> buscarLineas(Integer id_linea) throws Exception;

}
