/**
 * 
 */
package variante;

import java.util.ArrayList;
import java.util.LinkedList;

import carte.Carte;
import joueur.Joueur;

/**
 * @author wxw
 *
 */
public abstract class Variante {
	private String nom;
	private String numero;

	/**
	 * @param nom
	 * @param numero
	 */
	public Variante(String nom, String numero) {
		this.nom = nom;
		this.numero = numero;
	}

	public Variante() {
	}

	public abstract void addEffet(LinkedList<Carte> tas,ArrayList<Joueur> joueurs);

	/**
	 * @return the nom
	 */
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

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

}
