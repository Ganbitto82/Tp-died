package died.dao;

import java.util.List;


import died.Clases.Mantenimiento;

public interface IMantenientoDao {
	public void altaManteniento(Mantenimiento m) throws Exception;
	public void bajaManteniento(Integer id) throws Exception;
	public void editarMantenimiento(Mantenimiento m, Integer id) throws Exception;
	public List<Mantenimiento> buscarTodos() throws Exception;

}
