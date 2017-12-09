/**
 * 
 */
package variante;

import carte.*;
import effet.*;
import java.util.*;

/**
 * @author wxw
 *
 */
public class Minimale extends Variante {
	public Minimale() {
		super();

		this.setNom("Version Minimale");
		this.setNumero("0");
	}

	public void addEffet(LinkedList<Carte> tas) {
		FairePiocher fairePiocher = new FairePiocher(2);
		ObligeRejouer obligeRejouer = new ObligeRejouer();
		ChangerForme changerforme = new ChangerForme();
		//NonEffet nonEffet = new NonEffet();
		Iterator<Carte> it = tas.iterator();
		while (it.hasNext()) {
			Carte c = it.next();
			if (c.getEffet().size() == 0) {
				switch (c.getValeur().getId()) {
				case 2:
					c.addEffet(fairePiocher);
					c.setEffectValide(fairePiocher);
					break;
				case 8:
					c.addEffet(changerforme);
					c.setEffectValide(changerforme);
					break;
				case 10:
					c.addEffet(obligeRejouer);
					c.setEffectValide(obligeRejouer);
					break;
				}
			}
		}
	}
}
