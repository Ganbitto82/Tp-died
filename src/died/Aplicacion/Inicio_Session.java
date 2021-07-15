package died.Aplicacion;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;





public class Inicio_Session extends JFrame {
	
		
	
	private static final long serialVersionUID = 1L;

	public Image imagenFondo;
	public URL fondo;
	public Inicio_Session() {
		this.setBounds(0, 0, 400, 400);
		this.setTitle("Ventana");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		fondo= this.getClass().getResource("/Imagenes/imagen.png");
		imagenFondo=new ImageIcon(fondo).getImage();
		
		Container contenedor =getContentPane();
		contenedor.add(panel);
	
		
	}
	
	public JPanel panel =new JPanel() 
	{
	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	   public void paintComponent( Graphics g) {
		
		g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
		
		
	}
	};
	
public static void main (String [ ]args) {
		
		
		Inicio_Session inicio= new Inicio_Session ();
		
	}
	
	
	
}
