package effet;

import exception.SaisiNonValideException;
import jeu.Jeu;

public class ChangerSensAvecRejouer extends ChangerSens {
	

	public ChangerSensAvecRejouer() {
		super();
		this.setNom("Changer de sens(rejouer s'il y a 2 joueurs)");
	}

	public Jeu validerSuperpower(Jeu j) {
		this.declarer();
		if (j.getJoueurs().size() > 2) {
			this.declarer();
			if (Jeu.isCroissante()) {
				Jeu.setCroissante(false);
			} else {
				Jeu.setCroissante(true);
			}
			return j;
		} else {
			ObligeRejouer o = new ObligeRejouer();
			
				j = o.validerSuperpower(j);
			
			return j;
			
			
		}
	}

}
