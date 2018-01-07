package controller;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JFrame;

import carte.Carte;
import exception.SaisiNonValideException;
import jeu.Jeu;
import joueur.Joueur;
import joueur.JoueurPhysique;
import ui.Game;
import ui.Parametrer;
import ui.Resultat;

public class JeuControleur {

	private Jeu jeu;

	public JeuControleur() {

	}

	public JeuControleur(Jeu j) {
		jeu = j;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void commencer() {
		// jeu.setJeuEnCours(true);
		Parametrer parametrer = new Parametrer(jeu);
		jeu.add(parametrer);
	}

	public void lancer() {
		jeu.initialiser();
		jeu.setParametrerTermine(true);
		Game game = new Game(jeu);
		jeu.add(game);
		
		
		//derouler();
		
		// derouler();
	}
	
	public void fin() {
		Resultat res = new Resultat(jeu);
		jeu.add(res);
	}

	public void joueurPhysiquePiocher() {
		jeu.getJoueurActuel().piocher(jeu.getCarteDepuisTas());
		System.out.println("joueur physique pioche");
		jeu.getJoueurActuel().setTourTermine(true);

	}

	
	
	public void joueurPhysiquePoser(String id) {
		
		LinkedList<Carte> cartes = jeu.getJoueurActuel().getCartes();
		Iterator<Carte> it = cartes.iterator();
		Carte carteChoisie;
		while(it.hasNext()) {
			Carte c = it.next();
			if(c.getId()==id) {
				carteChoisie = c;
				jeu.getJoueurActuel().poserCarteChoisie(carteChoisie);
				jeu.setCarteActuelle(carteChoisie);
				System.out.println("Joueur physique pose "+c.toString());
				break;
			}
		}
		
		jeu.getJoueurActuel().setPose(true);
		jeu.getJoueurActuel().setTourTermine(true);
		
		
	}

	public void fermer(JFrame frame) {
		frame.setVisible(false);
	}

	public void setNbJeux(int nb) {
		jeu.setNombreDeJeux(nb);
	}

	public void setNbJoueur(int nb) {
		jeu.setNombreDeJoueurs(nb);
	}

	public void setDifficulte(int di) {
		jeu.setDifficulte(di);
	}

	public void setCompter(int c) {
		jeu.setMethodeCompte(c);
	}

	public void setAvecJoker(int avec) {
		jeu.setAvecJoker(avec);
	}

	public void setVariante(int variante) {
		jeu.setVariante(variante);
	}

}
