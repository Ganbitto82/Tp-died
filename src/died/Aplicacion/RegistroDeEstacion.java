package died.Aplicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import died.Clases.Estacion;
import died.Clases.EstadoEstacion;
import died.Controlador.EstacionController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.time.LocalTime;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;

public class RegistroDeEstacion extends JFrame {

	private JPanel contentPane;
	private JTextField textHorario;
	private JTextField textHorarioCierre;
	private JTextField textNombre;
	private JTextField textId;
	private JComboBox comboEstado = new JComboBox();
	private EstacionController ec = new EstacionController();
	private Estacion estacion =new Estacion();

	public RegistroDeEstacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Ingrese los siguientes datos:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Horario de apertura:");
		
		textHorario = new JTextField();
		textHorario.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Horario de cierre:");
		
		textHorarioCierre = new JTextField();
		textHorarioCierre.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Id Usuario:");
		
		textId = new JTextField();
		textId.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Estado:");
		
		comboEstado.addItem("");
		comboEstado.addItem("OPERATIVA");
		comboEstado.addItem("ENMANTENIMIENTO");
		
		JButton btnDarDeAlta = new JButton("DarDeAlta");
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String inicio = textHorario.getText();
				String cierre = textHorarioCierre.getText();
				String nombre = textNombre.getText();
				String id = textId.getText();
				String estado = comboEstado.getSelectedItem().toString();
				
				if(ec.validacionVacios(id, nombre, inicio, cierre, estado))
				{
					mensajeExitosoDeAlta();
					textHorario.setText("");
					textHorarioCierre.setText("");
					textNombre.setText("");
					textId.setText("");
					estacion.setNombre(nombre);
					Time t = Time.valueOf(LocalTime.now());
					estacion.setInicio(t);
					estacion.setCierre(t);
					EstadoEstacion Enum = EstadoEstacion.valueOf(estado);
					estacion.setEstado(Enum);
					try {
						ec.guardar(estacion);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Estación no encontrada, vuelva a completar los datos con una estación existente");
				    
					}
				}
				else {
			
					informarErrorDeAlta();
				}
				
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String inicio = textHorario.getText();
				String cierre = textHorarioCierre.getText();
				String nombre = textNombre.getText();
				String id = textId.getText();
				String estado = comboEstado.getSelectedItem().toString();
				
				if(ec.validacionVacios(id, nombre, inicio, cierre, estado) || ec.validacionVacios(id))
				{
					EditarEstacion tipo;
					try {
						tipo = new EditarEstacion(id, nombre, inicio, cierre, estado);
						tipo.setVisible(true);
						tipo.setLocationRelativeTo(null);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else {
			
					informarErrorDeBusqueda();
					/*textHorario.setText("");
					textHorarioCierre.setText("");
					textNombre.setText("");
					textId.setText("");
					comboEstado.setSelectedIndex(0);*/
				}
				
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				String inicio = textHorario.getText();
				String cierre = textHorarioCierre.getText();
				String nombre = textNombre.getText();
				String id = textId.getText();
				String estado = comboEstado.getSelectedItem().toString();
				
				if(ec.validacionVacios(id, nombre, inicio, cierre, estado) || ec.validacionVacios(id) || ec.validacionVacios(nombre) || ec.validacionVacios(inicio) || ec.validacionVacios(cierre) || ec.validacionVacios(estado))
				{
					TipoEstacion tipo = new TipoEstacion(id, nombre, inicio, cierre, estado);
					tipo.setVisible(true);
					tipo.setLocationRelativeTo(null);
					dispose();
				}
				else {
			
					informarErrorDeBusqueda();
					textHorario.setText("");
					textHorarioCierre.setText("");
					textNombre.setText("");
					textId.setText("");
					comboEstado.setSelectedIndex(0);
					
				}
				
			}
		});
		
		JButton btnBaja = new JButton("DarDeBaja");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String inicio = textHorario.getText();
				String cierre = textHorarioCierre.getText();
				String nombre = textNombre.getText();
				String id = textId.getText();
				String estado = comboEstado.getSelectedItem().toString();
				
				if(ec.validacionVacios(id, nombre, inicio, cierre, estado) || ec.validacionVacios(id))
				{
					mensajeExitosoDeBaja();
					textHorario.setText("");
					textHorarioCierre.setText("");
					textNombre.setText("");
					textId.setText("");
				}
				else {
			
					informarErrorDeBaja();
				}
				
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1_1_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textHorarioCierre)
						.addComponent(textId, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(comboEstado, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(textHorario, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(textNombre))
					.addGap(88)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnBaja, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnEditar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDarDeAlta, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addGap(53))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnDarDeAlta)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBuscar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBaja))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(37)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(textHorario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_1_1)))
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_1_1)))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(comboEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(17)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(textId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1)))
								.addComponent(lblNewLabel_1_1_1_1))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_1_2)
								.addComponent(textHorarioCierre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
					dispose();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(249, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(372, Short.MAX_VALUE)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(16)
					.addComponent(btnCancelar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
				
	}
	public void informarErrorDeBaja() {
		
		JOptionPane.showMessageDialog(null, "Falta completar datos faltantes para dar de baja la Estación");
		
	}
	public void mensajeExitosoDeBaja()
	{
		JOptionPane.showMessageDialog(null, "Estación dada de baja con exito");
	}
	public void informarErrorDeAlta() {
		
		JOptionPane.showMessageDialog(null, "Es necesario completar todos los campos para dar de alta la Estación");
		
	}
	public void mensajeExitosoDeAlta()
	{
		JOptionPane.showMessageDialog(null, "Estación dada de alta con exito");
	}
	public void informarErrorDeBusqueda() {
		
		JOptionPane.showMessageDialog(null, "Estación no encontrada, vuelva a completar los datos con una estación existente");
		
	}

}
