/**
 * 
 */
package effet;
//import joueur.*;
//import carte.*;
import jeu.*;

/**
 * @author wxw
 *
 */
public class FairePiocher extends Effet{
	private int nbCarte;
	public FairePiocher(int nbCarte){
		super();
		this.nbCarte = nbCarte;
		this.setNom("Faire piocher" + nbCarte + " cartes");
	}
	public void effectuer(Jeu j){
		j.setNbcartePiocher(nbCarte);
	}
}
