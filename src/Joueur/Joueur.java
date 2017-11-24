package Joueur;
import carte.*;
import java.util.*;

public class Joueur {

	private String id;
	private int point = 0;
	private String nom;
	private int place;
	// carte a la main(改一下diagramme de classe)
	private LinkedList<Carte> cartes = new LinkedList<Carte>();

	// piocher une carte et retouner la carte au jeux
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
		Iterator<Carte> it = cartes.iterator();
		while (it.hasNext()) {
			Carte maCarte = it.next();
			if (maCarte.getForme().equals(c.getForme()) || maCarte.getValeur().equals(c.getValeur())) {
				carteCandidate.add(maCarte);
			}
		}
		return carteCandidate;
	}

	// poser une carte, il faut redefinir dans la classe fille
	public void poser() {
	}

	// annoncer carte ou contre carte
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
				if (myCarte.getValeur().equals(12) || myCarte.getValeur().equals(13)) {
					point += 10;
				} else if (myCarte.getValeur().equals(9) || myCarte.getValeur().equals(6)
						|| myCarte.getValeur().equals(5) || myCarte.getValeur().equals(4)
						|| myCarte.getValeur().equals(3)) {
					// valeur 的类型还是设置成int比较合适
					// point += myCarte.getValeur();
				} else if (myCarte.getValeur().equals(10) || myCarte.getValeur().equals(7)
						|| myCarte.getValeur().equals(2)) {
					point += 20;
				} else if (myCarte.getValeur().equals(1) || myCarte.getValeur().equals(8)) {
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

}
