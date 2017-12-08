/**
 * 
 */
package effet;

import exception.SaisiNonValideException;
import jeu.Jeu;

/**
 * @author wxw
 *
 */
public class ChangerFormeArreterAttaque extends Effet {
	public ChangerFormeArreterAttaque() {
		super();
		this.setNom("Changer de forme et arr¨ºte les attaques");
	}

	@Override
	public Jeu validerSuperpower(Jeu j) throws SaisiNonValideException {
		this.declarer();
		ArreterAttaque aa = new ArreterAttaque();
		j = aa.validerSuperpower(j);
		ChangerForme cf = new ChangerForme();
		j = cf.validerSuperpower(j);
		return j;
	}
}
