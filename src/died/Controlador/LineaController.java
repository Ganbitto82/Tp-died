package died.Controlador;


import java.util.List;


import died.Clases.Linea;
import died.dao.ILineaDao;
import died.dao.LineaDao;

public class LineaController {
	
private ILineaDao lineaDao;
	
	
	
	public LineaController() {
		
		lineaDao=new LineaDao() ;
		
	}
	
   public void altaLinea(Linea l) throws Exception {
	   
	 
	   try {
		   lineaDao.altaLinea(l);
	   }
		
		catch (Exception ex) {
			 throw ex;
			
		}
	   
   }
   
   public void  bajaLinea (Linea l ) throws Exception{
	   
	   
	   try {
		   lineaDao.bajaLinea(l.getId());
	   }
		
		catch (Exception ex) {
			 throw ex;
			
		}
   }
   
   public void editarLinea(Linea l) throws Exception {
	  
	try {
		lineaDao.editarLinea(l); 
	   }
		
		catch (Exception ex) {
			 throw ex;
			
		}
	   
   }
   public List<Linea> buscarTodos() throws Exception{
		
		try {
			return lineaDao.buscarTodos("");
		   }
			
			catch (Exception ex) {
				 throw ex;
				
			}
				
	}
	public List<Linea> buscarEstaciones(Linea l) throws Exception{
		
		try {
			return lineaDao.buscarTodos(armarString(l));
		   }
			
			catch (Exception ex) {
				 throw ex;
				
			}
				
	}

	private String armarString(Linea l) {
		String s = new String();
		if(l.getNombre()!=null) s+= "nombre = '" + l.getNombre()+ "' AND " ;
		if(l.getColor()!=null) s+= "color = '"+ l.getColor()+ "' AND ";
		if(l.getEstado()!=null) s+= "estado = '" + l.getEstado()+ "' AND ";
		
		return s.substring(0, s.length()-4);
	}
	public boolean validacionVacios( String nombre, String color, String estado) {
		if(nombre.isEmpty()) { 
			System.out.println("El campo de nombre se encuentra vacío"); 
			return false;
		}
		if(color.isEmpty()) {
			System.out.println("El campo de color se encuentra vacío"); 
			return false;
		}
		if(estado.isEmpty()) {
			System.out.println("El campo de estado se encuentra vacío"); 
			return false;
		}
		return true;
	}
	
	public boolean validacionVacios(String aux) {
		if(aux.isEmpty()) { 
			System.out.println("El campo de aux se encuentra vacío"); 
			return false;
		}
		return true;
	}
	
}
