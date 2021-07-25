package died.Controlador;



import died.Clases.Estacion;
import died.dao.EstacionDao;
import died.dao.IEstacionDao;




public class EstacionContralador {

	
	private IEstacionDao estacionDao=new EstacionDao() ;
	
	public void guardar(Estacion est) {
		
			estacionDao.altaEstacion(est);
		}
	
	public void bajaEstacion(Integer id) {
		estacionDao.bajaEstacion(id);
	}

	public void editarEstacion(Estacion e)  {
		try {
		    	estacionDao.editarEstacion(e);
		
		} catch (Exception e1) {
			
			e1.getMessage();
		}
	}
}
