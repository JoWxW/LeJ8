/**
 * 
 */
package effet;

import carte.Carte;
import jeu.Jeu;
import joueur.Joueur;

/**
 * @author wxw
 *
 */
public class PasserSonTour extends Effet{

	public PasserSonTour(){
		super();
		this.setNom("Le joueur suivant passe son tour");
	}
	
	@Override
	public Jeu validerSuperpower(Jeu j) {
		System.out.println("La carte a effectue son superpower:" + this.getNom());
		this.passeSonTour(j);
		return j;
	}
	
	public Jeu passeSonTour(Jeu j){
		j.renouvelerJouerActuel();
		j.renouvelerJouerActuel();
		return j;
	}

}
