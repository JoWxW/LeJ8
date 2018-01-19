/**
 * 
 */
package effet;

import exception.SaisiNonValideException;
import jeu.Jeu;
/**L'effet qui change le sens de jeu*/
public class ChangerSens extends Effet {
	
	/**Constructeur de classe*/
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
