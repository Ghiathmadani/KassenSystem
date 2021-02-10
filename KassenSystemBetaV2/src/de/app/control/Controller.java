package de.app.control;


import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import System.Lage;
import System.Ware;
import de.app.gui.MainFrame;
import de.app.gui.MainPanel;
import de.app.model.Data;

public class Controller {
	
	private final MainFrame mf;
	private Data data;
	private double nachrabbat;
	private double züruckgeld;
	
	public Controller() {
		mf = new MainFrame();
		scanGUI(mf);
		initialize();
		mf.setVisible(true);
	}

	private void initialize() {
		mf.getEinfugenButton().addActionListener(this::EinfugenButton);
		mf.getLöschenButton().addActionListener(this::LöschenButton);
		mf.getAkButton().addActionListener(this::akButton);
		mf.getEinkaufButton_1().addActionListener(this::EinkaufButton);
		mf.getBezahlenButton().addActionListener(this::bezahlenButton);
		
	}
	// Dynamic Weg ohne Getters und Setters :
	private void scanGUI(Container root) {

		Component[] childs = root.getComponents();
		
		for (Component component : childs) {
			
			
			if (component instanceof Container) {
				
				scanGUI((Container)component);
			}
			//System.out.println("Compoment = " + component);
//			if(component instanceof MainPanel) {
//				
//			}
		}
		
	}

	
	private void EinfugenButton(ActionEvent e) {
		try {
			String mengeText=mf.getTextField_menge().getText();
			int mengeInt=Integer.parseInt(mengeText);
			String priceText= mf.getTextField_price().getText();
			Double priceDouble=Double.parseDouble(priceText);
			
			Lage.lagelist.add(new Ware(mf.getTextField_wareName().getText(), mengeInt, priceDouble));
			}catch(NumberFormatException a) {
				JOptionPane.showMessageDialog(mf, "bitte schreiben Sie richtig Eingabe");
			}
		}
	
	private void LöschenButton(ActionEvent e) {
		try {
			int idInt =Integer.parseInt(mf.getTextField_idlöschen().getText());
			Lage.lagelist.remove(idInt-1);
			}catch(NumberFormatException a) {
				JOptionPane.showMessageDialog(mf, "bitte schreiben Sie richtig Eingabe");
			}
	}
	
	private void akButton(ActionEvent e) {
		try {
			int idInt =Integer.parseInt(mf.getTextField_IdAk().getText());
			Ware alteWare = Lage.lagelist.get(idInt - 1);
			String mengeText=mf.getTextField_mengeAk().getText();
			int mengeInt=Integer.parseInt(mengeText);
			String priceText=mf.getTextField_priceAk().getText();
			Double priceDouble=Double.parseDouble(priceText);
			alteWare.setName(mf.getTextField_nameAk().getText());
			alteWare.setMenge(mengeInt);
			alteWare.setPrice(priceDouble);
			}catch(NumberFormatException a) {
				JOptionPane.showMessageDialog(mf, "bitte schreiben Sie richtig Eingabe");
			}
	}
	
	private void EinkaufButton(ActionEvent e) {
		try {
			int idInt =Integer.parseInt(mf.getTextField_idEinkauf().getText());
			int idmenge =Integer.parseInt(mf.getTextField_mengeEinkauf().getText());
			if (idmenge > Lage.lagelist.get(idInt - 1).getMenge()) {
				JOptionPane.showMessageDialog(null, "Sorry, Wir haben nur " + Lage.lagelist.get(idInt - 1).getMenge() + " Stück");
			}else {
			double n1=mf.getZwischenSumme() + mf.getUtility().getDerPrice.apply(Lage.lagelist.get(idInt - 1), idmenge);
			Lage.lagelist.get(idInt - 1).decreaseMenge(idmenge);
			mf.setSumme(n1 + (n1 / 100 * 0.7));
			mf.getEinkaufList().add(new Ware(Lage.lagelist.get(idInt - 1).getName(), idmenge, Lage.lagelist.get(idInt - 1).getPrice()));
			}
			}catch(NumberFormatException a) {
				JOptionPane.showMessageDialog(mf, "bitte schreiben Sie richtig Eingabe");
			}
	}
	
	private void bezahlenButton(ActionEvent e) {
		try {
			double bargeld =mf.setBarGeldDouble((Double.parseDouble(mf.getTextField_barGeld().getText())));
			if (mf.getSumme() > bargeld) {
				JOptionPane.showMessageDialog(mf, "Nicht genug Geld !! Sie sollen "+ mf.getSumme()+"€ bezalen");
				
			}
			else if(mf.getSumme()>=30) {
					mf.setRabatt(mf.getSumme()*0.10);
					nachrabbat=mf.getSumme()-mf.getRabatt();
					züruckgeld=bargeld - nachrabbat;
					result();
					
			}else {//(mf.getSumme()<30)
				züruckgeld=bargeld - mf.getSumme();
				result();
			}
			
		}catch(NumberFormatException a) {
			JOptionPane.showMessageDialog(mf, "bitte schreiben Sie richtig Eingabe");
		}
	}

	private void result() {
		mf.getRabattLabel_12().setText("Ihrer Rabatt = "+ mf.getRabatt());
		mf.getBezahlenLabel_12().setText("Sie haben bezahlt ="+mf.getSumme()+" € " );
		mf.getZuarckLabel_12().setText("Sie bekommen zurück = "+züruckgeld+" €");
		
	}
}
