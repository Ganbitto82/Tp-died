package died.dao;

import java.util.List;

import died.Clases.Estacion;
import died.Clases.Mantenimiento;
import died.Clases.Trayecto;

public interface IEstacionDao {
	
	public void altaEstacion(Estacion e) throws Exception;
	public void bajaEstacion(Integer id) throws Exception;
	public void editarEstacion(Estacion e) throws Exception;
	public List<Estacion> buscarTodos(String s) throws Exception;
	public List<Trayecto> buscarTrayectos(Integer id_estacion,Integer id_trayecto) throws Exception;
	public List<Mantenimiento> buscarMantenimientos(Integer id) throws Exception;
	public Estacion buscarPorNombre(String nombre)throws Exception;
	}
