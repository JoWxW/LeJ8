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
public class passeSonTour extends Effet{
	private int[] precondition;
	private boolean croissant;
	public passeSonTour(){
		super();
		this.setNom("Passe son tour");
		this.precondition = null;
		this.croissant = true;
	}
	
	@Override
	public Jeu validerSuperpower(Jeu j) {
		System.out.println("La carte a effectue son superpower:" + this.getNom());
		
		return j;
	}
	
	public Jeu passeSonTour(Jeu j){
		j.renouvelerJouerActuel();
		j.renouvelerJouerActuel();
		return j;
	}


	public int[] getPrecondition() {
		return precondition;
	}


	public void setPrecondition(int[] precondition) {
		this.precondition = precondition;
	}


	public boolean isCroissant() {
		return croissant;
	}


	public void setCroissant(boolean croissant) {
		this.croissant = croissant;
	}
}
