package died.dao;


import java.util.List;


import died.Clases.Linea;


public interface ILineaDao {
	public void altaLinea(Linea l) throws Exception;
	public void bajaLinea(Integer id) throws Exception;
	public void editarLinea(Linea l) throws Exception;
	public List<Linea> buscarTodos(String s) throws Exception;
	
}
