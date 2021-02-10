package de.app;

import java.awt.EventQueue;

import de.app.control.Controller;
import de.app.gui.MainFrame;


public class MeinApplikation {
//	private static MainFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller control = new Controller();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}



	


