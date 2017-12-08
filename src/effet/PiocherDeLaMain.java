package effet;

import java.util.LinkedList;

import carte.Carte;
import exception.SaisiNonValideException;
import jeu.Jeu;
import joueur.Joueur;
//par defaut piocher une carte
public class PiocherDeLaMain extends Effet {
	private int nbCarte;

	public PiocherDeLaMain() {
		super();
		this.setNom("Faire piocher " + nbCarte + " de mon jeu");
	}
	
	public PiocherDeLaMain(int i) {
		super();
		this.setNom("Faire piocher " + nbCarte + " de mon jeu");
		this.setNbCarte(i);
	}

	@Override
	public Jeu validerSuperpower(Jeu j) {
		if (j.getJoueurActuel().getCartes().size() == 0) {
			return j;
		}
		LinkedList<Carte> myTasDeCarte = j.getJoueurActuel().getCartes();
		int position = (int) ((myTasDeCarte.size() - 1) * Math.random());
		Carte c = myTasDeCarte.get(position);
		myTasDeCarte.remove(c);
		j.renouvelerJouerActuel();
		Joueur jou = j.getJoueurActuel();
		jou.piocher(c);
		return j;

	}
	
	public void setNbCarte(int i) {
		this.nbCarte = i;
	}

}
