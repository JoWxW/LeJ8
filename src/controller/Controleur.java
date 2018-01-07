package controller;

import jeu.Jeu;

public class Controleur {
	private Jeu jeu;
	
	public Controleur(Jeu j) {
		setJeu(j);
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

}
