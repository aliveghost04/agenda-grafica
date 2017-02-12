package edu.itla.agenda.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import edu.itla.agenda.gui.mngcontactos.ManejadorContacto;

public class InterfazGrafica extends JFrame{
	
	JLabel etiquetaTitulo;
	JButton btnAgregarContacto, btnListarContacto, btnEliminarContacto;
	
	private static final long serialVersionUID = 1L; 
	
	public InterfazGrafica() {
		
		super("Agenda Gráfica");
		setLayout(null);
		JMenuItem elementoSalir = new JMenuItem ("Salir");
		elementoSalir.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		
		JMenuItem elementoAcercaDe = new JMenuItem("Acerca de");
		elementoAcercaDe.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Agenda Gráfica \nHecha por Erick Jiménez \nCopyright© 2013", 
						"Información", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		JMenu menuArchivo = new JMenu("Archivo");
		menuArchivo.add(elementoSalir);
		
		JMenu menuAyuda = new JMenu("Ayuda");
		menuAyuda.add(elementoAcercaDe);
		
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.add(menuArchivo);
		barraMenu.add(menuAyuda);
		
		etiquetaTitulo = new JLabel("Agenda Gráfica");
		Font fuenteTitulo = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 22);
		etiquetaTitulo.setFont(fuenteTitulo);
		etiquetaTitulo.setBounds(70, 20, 250, 30);
		etiquetaTitulo.setForeground(Color.blue);
		
		btnAgregarContacto = new JButton("Agregar Usuario");
		btnAgregarContacto.setBounds(70, 70, 150, 50);
		btnAgregarContacto.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ManejadorContacto addContacto = new ManejadorContacto();
				addContacto.agregarContacto();
			}
		});
		
		btnListarContacto = new JButton("Listar Contactos");
		btnListarContacto.setBounds(70, 150, 150, 50);
		btnListarContacto.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				ManejadorContacto listarContacto = new ManejadorContacto();
				listarContacto.listarContacto();
			}
		});
		
		btnEliminarContacto = new JButton("Eliminar Contacto");
		btnEliminarContacto.setBounds(70, 230, 150, 50);
		btnEliminarContacto.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				ManejadorContacto eliminarContacto = new ManejadorContacto();
				eliminarContacto.eliminarContacto();
			}
		});
		
		setJMenuBar(barraMenu);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		add(etiquetaTitulo);
		add(btnAgregarContacto);
		add(btnListarContacto);
		add(btnEliminarContacto);
	}
}
