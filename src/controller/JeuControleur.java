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

	public void joueurPhysiquePiocher() {
		jeu.getJoueurActuel().piocher(jeu.getCarteDepuisTas());
		System.out.println("joueur physique pioche");
		jeu.renouvelerJouerActuel();
		jeu.getJoueurActuel().setPose(true);

	}

	public void derouler() {

		while (!jeu.jeuTermine()) {

			Iterator<Joueur> it = jeu.getJoueurs().iterator();
			while (it.hasNext()) {
				Joueur j = it.next();
				if (j.aGagne()) {
					jeu.getJoueursGagne().add(j);
					it.remove();
				}
			}
			if (jeu.getJoueurs().size() == 1) {
				jeu.getJoueursGagne().add(jeu.getJoueurs().get(0));
				break;
			}
			if (jeu.getTasDeCarteEnAttente().getTailleDeTas() > 0) {
				if (jeu.getJoueurActuel() instanceof JoueurPhysique) {
					/*jeu.getJoueurActuel().setPose(false);
					while (!jeu.getJoueurActuel().getPose()) {
						try {
							Thread.yield();
							Thread.sleep(500);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
					try {
						jeu.getCarteActuelle().getEffectValide().validerSuperpower(jeu);
					} catch (SaisiNonValideException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					*/

				} else {
					jeu.joueurJoueUnTour();
				}
				jeu.renouvelerJouerActuel();
			} else {
				jeu.renouvelerTasDeCarteEnattente();

			}
		}
		jeu.compterPoint();
		Jeu.getScanner().close();
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
				try {
					carteChoisie.getEffectValide().validerSuperpower(jeu);
				} catch (SaisiNonValideException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
		
		
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
