/**
 * 
 */
package effet;

import exception.SaisiNonValideException;
import jeu.Jeu;

public class ChangerSens extends Effet{
	
	public ChangerSens() {
		super();
		this.setNom("Changer le sens du jeu");
	}

	@Override
	public Jeu validerSuperpower(Jeu j) {
		System.out.println("La carte a effectue son superpower:" + this.getNom());
		if(Jeu.isCroissante()) {
			Jeu.setCroissante(false);
		}else {
			Jeu.setCroissante(true);
		}
		return j;
	}

}
