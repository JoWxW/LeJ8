package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;

import jeu.Jeu;
import ui.Game;
import ui.Parametrer;

public class ButtonLancerControleur {
	
	public ButtonLancerControleur(Jeu j,JButton lancer) {
		lancer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//new Game(j);
				
			}
		});
	}


}
