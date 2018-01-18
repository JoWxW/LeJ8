package controller;

import java.util.Iterator;
import java.util.LinkedList;

import carte.Carte;
import effet.Effet;
import effet.FairePiocher;
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

	public void joueurPhysiquePiocher() {
		if (!jeu.getEffetEnAttente().isEmpty()) {
			Effet effetTop = jeu.getEffetEnAttente().get(0);
			if (effetTop instanceof FairePiocher) {
				for (int i = 0; i < jeu.getNbCartePiocher(); i++) {
					jeu.getJoueurActuel().piocher(jeu.getCarteDepuisTas());
				}
				System.out.println("joueur physique pioche " + jeu.getNbCartePiocher() + " cartes");
				effetTop.setaPioche(true);
				effetTop.setContinu(true);
			} else {
				jeu.getJoueurActuel().piocher(jeu.getCarteDepuisTas());
				effetTop.setaPioche(true);
				effetTop.setContinu(true);
			}
		}

	}

}
