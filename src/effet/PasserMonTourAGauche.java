package effet;

import java.util.ArrayList;

import exception.SaisiNonValideException;
import jeu.Jeu;
import joueur.Joueur;

public class PasserMonTourAGauche extends Effet {
	public PasserMonTourAGauche() {
		super();
		this.setNom("Passer mon tour a gauche");
	}

	@Override
	public Jeu validerSuperpower(Jeu j) throws SaisiNonValideException {
		Joueur jou = j.getJoueurActuel();
		ArrayList<Joueur> joueurs = j.getJoueurs();
		int position = joueurs.indexOf(jou);
		if (position == 0) {
			position = joueurs.size() - 1;
		} else {
			position -= 1;
		}
		j.setJoueurActuel(joueurs.get(position));
		j.joueurJoueUnTour();
		return j;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}