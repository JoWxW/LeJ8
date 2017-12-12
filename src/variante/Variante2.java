package variante;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import action.DireMaou;
import carte.Carte;
import effet.*;
import joueur.Joueur;

public class Variante2 extends Variante{
	
	public Variante2() {
		super();
		this.setNom("Variante2");
		this.setNumero("2");
	}

	@Override
	public void addEffet(LinkedList<Carte> tas,ArrayList<Joueur> joueurs) {
		ObligeRejouer obligeRejouer = new ObligeRejouer();
		PasserSonTour passerSonTour = new PasserSonTour();
		FairePiocher fairePiocher = new FairePiocher(2);
		ChangerForme changerCouleur = new ChangerForme();
		
		Iterator<Carte> it  = tas.iterator();
		while(it.hasNext()){
			Carte c = it.next();
			if (c.getEffet().size() == 0){
				switch(c.getValeur().getId()){
				case 10:
					c.addEffetVariante(obligeRejouer);
					break;
				case 8:
					c.addEffet(passerSonTour);
					break;
				case 7:
					c.addEffet(fairePiocher);
					break;
				case 11:
					c.addEffet(changerCouleur);
					break;
				}
			}
		}
		DireMaou direMaou = new DireMaou();
		Iterator<Joueur> ij = joueurs.iterator();
		while(ij.hasNext()) {
			Joueur jou = ij.next();
			jou.setMyAction(direMaou);
		}
		
		
		
	}

}
