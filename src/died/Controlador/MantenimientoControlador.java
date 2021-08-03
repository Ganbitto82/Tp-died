package died.Controlador;


import java.util.List;

import died.Clases.Mantenimiento;

import died.dao.MantenimientoDao;

public class MantenimientoControlador {
	
	private MantenimientoDao mantenimientoDao ;
	
	
		
	public MantenimientoControlador() {
		
		mantenimientoDao= new MantenimientoDao();
	
	}
	
	public void guardar(Mantenimiento m) throws Exception {
		

		 try {
			 mantenimientoDao.altaManteniento(m);
		   }
			
			catch (Exception ex) {
				 throw ex;
				
			}
	}
    public void bajaManteniento(Integer id) throws Exception {
    	
    	
    	 try {
    		 mantenimientoDao.bajaManteniento(id);
  	   }
  		
  		catch (Exception ex) {
  			 throw ex;
  			
  		}
    	
    }
    public void editarMantenimiento(Mantenimiento m, Integer id) throws Exception {
    	
    	
    	 try {
    		 mantenimientoDao.editarMantenimiento(m, id);
  	   }
  		
  		catch (Exception ex) {
  			 throw ex;
  			
  		}
    	
    }
    
    public List<Mantenimiento> buscarTodos() throws Exception{
    	
    	
    	 try {
    		 return mantenimientoDao.buscarTodos();
  	   }
  		
  		catch (Exception ex) {
  			 throw ex;
  			
  		}
	
    	
    	
    }
}
