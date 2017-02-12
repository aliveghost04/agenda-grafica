package edu.itla.agenda.gui.mngcontactos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import edu.itla.agenda.serializadora.Serializadora;

public class ManejadorContacto extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	String nombre = "";
	String apellido = "";
	String telefono = "";
	long revisionTelefono;
	
	JTextField campoNombre, campoApellido, campoTelefono;
	JLabel etiquetaTitulo, etiquetaNombre, etiquetaApellido, etiquetaTelefono;
	JButton btnGuardarContacto;
	JTable tablaContactos;
	
	public void agregarContacto() {
		
		setTitle("Agregar Contactos");
		setLocationByPlatform(true);
		setLayout(null);
		setSize(300, 215);
		setResizable(false);
		
		etiquetaTitulo = new JLabel("Agregando Contacto");
		etiquetaTitulo.setBounds(55, 5, 250, 30);
		Font fuenteTitulo = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 22);
		etiquetaTitulo.setFont(fuenteTitulo);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		etiquetaTitulo.setForeground(Color.BLUE);
		
		etiquetaNombre = new JLabel("Nombre: ");
		etiquetaNombre.setBounds(15, 40, 50, 20);
		
		etiquetaApellido = new JLabel("Apellido: ");
		etiquetaApellido.setBounds(15, 70, 50, 20);
		
		etiquetaTelefono = new JLabel("Teléfono: ");
		etiquetaTelefono.setBounds(15, 100, 50, 20);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(65, 40, 180, 20);
		
		campoApellido = new JTextField();
		campoApellido.setBounds(65, 70, 180, 20);
		
		campoTelefono = new JTextField();
		campoTelefono.setBounds(65, 100, 180, 20);
		
		btnGuardarContacto = new JButton("Guardar Contacto");
		btnGuardarContacto.setBounds(70, 130, 150, 30);
		btnGuardarContacto.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				nombre = campoNombre.getText();
				apellido = campoApellido.getText();
				telefono = campoTelefono.getText();
				
				try {
					revisionTelefono = Long.parseLong(telefono);
				} catch (Exception e3) {
					revisionTelefono = 0;
				}
				
				if (nombre.equals("") || apellido.equals("") || telefono.equals("")) {
					JOptionPane.showMessageDialog(ManejadorContacto.this, "Debe de llenar todos los campos", "Información", JOptionPane.ERROR_MESSAGE);
				} else {
					if (revisionTelefono == 0) {
						JOptionPane.showMessageDialog(ManejadorContacto.this, "Debe introducir un número válido", "Información", JOptionPane.ERROR_MESSAGE);
					} else {
						Contacto contacto = new Contacto(nombre, apellido, telefono);
						ModeloTablaEstudiante.getInstancia().agregar(contacto);
						JOptionPane.showMessageDialog(ManejadorContacto.this, "¡Contacto Agregado!", 
									"Información", JOptionPane.INFORMATION_MESSAGE);
						
						campoNombre.setText("");
						campoApellido.setText("");
						campoTelefono.setText("");
					}
				}
			}
		});
		
		add(etiquetaTitulo);
		add(etiquetaNombre);
		add(etiquetaApellido);
		add(etiquetaTelefono);
		add(campoNombre);
		add(campoApellido);
		add(campoTelefono);
		add(btnGuardarContacto);
		
		setVisible(true);
	}
	
	public void listarContacto() {
		
		setTitle("Listando Contactos");
		setLocationByPlatform(true);
		setSize(400, 400);
		
		JTable tablaContacto = new JTable (ModeloTablaEstudiante.getInstancia());
		JScrollPane contenedorTabla = new JScrollPane(tablaContacto);
		
		add(contenedorTabla);
		setVisible(true);
	}
	
	public void eliminarContacto() {
		
		setTitle("Eliminando Contactos");
		setLocationByPlatform(true);
		setSize(400, 490);
		
		tablaContactos = new JTable (ModeloTablaEstudiante.getInstancia());
		JScrollPane contenedorTabla = new JScrollPane(tablaContactos);
		
		JButton btnEliminarContacto = new JButton("Eliminar Contacto");
		btnEliminarContacto.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evento) {
				
				int numeroEliminar;
				numeroEliminar = tablaContactos.getSelectedRow();
				
				if (numeroEliminar != -1) {
					ModeloTablaEstudiante.getInstancia().contactos.remove(numeroEliminar);
					new Serializadora().serializar(ModeloTablaEstudiante.getInstancia().contactos);
					ModeloTablaEstudiante.getInstancia().fireTableDataChanged();
					JOptionPane.showMessageDialog(ManejadorContacto.this, "¡Contacto Eliminado!", 
							"Información", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(ManejadorContacto.this, "Seleccione el contacto a eliminar", 
							"Información", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		add(contenedorTabla, BorderLayout.NORTH);
		add(btnEliminarContacto, BorderLayout.SOUTH);
		setVisible(true);
	}
}
