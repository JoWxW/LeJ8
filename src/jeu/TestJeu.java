package jeu;

import java.util.*;

import carte.Carte;
import exception.*;
import joueur.Joueur;

public class TestJeu {
	public static void main(String[] args) {
		Jeu jeu;
		jeu = Jeu.getJeu();
		jeu.paramtrerJeu();
		System.out.println(Jeu.getAvecJoker() + " " + Jeu.getNombreDeJeux() + " " + Jeu.getNombreDeJoueurs());
		jeu.initialiser();
		int nb = 1;

		while ((!jeu.jeuTermine())) {
			if (jeu.getTasDeCarteEnAttente().getTailleDeTas() > 0) {
				System.out.println(" ");
				System.out.println("C'est le tour " + nb);
				nb++;
				LinkedList<Carte> carteCandidate = jeu.getJoueurActuel().getCarteCandidate(jeu.getCarteActuelle());
				if (carteCandidate.size() == 0) {
					jeu.getJoueurActuel().piocher(jeu.getCarteDepuisTas());
					System.out.println(jeu.getJoueurActuel().toString() + " pioche");
					jeu.renouvelerJouerActuel();
				} else {
					try {
						// verifier si la carte est bonne(pas besoin alors)
						Carte c = jeu.getJoueurActuel().poserUneCarte(carteCandidate,
								jeu.getJoueurActuel().getCartes());
						//jeu.getJoueurActuel().getCartes().remove(c);
						System.out.println(jeu.getJoueurActuel().toString() + " pose " + c.toString());
						jeu.setCarteActuelle(c);
						jeu.getTasDeCartePosee().addCartePosee(c);
						jeu = c.getEffectValide().validerSuperpower(jeu);

					} catch (SaisiNonValideException e) {
						e.printStackTrace();

					}
				}
			} else {
				jeu.getTasDeCarteEnAttente().addCartesPosees(jeu.getTasDeCartePosee());
				jeu.getTasDeCartePosee().clearCartePosee();

			}
			jeu.annoncer();
			System.out.println("nombre en attente"+jeu.getTasDeCarteEnAttente().getTailleDeTas());
			System.out.println("nombre de carte posee" + jeu.getTasDeCartePosee().getCartePosee().size());
		}
		jeu.afficherResultat();
		jeu.compterPoint();
		Jeu.getScanner().close();

		//jeu.initialiserJeu();
		//System.out.println(jeu.get);

	}
}
