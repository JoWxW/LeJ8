/**
 * 
 */
package effet;

import joueur.*;
import carte.*;
import exception.SaisiNonValideException;
import jeu.*;

/**
 * @author wxw
 *
 */
public class ObligeRejouer extends Effet {
	public ObligeRejouer() {
		super();
		this.setNom("Obliger a rejouer");
	}

	private Jeu jeu;
	private boolean continu = false;

	@Override
	public Jeu validerSuperpower(Jeu j) throws SaisiNonValideException {
		jeu = j;
		this.setActive(true);

		this.declarer();
		Joueur joueurActuel = j.getJoueurActuel();
		int nbCarte = joueurActuel.getCartes().size();
		if (nbCarte == 0) {
			Carte carte = j.getCarteDepuisTas();
			joueurActuel.piocher(carte);
		} else {
			Carte c = joueurActuel.poserUneCarte(joueurActuel.getCartes(), joueurActuel.getCartes());
			System.out.println(j.getJoueurActuel().toString() + " pose " + c.toString());
			j.setCarteActuelle(c);
			j.getTasDeCartePosee().addCartePosee(c);
			j = c.getEffectValide().validerSuperpower(j);
		}

		return j;
	}

	@Override
	public void run() {
		/*
		 * while (!this.isMort()) { while (!this.isActive()) { try { Thread.sleep(500);
		 * } catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } this.declarer(); Joueur joueurActuel =
		 * jeu.getJoueurActuel(); int nbCarte = joueurActuel.getCartes().size();
		 * 
		 * if (nbCarte == 0) { Carte carte = jeu.getCarteDepuisTas();
		 * joueurActuel.piocher(carte); } else { if (joueurActuel instanceof
		 * JoueurVirtuel) { Carte c; c =
		 * joueurActuel.poserUneCarte(joueurActuel.getCartes(),
		 * joueurActuel.getCartes());
		 * System.out.println(jeu.getJoueurActuel().toString() + " pose " +
		 * c.toString()); jeu.setCarteActuelle(c);
		 * jeu.getTasDeCartePosee().addCartePosee(c);
		 * 
		 * try { jeu = c.getEffectValide().validerSuperpower(jeu); } catch
		 * (SaisiNonValideException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } } else { while(!continu) { try { Thread.sleep(500); }
		 * catch (InterruptedException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * } Carte c = jeu.getCarteActuelle();
		 * 
		 * 
		 * } }
		 * 
		 * }
		 */
	}

}
