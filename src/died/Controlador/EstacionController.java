package died.Controlador;



import java.util.List;

import died.Clases.Estacion;
import died.dao.EstacionDao;
import died.dao.IEstacionDao;




public class EstacionController {

	
	private IEstacionDao estacionDao;
	
	
	
	public EstacionController() {
		
		estacionDao=new EstacionDao() ;
	}
	
	public void guardar(Estacion est) throws Exception {
		   try {
			   estacionDao.altaEstacion(est);
		   }
			
			catch (Exception ex) {
				 throw ex;
				
			}
		}
	
	public void bajaEstacion(Integer id) throws Exception {
		try {
			   estacionDao.bajaEstacion(id);
		   }
			
			catch (Exception ex) {
				 throw ex;}
				
			}

	public void editarEstacion(Estacion e) throws Exception  {
		
		    	
		    	try {
		    		estacionDao.editarEstacion(e);
				   }
					
					catch (Exception ex) {
						 throw ex;
						
					}
		
	}
	public List<Estacion> buscarTodos() throws Exception{
		
		try {
			return estacionDao.buscarTodos("");
		   }
			
			catch (Exception ex) {
				 throw ex;
				
			}
				
	}
	public List<Estacion> buscarEstaciones(Estacion e) throws Exception{
		
		try {
			return estacionDao.buscarTodos(armarString(e));
		   }
			
			catch (Exception ex) {
				 throw ex;
				
			}
	}

	public Estacion BuscarPorNombre(String nombre) throws Exception {
		try {
			return estacionDao.buscarPorNombre(nombre);
		   }
			
			catch (Exception ex) {
				 throw ex;
				
			}
		
		
	}
	
	private String armarString(Estacion e) {
		String s = new String();
		if(e.getNombre()!=null) s+= "nombre = '" + e.getNombre() + "' AND " ;
		if(e.getInicio()!=null) s+= "inicio = '"+ e.getInicio() + "' AND ";
		if(e.getEstado()!=null) s+= "estado = '" + e.getEstado() + "' AND ";
		
		return s.substring(0, s.length()-4);
	}
	public boolean validacionVacios(String id, String nombre, String apertura, String cierre, String estado) {
		if(id.isEmpty()) { 
			System.out.println("El campo de id se encuentra vacío"); 
			return false;
		}
		if(nombre.isEmpty()) {
			System.out.println("El campo de nombre se encuentra vacío"); 
			return false;
		}
		if(apertura.isEmpty()) {
			System.out.println("El campo de fecha de apertura se encuentra vacío"); 
			return false;
		}
		if(cierre.isEmpty()) {
			System.out.println("El campo de fecha de cierre se encuentra vacío"); 
			return false;
		}
		if(estado.isEmpty()) {
			System.out.println("El campo de estado se encuentra vacío"); 
			return false;
		}
		return true;
	}
	
	public boolean validacionVacios(String id) {
		if(id.isEmpty()) { 
			System.out.println("El campo de id se encuentra vacío"); 
			return false;
		}
		return true;
	}
	
}
