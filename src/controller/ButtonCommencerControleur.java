package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import jeu.Jeu;
import ui.Parametrer;

public class ButtonCommencerControleur extends Controleur{
	private Jeu jeu;
	public ButtonCommencerControleur(Jeu j) {
		super(j);
		jeu = j;
	}

	public void add(JButton commencer) {
		commencer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//new Parametrer(jeu);
			}
		});
	}
}
