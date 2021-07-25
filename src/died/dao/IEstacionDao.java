package died.dao;

import java.util.List;

import died.Clases.Estacion;
import died.Clases.Linea;
import died.Clases.Mantenimiento;
import died.Clases.Trayecto;

public interface IEstacionDao {
	
	public void altaEstacion(Estacion e);
	public void bajaEstacion(Integer id);
	public void editarEstacion(Estacion e);
	public List<Estacion> buscarTodos(String s);
	public void editar_id_boleto(Estacion e);
	public List<Trayecto> buscarTrayectos();
	public List<Mantenimiento> buscarMantenimientos();
	public List<Linea> buscarLineas();

}
