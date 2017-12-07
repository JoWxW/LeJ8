/**
 * 
 */
package effet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import carte.Carte;
import exception.SaisiNonValideException;
//import joueur.*;
//import carte.*;
import jeu.*;
import joueur.Joueur;

/**
 * @author wxw
 *
 */
public class FairePiocher extends Effet {
	private int nbCarte;

	public FairePiocher(int nbCarte) {
		super();
		this.nbCarte = nbCarte;
		this.setNom("Faire piocher" + nbCarte + " cartes");
	}

	public void effectuer(Jeu j) {
		int nbPiocher = j.getNbCartePiocher() + this.nbCarte;
		j.setNbcartePiocher(nbPiocher);
	}

	// pas encore ajouer crazy8 pour annuler les attaques
	@Override
	public Jeu validerSuperpower(Jeu j) throws SaisiNonValideException {
		System.out.println("La carte a effectue son superpower: Faire piocher!");
		int nbPiocher = j.getNbCartePiocher() + this.nbCarte;
		j.setNbcartePiocher(nbPiocher);
		j.renouvelerJouerActuel();
		Joueur jou = j.getJoueurActuel();
		LinkedList<Carte> carteCandidate = new LinkedList<Carte>();
		LinkedList<Carte> carteDeJoueur = jou.getCartes();
		Iterator<Carte> it = carteDeJoueur.iterator();
		while (it.hasNext()) {
			Carte c = it.next();
			ArrayList<Effet> effets = c.getEffet();
			Iterator<Effet> ie = effets.iterator();
			while (ie.hasNext()) {
				Effet e = ie.next();
				if (e instanceof FairePiocher) {
					carteCandidate.add(c);
				}
			}
		}
		if (carteCandidate.isEmpty()) {
			System.out.println(jou.toString() + " doit piocher " + j.getNbCartePiocher() + " cartes");
			/*if (!(j.aAssezDeCarte())) {
				j.renouvelerTasDeCarteEnattente();
			}
			for (int i = 0; i < j.getNbCartePiocher(); i++) {
				jou.piocher(j.getCarteDepuisTas());
			}*/
			j.setNbcartePiocher(0);

		} else {
			Carte c = jou.poserUneCarte(carteCandidate, jou.getCartes());
			jou.getCartes().remove(c);
			j.setCarteActuelle(c);
			j.getTasDeCartePosee().addCartePosee(c);
			j = c.getEffectValide().validerSuperpower(j);

		}
		j.renouvelerJouerActuel();
		return j;
	}

	/*
	 * public String toString() { return "Faire piocher"; }
	 */
}
