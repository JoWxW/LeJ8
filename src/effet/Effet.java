/**
 * 
 */
package effet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import exception.SaisiNonValideException;
import jeu.Jeu;

/**
 * @author wxw
 *
 */
public abstract class Effet extends Observable implements Runnable {
	private String nom;
	// ����һ��attaque������������ͳ�ƣ�����и��õĽ���취��ɾ��
	private int carteAttaque;
	private boolean active = false;
	private boolean mort = false;
	private boolean continu = false;
	private boolean changed =false;
	private ArrayList<Observer> observers;

	public Effet() {
		setObservers(new ArrayList<Observer>());
	}

	/**
	 * @param nom
	 * @throws SaisiNonValideException
	 */

	public abstract Jeu validerSuperpower(Jeu j);

	public void add(Observer o) {
		observers.add(o);
	}
	
	public void notifyObservers(Object arg) {
		if (!changed) {
			return;
		}
		Iterator<Observer> it = observers.iterator();
		while (it.hasNext()) {
			Observer o = it.next();
			o.update(this, arg);
		}
		this.clearChanged();

	}
	
	public void clearChanged() {
		this.changed = false;
	}
	
	public void setChanged(boolean b) {
		this.changed=b;
	}

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
		//this.setChanged(true);
		//this.notifyObservers(this.getNom());
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

	public boolean isContinu() {
		return continu;
	}

	public void setContinu(boolean continu) {
		this.continu = continu;
	}

	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}
}
