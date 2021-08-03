package died.Aplicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import died.Controlador.LineaController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import java.awt.MultipleGradientPaint.ColorSpaceType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroLineaTransporte extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private LineaController lc = new LineaController();

	public RegistroLineaTransporte() {
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Color:");
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Estado:");
		
		JComboBox comboEstado = new JComboBox();
		comboEstado.setModel(new DefaultComboBoxModel(new String[] {"", "ACTIVA", "NOACTIVA"}));
		
		JComboBox comboColor = new JComboBox();
		comboColor.setModel(new DefaultComboBoxModel(new String[] {"", "AZUL", "AMARILLO", "BLANCO", "NEGRO", "ROJO", "GRIS", "VERDE", "VIOLETA", "ROSADO", "NARANJA", "MORADO"}));
		
		JButton btnDarDeAlta = new JButton("DarDeAlta");
		btnDarDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = textNombre.getText();
				String color = comboColor.getSelectedItem().toString();
				String estado = comboEstado.getSelectedItem().toString();
				
				if(lc.validacionVacios(nombre, color, estado))
				{
					textNombre.setText("");
					comboColor.setSelectedIndex(0);
					comboEstado.setSelectedIndex(0);
					mensajeExitosoDeAlta();
				}
				else {
			
					informarErrorDeAlta();
				}
				
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = textNombre.getText();
				String color = comboColor.getSelectedItem().toString();
				String estado = comboEstado.getSelectedItem().toString();
				
				if(lc.validacionVacios(nombre, color, estado))
				{
					EditarLinea linea = new EditarLinea(nombre);
					linea.setVisible(true);
					linea.setLocationRelativeTo(null);
					textNombre.setText("");
					comboColor.setSelectedIndex(0);
					comboEstado.setSelectedIndex(0);
				}
				else {
			
					informarErrorDeBusqueda();
				}
				
			}
		});
		
		JButton btnBaja = new JButton("DarDeBaja");
		btnBaja.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = textNombre.getText();
				String color = comboColor.getSelectedItem().toString();
				String estado = comboEstado.getSelectedItem().toString();
				
				if(lc.validacionVacios(nombre, color, estado))
				{
					mensajeExitosoDeBaja();
				}
				else {
			
					informarErrorDeBaja();
				}
				
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nombre = textNombre.getText();
				String color = comboColor.getSelectedItem().toString();
				String estado = comboEstado.getSelectedItem().toString();
				
				if(lc.validacionVacios(nombre, color, estado))
				{
					ListaTrayectos lista = new ListaTrayectos();
					lista.setVisible(true);
					lista.setLocationRelativeTo(null);
					textNombre.setText("");
					comboColor.setSelectedIndex(0);
					comboEstado.setSelectedItem(0);
					dispose();
				}
				else {
			
					informarErrorDeBusqueda();
					textNombre.setText("");
					comboColor.setSelectedIndex(0);
					comboEstado.setSelectedItem(0);
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblNewLabel_1_1_1_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboColor, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboEstado, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBaja, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnEditar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDarDeAlta, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDarDeAlta))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_1_1)
								.addComponent(comboEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(comboColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBaja)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBuscar)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JLabel lblNewLabel = new JLabel("Ingrese los siguientes datos:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(377, Short.MAX_VALUE)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnCancelar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void informarErrorDeAlta() {
		
		JOptionPane.showMessageDialog(null, "Es necesario completar todos los campos para dar de alta la Linea de Transporte");
		
	}
	public void mensajeExitosoDeAlta()
	{
		JOptionPane.showMessageDialog(null, "Linea de Transporte dada de alta con exito");
	}
	public void informarErrorDeBaja() {
		
		JOptionPane.showMessageDialog(null, "Falta completar datos faltantes para dar de baja la Linea de Transporte");
		
	}
	public void mensajeExitosoDeBaja()
	{
		JOptionPane.showMessageDialog(null, "Linea de Transporte dada de baja con exito");
	}
	public void informarErrorDeBusqueda() {
		
		JOptionPane.showMessageDialog(null, "Linea de Transporte no encontrada, vuelva a completar los datos con una linea existente");
		
	}
}
