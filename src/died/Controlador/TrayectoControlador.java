package died.Controlador;

import died.Clases.Trayecto;
import died.dao.ITrayectoDao;
import died.dao.TrayectoDao;

public class TrayectoControlador {
	
	private ITrayectoDao trayectoDao;

	public TrayectoControlador() {
		
		trayectoDao = new TrayectoDao();
	}
	
	public void altaTrayecto (Trayecto t) throws Exception {
		
		try {
			trayectoDao.altaTrayecto(t);
		   }
			
			catch (Exception ex) {
				 throw ex;
				
			}
	}
	public void buscarEstaciones(Integer id_trayecto,Integer id_estacion) throws Exception {
		
		
		try {
			trayectoDao.buscarEstaciones(id_trayecto,id_estacion);
		   }
			
			catch (Exception ex) {
				 throw ex;
				
			}
	}

}
