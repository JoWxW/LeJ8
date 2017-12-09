package action;

import joueur.Joueur;

public class Action {
	String nom;
	
	public Action() {
		
	}
	
	//Le joueur va agir a la fin de son tour, on transmet le joueur pour les infos necessaires
	public void agir(Joueur jou) {
	}
	
	public void setNom(String s) {
		this.nom = s;
	}
	
	public String getNom() {
		return this.nom;
	}


}
