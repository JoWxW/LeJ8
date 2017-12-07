package joueur;

import carte.*;
import effet.Effet;

import exception.SaisiNonValideException;

import jeu.*;

import java.util.*;

public abstract class Joueur {

	private String id;
	private int point = 0;
	private String nom;
	private int place = 0;
	// carte a la main(diagramme de classe)
	private LinkedList<Carte> cartes = new LinkedList<Carte>();
	private LinkedList<Carte> carteCandidate = new LinkedList<Carte>();

	public Joueur() {
	}

	public Joueur(String id, String nom) {
		this.setId(id);
		this.setNom(nom);
	}

	// piocher une carte
	public void piocher(Carte j) {
		cartes.add(j);
	}

	// Verifier si le joueur a une carte correte a la main, retourne true s'il l'a
	// inutile?
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
	// dans ce cas, la carte precedante ne sera jamais une carte avec effet
	public LinkedList<Carte> getCarteCandidate(Carte c) {
		LinkedList<Carte> carteCandidate = new LinkedList<Carte>();
		Iterator<Carte> it = getCartes().iterator();
		while (it.hasNext()) {
			Carte maCarte = it.next();
			if (maCarte.getForme().equals(c.getForme()) || maCarte.getValeur().equals(c.getValeur())
					|| (!maCarte.getEffet().isEmpty())) {
				carteCandidate.add(maCarte);
			}
		}
		return carteCandidate;

	}

	// poser une carte, il faut redefinir dans la classe fille
	public void poser() {
	}

	//
	// methode abstrait??????
	//
	public abstract Carte poserUneCarte(LinkedList<Carte> carteCandidate, LinkedList<Carte> myCartes)
			throws SaisiNonValideException;

	// annoncer carte ou contre carte
	//
	public void annoncer() {
		System.out.println(this.toString()+ " annonce Carte");
	}

	// calculer le point en fonction de la facon de compter et retourner le point de
	// ce joueur
	// compte positif comme mode1,compte negatif comme mode0
	public int calculerPoint() {
		if (Jeu.getMethodeCompte() == 1) {
			if (place == 1) {
				point += 50;
			} else if (place == 2) {
				point += 20;
			} else if (place == 3) {
				point += 10;
			}
		} else if (Jeu.getMethodeCompte() == 0) {
			Iterator<Carte> it = cartes.iterator();
			while (it.hasNext()) {
				Carte myCarte = it.next();
				switch (myCarte.getValeur().getId()) {
				case 12:
				case 13:
					point += 10;
					break;
				case 3:
				case 4:
				case 5:
				case 6:
				case 9:
					point += myCarte.getValeur().getId();
					break;
				case 2:
				case 10:
				case 7:
					point += 20;
					break;
				case 1:
				case 8:
					point += 50;
					break;

				}

			}
		}
		return point;

	}

	public boolean aGagne() {
		//boolean res;
		if (cartes.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	// getter et setter et toString
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("Joueur ");
		s.append(this.nom);
		int nbCarte = this.cartes.size(); 
		//s.append(" id ");
		//s.append(this.id);
		s.append(" " + nbCarte);
		return s.toString();
	}

	/**
	 * @return the point
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * @param point the point to set
	 */
	public void setPoint(int point) {
		this.point = point;
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

	public void setPlace(int i) {
		this.place = i;
	}

	public int getPlace() {
		return this.place;
	}

}
