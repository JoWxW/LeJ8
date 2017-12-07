/**
 * 
 */
package effet;
import joueur.*;
import carte.*;
import exception.SaisiNonValideException;
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
	public Jeu validerSuperpower(Jeu j) throws SaisiNonValideException {
		this.declarer();
		Joueur joueurActuel = j.getJoueurActuel();
		int nbCarte = joueurActuel.getCartes().size();
		if(nbCarte == 0){
			Carte carte = j.getCarteDepuisTas();
			joueurActuel.piocher(carte);
		}else{
			joueurActuel.poserUneCarte(joueurActuel.getCartes(), joueurActuel.getCartes());
		}
		return j;
	}
}
