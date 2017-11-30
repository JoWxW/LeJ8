package joueur;

import carte.*;
import effet.Effet;

import java.util.*;

public class Joueur {

	private String id;
	private int point = 0;
	private String nom;
	private int place;
	// carte a la main(¸ÄÒ»ÏÂdiagramme de classe)
	private LinkedList<Carte> cartes = new LinkedList<Carte>();

	// piocher une carte
	public void piocher(Carte j) {
		cartes.add(j);
	}

	// Verifier si le joueur a une carte correte a la main, retourne true s'il l'a
	public boolean aCarteCorrecte(Carte c) {
		Iterator<Carte> it = cartes.iterator();
		boolean res = false;
		while (it.hasNext()) {
			Carte maCarte = it.next();
			if (maCarte.getForme().equals(c.getForme()) || maCarte.getValeur().equals(c.getValeur())) {
				res = true;
				break;
			}
		}
		return res;
	}

	// get les carte candidates pour ce tour par rapport a la carte preccedante
	public LinkedList<Carte> getCarteCandidate(Carte c) {
		LinkedList<Carte> carteCandidate = new LinkedList<Carte>();
		Iterator<Carte> it = getCartes().iterator();
		if (c.getEffet().isEmpty()) {
			while (it.hasNext()) {
				Carte maCarte = it.next();
				if (maCarte.getForme().equals(c.getForme()) || maCarte.getValeur().equals(c.getValeur())
						|| (!maCarte.getEffet().isEmpty())) {
					carteCandidate.add(maCarte);
				}
			}
		} else {
			Carte maCarte = it.next();
			Iterator<Effet> ie = maCarte.getEffet().iterator();
			while (ie.hasNext()) {
				Effet myEffet = ie.next();
				if (myEffet.getCarteAttaque() >= c.getEffectValide().getCarteAttaque()) {
					carteCandidate.add(maCarte);
				}
			}

		}
		return carteCandidate;

	}

	// poser une carte, il faut redefinir dans la classe fille
	public void poser() {
	}

	public void poser(Carte cartePrecedante, LinkedList<Carte> cartes) {
	}

	// annoncer carte ou contre carte
	//
	public boolean annoncer() {
		System.out.println("Contre");
		boolean aAnnonce = true;
		return aAnnonce;

	}

	// calculer le point en fonction de la facon de compter et retourner le point de
	// ce joueur
	// compte positif comme mode1,compte negatif comme mode2
	public int calculerPoint(int modeDeCompter) {
		if (modeDeCompter == 1) {
			if (place == 1) {
				point += 50;
			} else if (place == 2) {
				point += 20;
			} else if (place == 3) {
				point += 10;
			}
		} else if (modeDeCompter == 2) {
			Iterator<Carte> it = cartes.iterator();
			while (it.hasNext()) {
				Carte myCarte = it.next();
				switch (myCarte.getValeur().getId()) {
				case 12:
				case 13:
					point += 10;
				case 3:
				case 4:
				case 5:
				case 6:
				case 9:
					point += myCarte.getValeur().getId();
				case 2:
				case 10:
				case 7:
					point += 20;
				case 1:
				case 8:
					point += 50;

				}

			}
		}
		return point;

	}

	// getter et setter et toString
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("Joueur ");
		s.append(this.nom);
		s.append(" id ");
		s.append(this.id);
		return s.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public LinkedList<Carte> getCartes() {
		return this.cartes;
	}

}
