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
		Joueur joueurActuel = j.getJoueurActuel();
		int nbCarte = joueurActuel.getCartes().size();
		if(nbCarte == 0){
			Carte carte = j.getCarteDepuisTas();
			joueurActuel.piocher(carte);
		}
		return j;
	}
	
	public Jeu passeSonTour(Jeu j){
		return j;
	}
}
