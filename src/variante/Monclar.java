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
		ObligeRejouer obligeRejouer = new ObligeRejouer();
		PasserSonTour passerSonTour = new PasserSonTour();
		ChangerSens changerSens = new ChangerSens();
		FairePiocherSansRecours fairePiocherSansRecours = new FairePiocherSansRecours(1);
		FairePiocher fairePiocher = new FairePiocher(3);
		ChangerFormeArreterAttaque changerFormeArreterAttaque = new ChangerFormeArreterAttaque();

		Iterator<Carte> it = tas.iterator();
		while (it.hasNext()) {
			Carte c = it.next();
			if (c.getEffet().size() == 0) {
				switch (c.getValeur().getId()) {
				case 10:
					c.addEffetVariante(obligeRejouer);
					break;
				case 7:
					c.addEffetVariante(passerSonTour);
					break;
				case 11:
					c.addEffetVariante(changerSens);
					break;
				case 9:
					c.addEffetVariante(fairePiocherSansRecours);
					break;
				case 1:
					c.addEffetVariante(fairePiocher);
					break;
				case 8:
					c.addEffetVariante(changerFormeArreterAttaque);
					break;

				}
			}
		}
	}
}
