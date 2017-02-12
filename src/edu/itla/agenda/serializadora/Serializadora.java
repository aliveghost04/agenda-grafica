package edu.itla.agenda.serializadora;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import edu.itla.agenda.gui.mngcontactos.Contacto;

public class Serializadora {

	public void serializar(ArrayList<Contacto> contactos) {
		
		try {
			FileOutputStream fos = new FileOutputStream("datos.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(contactos);
			oos.close();
		} catch(Exception e) {
			System.err.println("Error al serializar");
		}
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Contacto> deserializar() {
		
		ArrayList<Contacto> deserializar = null;
		try {
			FileInputStream fis = new FileInputStream("datos.dat");
			ObjectInputStream fos = new ObjectInputStream(fis);
			deserializar = (ArrayList<Contacto>) fos.readObject();
		} catch(Exception e) {
			deserializar = new ArrayList<Contacto>();
		}
		
		return deserializar;
	}
}
