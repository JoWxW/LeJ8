/**
 * 
 */
package effet;

import jeu.Jeu;

/**
 * @author wxw
 *
 */
public class NonEffet extends Effet{
	public NonEffet(){
		super();
		this.setNom("Carte sans effet");
	}

	@Override
	public Jeu validerSuperpower(Jeu j) {
		//j.renouvelerJouerActuel();
		return j;
	}
}
