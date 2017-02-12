package edu.itla.agenda.gui.mngcontactos;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import edu.itla.agenda.serializadora.Serializadora;

public class ModeloTablaEstudiante extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	
	Serializadora serializadora = new Serializadora();
	
	ArrayList<Contacto> contactos = new ArrayList<Contacto>();
	String[] columnasTabla = {"Nombre", "Apellido", "Telefono"};
	
	private static ModeloTablaEstudiante instancia;
	
	public static ModeloTablaEstudiante getInstancia() {
		
		if (instancia == null) {
			instancia = new ModeloTablaEstudiante();
		}
		return instancia;
	}
	
	public void agregar(Contacto contacto){
		contactos.add(contacto);
		new Serializadora().serializar(contactos);
		fireTableDataChanged();
	}
	
	private ModeloTablaEstudiante() {
		contactos = serializadora.deserializar();
	}
	
	public int getColumnCount() {
		return columnasTabla.length;
	}

	public int getRowCount() {
		return contactos.size();
	}

	public Object getValueAt(int fila, int columna) {
		
		Contacto contacto = contactos.get(fila);
		
		String valorCelda = "";
		
		switch (columna) {
		case (0):
			valorCelda = contacto.getNombre();
		break;
		case (1):
			valorCelda = contacto.getApellido();
		break;
		case (2):
			valorCelda = contacto.getTelefono();
		break;
		}
		return valorCelda;
	}
	
	public String getColumnName(int columnas){
		return columnasTabla[columnas];
	}
}
