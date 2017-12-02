/**
 * 
 */
package effet;
import joueur.*;
import carte.*;
import jeu.*;

/**
 * @author wxw
 *
 */
public class ObligeRejouer extends Effet{
	public ObligeRejouer(){
		super();
		this.setNom("Obliger ид rejouer");
	}
	public void effectuer(Jeu j){
		Joueur joueurActuel = j.getJoueurActuel();
		int nbCarte = joueurActuel.getCartes().size();
		if(nbCarte == 0){
			Carte carte = j.getCarteDepuisTas();
			joueurActuel.piocher(carte);
		}
	}
}
