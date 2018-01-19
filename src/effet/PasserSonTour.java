/**
 * 
 */
package effet;

import carte.Carte;
import jeu.Jeu;
import joueur.Joueur;

/**
 * L'effet qui permet de faire le joueur suivant passer son tour*/
public class PasserSonTour extends Effet {

	public PasserSonTour() {
		super();
		this.setNom("Le joueur suivant passe son tour");
	}

	@Override
	public Jeu validerSuperpower(Jeu j) {
		this.declarer();
		j.renouvelerJouerActuel();
		return j;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
