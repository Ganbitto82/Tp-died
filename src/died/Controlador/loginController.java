package died.Controlador;

public class loginController {

	
	public boolean validacionVacios(String usuario, String contrasenia) {
		if(usuario.isEmpty()) { 
			System.out.println("El campo de usuario se encuentra vacío"); 
			return false;
		}
		if(contrasenia.isEmpty()) {
			System.out.println("El campo de contraseña se encuentra vacío"); 
			return false;
		}
		return true;
	}
}
