package effet;

import java.util.LinkedList;

import carte.Carte;
import exception.SaisiNonValideException;
import jeu.Jeu;
import joueur.Joueur;

public class PiocherDeLaMain extends Effet{
	private int nbCarte;
	
	public PiocherDeLaMain() {
		super();
		this.setNom("Faire piocher " +nbCarte+" de mon jeu");
	}

	@Override
	public Jeu validerSuperpower(Jeu j) {
		if(j.getJoueurActuel().getCartes().size()==0) {
			return j;
		}
		LinkedList<Carte> myTasDeCarte = j.getJoueurActuel().getCartes();
		int position = (int)((myTasDeCarte.size()-1)*Math.random());
		Carte c = myTasDeCarte.get(position);
		myTasDeCarte.remove(c);
		j.renouvelerJouerActuel();
		Joueur jou = j.getJoueurActuel();
		jou.piocher(c);
		return j;
		
	}
	

}
