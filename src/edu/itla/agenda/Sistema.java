package edu.itla.agenda;

import javax.swing.JFrame;
import javax.swing.UIManager;

import edu.itla.agenda.gui.InterfazGrafica;

public class Sistema {
	
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		InterfazGrafica gui = new InterfazGrafica ();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(300, 400);
		gui.setResizable(false);
		gui.setLocationByPlatform(true);
		gui.setVisible(true);
	}
}
