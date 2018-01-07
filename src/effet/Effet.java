/**
 * 
 */
package effet;

import java.util.Observable;

import exception.SaisiNonValideException;
import jeu.Jeu;

/**
 * @author wxw
 *
 */
public abstract class Effet extends Observable implements Runnable{
	private String nom;
	// 加了一个attaque的牌数，便于统计，如果有更好的解决办法再删掉
	private int carteAttaque;
	private boolean active = false;
	private boolean mort = false;

	
	public Effet() {
	}

	/**
	 * @param nom
	 * @throws SaisiNonValideException
	 */

	public abstract Jeu validerSuperpower(Jeu j) throws SaisiNonValideException;

	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCarteAttaque() {
		return carteAttaque;
	}

	public void setCarteAttaque(int carteAttaque) {
		this.carteAttaque = carteAttaque;
	}

	public String toString() {
		return this.nom;
	}

	public void declarer() {
		System.out.println("La carte a effectue son superpower: " + this.nom + " !");
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isMort() {
		return mort;
	}

	public void setMort(boolean mort) {
		this.mort = mort;
	}
}
