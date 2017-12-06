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
		this.setNom("Obliger a rejouer");
	}
	
	@Override
	public Jeu validerSuperpower(Jeu j) {
		System.out.println("La carte a effectue son superpower:Obliger a rejouer!");
		Joueur joueurActuel = j.getJoueurActuel();
		int nbCarte = joueurActuel.getCartes().size();
		if(nbCarte == 0){
			Carte carte = j.getCarteDepuisTas();
			joueurActuel.piocher(carte);
		}
		return j;
	}
	
	/*public String toString() {
		return "Obliger a rejouer";
	}*/
}
