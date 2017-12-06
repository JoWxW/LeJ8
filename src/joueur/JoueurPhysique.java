package joueur;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import carte.*;
import effet.Effet;
import exception.*;
import jeu.*;

public class JoueurPhysique extends Joueur {

	public JoueurPhysique() {
	}

	public JoueurPhysique(String id, String nom) {
		super(id, nom);
		// TODO Auto-generated constructor stub
	}

	public void arreter(Jeu j) throws JeuDejaArreteException {
		if (j.isJeuEnCours()) {
			j.setJeuEnCours(false);
		} else {
			throw new JeuDejaArreteException("Le jeu est deja arrete");
		}

	}

	// ce methode est inutile?
	public void parametrer() {

	}

	public Carte poserUneCarte(LinkedList<Carte> carteCandidate, LinkedList<Carte> myCartes)
			throws SaisiNonValideException {
		listerCarteCandidate(carteCandidate);
		//Scanner scanner = new Scanner(System.in);
		System.out.println("Choisissez une carte a jouer(numero)");
		
		// get index par utilisateur(Exception pour une valeur non entier)
		
		int position = Jeu.getScanner().nextInt();
		//scanner.close();
		// ajouter une exception ou pas
		if (position >= 0 && position <= carteCandidate.size() - 1) {
			// out.close();
			Carte carteChoisie = carteCandidate.get(position);
			myCartes.remove(carteChoisie);
			if (!(carteChoisie.getEffet().size() == 0)) {
				Effet effetValide = choisirEffet(carteChoisie);
				carteChoisie.setEffectValide(effetValide);
				return carteChoisie;

			} else {
				return carteChoisie;
			}
		} else {
			throw new SaisiNonValideException("Maivais saisi");

		}

	}
	
	public Effet choisirEffet(Carte carteChoisie) {
		System.out.println("Cette carte a plusieurs effets");
		Iterator<Effet> ie = carteChoisie.getEffet().iterator();
		StringBuffer info = new StringBuffer();
		info.append("Les effects a choisir:  ");
		int j = 0;
		while (ie.hasNext()) {
			Effet e = ie.next();
			info.append("[n.");
			info.append(j);
			info.append(" ");
			info.append(e.toString());
			info.append(" ]  ");
			j++;
		}
		System.out.println(info.toString());
		System.out.println("Veuillez choisir un effet(numero)");
		//il faut verifier le saisi
		int n = Jeu.getScanner().nextInt();
		Effet effetValide = carteChoisie.getEffet().get(n);
		return effetValide;
		
	}
	
	public void listerCarteCandidate(LinkedList<Carte> carteCandidate) {
		Iterator<Carte> it = carteCandidate.iterator();
		StringBuffer s = new StringBuffer();
		s.append("Vos carte jouable:  ");
		int i = 0;
		while (it.hasNext()) {
			s.append("[n.");
			s.append(i);
			s.append(" ");
			Carte carte = it.next();
			s.append(carte.toString());
			s.append(" ]  ");
			i++;
		}
		System.out.println(s.toString());
		
	}
	

}
