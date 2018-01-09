package controller;

import java.util.Iterator;
import java.util.LinkedList;

import carte.Carte;
import effet.Effet;
import jeu.Jeu;

public class EffetControleur {

	private Jeu jeu;

	public EffetControleur(Jeu j) {
		jeu = j;
	}

	public void effetContinu() {
		Effet effetTop = jeu.getEffetEnAttente().get(0);
		effetTop.setContinu(true);
	}

	public void joueurPhysiquePoser(String id) {
		if (!jeu.getEffetEnAttente().isEmpty()) {
			LinkedList<Carte> cartes = jeu.getJoueurActuel().getCartes();
			Iterator<Carte> it = cartes.iterator();
			Carte carteChoisie;
			while (it.hasNext()) {
				Carte c = it.next();
				if (c.getId() == id) {
					carteChoisie = c;
					jeu.getJoueurActuel().poserCarteChoisie(carteChoisie);
					jeu.setCarteActuelle(carteChoisie);
					jeu.getTasDeCartePosee().addCartePosee(carteChoisie);
					break;
				}
			}
			Effet effetTop = jeu.getEffetEnAttente().get(0);
			effetTop.setContinu(true);
			
		}

	}

}
