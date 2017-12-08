/**
 * 
 */
package variante;

import java.util.Iterator;
import java.util.LinkedList;

import carte.Carte;
import effet.*;

/**
 * @author wxw
 *
 */
public class Monclar extends Variante {
	public Monclar() {
		super();

		this.setNom("Version Monclar");
		this.setNumero("11");
	}

	public void addEffet(LinkedList<Carte> tas) {
		Effet obligeRejouer = new ObligeRejouer();
		Effet passerSonTour = new PasserSonTour();
		Effet changerSens = new ChangerSens();
		Effet fairePiocherSansRecours = new FairePiocherSansRecours(1);
		Effet fairePiocher = new FairePiocher(3);
		Effet changerFormeArreterAttaque = new ChangerFormeArreterAttaque();

		Iterator<Carte> it = tas.iterator();
		while (it.hasNext()) {
			Carte c = it.next();
			if (c.getEffet().size() == 0) {
				switch (c.getValeur().getId()) {
				case 10:
					c.addEffet(obligeRejouer);
					c.setEffectValide(obligeRejouer);
					break;
				case 7:
					c.addEffet(passerSonTour);
					c.setEffectValide(passerSonTour);
					break;
				case 11:
					c.addEffet(changerSens);
					c.setEffectValide(changerSens);
					break;
				case 9:
					c.addEffet(fairePiocherSansRecours);
					c.setEffectValide(fairePiocherSansRecours);
					break;
				case 1:
					c.addEffet(fairePiocher);
					c.setEffectValide(fairePiocher);
					break;
				case 8:
					c.addEffet(changerFormeArreterAttaque);
					c.setEffectValide(changerFormeArreterAttaque);
					break;

				}
			}
		}
	}
}
