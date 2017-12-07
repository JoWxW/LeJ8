package effet;

import java.util.Iterator;
import java.util.LinkedList;

import carte.Carte;
import exception.SaisiNonValideException;
import jeu.Jeu;
import joueur.Joueur;

public class SecretDeRoiEtDame extends Effet{

	@Override
	public Jeu validerSuperpower(Jeu j) throws SaisiNonValideException {
		Joueur jou = j.getJoueurActuel();
		LinkedList<Carte> myCarte;
		myCarte = jou.getCarteCandidate(j.getCarteActuelle());
		Iterator<Carte> it = jou.getCartes().iterator();
		while(it.hasNext()) {
			Carte c = it.next();
			if(c.getValeur().getId()==12||c.getValeur().getId()==13) {
				myCarte.add(c);
			}
		}
		//yongxinde methode gaidiao
		Carte carteChoisie = jou.poserUneCarte(myCarte, jou.getCartes());
		jou.getCartes().remove(carteChoisie);
		j = carteChoisie.getEffectValide().validerSuperpower(j);
		
		
		
		return j;
	}
	

}
