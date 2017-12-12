/**
 * 
 */
package effet;

import exception.SaisiNonValideException;
import jeu.Jeu;

public class ChangerSens extends Effet {

	public ChangerSens() {
		super();
		this.setNom("Changer le sens du jeu");
	}

	@Override
	public Jeu validerSuperpower(Jeu j)  {
		this.declarer();
		if (Jeu.isCroissante()) {
			Jeu.setCroissante(false);
		} else {
			Jeu.setCroissante(true);
		}
		return j;
	}

}
