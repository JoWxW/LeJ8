package effet;

import java.util.ArrayList;

import exception.SaisiNonValideException;
import jeu.Jeu;
import joueur.Joueur;

public class PasserMonTourAGauche extends Effet{

	@Override
	public Jeu validerSuperpower(Jeu j) throws SaisiNonValideException {
		Joueur jou = j.getJoueurActuel();
		ArrayList<Joueur> joueurs = j.getJoueurs();
		int position = joueurs.indexOf(jou);
		if(position == 0) {
			position = joueurs.size()-1;
		}else {
			position -=1;
		}
		j.setJoueurActuel(joueurs.get(position));
		return j;
		
	}
	

}
