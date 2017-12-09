/**
 * 
 */
package effet;

import java.util.Iterator;
import java.util.LinkedList;

import carte.Carte;
import exception.SaisiNonValideException;
import jeu.Jeu;
import joueur.Joueur;

/**
 * @author wxw
 *
 */
public class FairePiocherOuMeme extends FairePiocher{
	public FairePiocherOuMeme(int nbCarte){
		super(nbCarte);
		this.setNom("Faire piocher " + nbCarte + " cartes �� moins que poser une autre carte de m��me valeur");
	}
	
	public Jeu validerSuperpower(Jeu j) throws SaisiNonValideException {
		this.declarer();
		int nbPiocher = j.getNbCartePiocher() + this.getNbCarte();
		j.setNbcartePiocher(nbPiocher);
		j.renouvelerJouerActuel();
		Joueur jou = j.getJoueurActuel();
		Carte ca = j.getCarteActuelle();
		LinkedList<Carte> carteCandidate = new LinkedList<Carte>();
		LinkedList<Carte> carteDeJoueur = jou.getCartes();
		Iterator<Carte> it = carteDeJoueur.iterator();
		while (it.hasNext()) {
			Carte c = it.next();
			if(c.getValeur() == ca.getValeur()||c.getValeur().getId()==8){
				carteCandidate.add(c);
			}
		}
		if (carteCandidate.isEmpty()) {
			System.out.println(jou.toString() + " doit piocher " + j.getNbCartePiocher() + " cartes");
			/*
			 * if (!(j.aAssezDeCarte())) { j.renouvelerTasDeCarteEnattente(); } for (int i =
			 * 0; i < j.getNbCartePiocher(); i++) { jou.piocher(j.getCarteDepuisTas()); }
			 */
			j.joueurPiocher(nbPiocher);
			j.setNbcartePiocher(0);

		} else {
			Carte c = jou.poserUneCarte(carteCandidate, jou.getCartes());
			// jou.getCartes().remove(c);
			j.setCarteActuelle(c);
			j.getTasDeCartePosee().addCartePosee(c);
			j = c.getEffectValide().validerSuperpower(j);

		}
		// j.renouvelerJouerActuel();
		return j;
	}
}
