package effet;

import java.util.Iterator;
import java.util.LinkedList;

import carte.Carte;
import exception.SaisiNonValideException;
import jeu.Jeu;
import joueur.Joueur;

public class SecretDeRoiEtDame extends Effet {

	public SecretDeRoiEtDame() {
		super();
		this.setNom("Effet sur n'importe quelle Dame ou Roi");
	}

	@Override
	public Jeu validerSuperpower(Jeu j) throws SaisiNonValideException {
		Joueur jou = j.getJoueurActuel();
		// LinkedList<Carte> aPoser = new LinkedList<Carte>();
		LinkedList<Carte> myCartes = jou.getCartes();
		Iterator<Carte> it = myCartes.iterator();
		while (it.hasNext()) {
			Carte c = it.next();
			if (c.getValeur().getId() == 12 || c.getValeur().getId() == 13) {
				it.remove();
				j.getTasDeCartePosee().addCartePosee(c);
				System.out.println(jou.toString() + " pose " + c.toString());
			}
		}
		return j;

		/*
		 * j.renouvelerJouerActuel(); Joueur jou = j.getJoueurActuel(); Carte cartePosee
		 * = j.getCarteActuelle(); LinkedList<Carte> myCarte; myCarte =
		 * jou.getCarteCandidate(j.getCarteActuelle()); Iterator<Carte> it =
		 * jou.getCartes().iterator(); while (it.hasNext()) { Carte c = it.next(); if
		 * (cartePosee.getValeur().getId() == 12) { if (c.getValeur().getId() == 13) {
		 * myCarte.add(c); } } else if (cartePosee.getValeur().getId() == 13) { if
		 * (c.getValeur().getId() == 12) { myCarte.add(c); }
		 * 
		 * } } // yongxinde methode gaidiao Carte carteChoisie =
		 * jou.poserUneCarte(myCarte, jou.getCartes());
		 * jou.getCartes().remove(carteChoisie); j =
		 * carteChoisie.getEffectValide().validerSuperpower(j);
		 * 
		 * return j;
		 */
	}

}
