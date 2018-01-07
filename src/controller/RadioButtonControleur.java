package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import jeu.Jeu;
import ui.Parametrer;

public class RadioButtonControleur {
	private Jeu jeu;
	public RadioButtonControleur(Jeu j) {
		jeu = j;
	}
	
	public void add(JRadioButton radio) {
		radio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "1":
					Jeu.setNombreDeJeux(1);
					break;
				case "2":
					Jeu.setNombreDeJeux(2);
					break;
				case "oui":
					Jeu.setAvecJoker(1);
					break;
				case "non":
					Jeu.setAvecJoker(0);
					break;
				case "positif":
					Jeu.setMethodeCompte(1);
					break;
				case "negatif":
					Jeu.setMethodeCompte(0);
					break;
				}
			}
		});
		
	}
	public RadioButtonControleur(Jeu j,JRadioButton radio) {
		radio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "1":
					Jeu.setNombreDeJeux(1);
					break;
				case "2":
					Jeu.setNombreDeJeux(2);
					break;
				case "oui":
					Jeu.setAvecJoker(1);
					break;
				case "non":
					Jeu.setAvecJoker(0);
					break;
				case "positif":
					Jeu.setMethodeCompte(1);
					break;
				case "negatif":
					Jeu.setMethodeCompte(0);
					break;
				}
			}
		});
	}

}
