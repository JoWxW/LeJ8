/**
 * 
 */
package effet;

import enumeration.Forme;
import jeu.Jeu;

/**
 * @author wxw
 *
 */
public class ChangerForme extends Effet{
	

	@Override
	public Jeu validerSuperpower(Jeu j) {
		System.out.println("La carte a effectue son superpower: Changer de forme!");
		int couleur = (int)(Math.random()*(Forme.size-1));
		while(j.getCarteActuelle().getForme().getId()==couleur) {
			couleur = (int)(Math.random()*(Forme.size-1));
		}
		j.getCarteActuelle().setForme(Forme.values()[couleur]);
		j.renouvelerJouerActuel();
		return j;
		
		
	}
	
	public String toString() {
		return "Changer Forme";
	}
}
