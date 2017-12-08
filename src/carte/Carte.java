/**
 * 
 */
package carte;
import java.util.ArrayList;

import effet.*;
import enumeration.*;

/**
 * @author wxw
 *
 */
public class Carte {
	//private String id;
	private Forme forme;
	private Valeur valeur;
	//private int point;
	private Etat etat;
	
	//¼ÓÒ»¸öeffet valide?
	private Effet effectValide = new NonEffet();
	//Collection	
	private ArrayList<Effet> effet;
	/**
	 * @param id
	 * @param forme
	 * @param valeur
	 * @param point
	 * @param etat
	 * @param effet
	 */
	public Carte(/*String id, */Forme forme, Valeur valeur/*, int point, Etat etat*/) {
		//this.id = id;
		this.forme = forme;
		this.valeur = valeur;
		//this.point = point;
		this.etat = Etat.enAttend;
		this.effet = new ArrayList<Effet>();
	}
	
	public Carte(){
		this.etat = Etat.enAttend;
		this.setValeur(valeur.values()[13]);
		this.setForme(Forme.values()[4]);
		this.effet = new ArrayList<Effet>();
		Effet e = new ArreterAttaque();
		this.addEffet(e);
	}
	

	/**
	 * @return the id
	 
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 
	public void setId(String id) {
		this.id = id;
	}*/

	/**
	 * @return the forme
	 */
	public Forme getForme() {
		return forme;
	}

	/**
	 * @param forme the forme to set
	 */
	public void setForme(Forme forme) {
		this.forme = forme;
	}

	/**
	 * @return the valeur
	 */
	public Valeur getValeur() {
		return valeur;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(Valeur valeur) {
		this.valeur = valeur;
	}

	/**
	 * @return the point
	 
	public int getPoint() {
		return point;
	}

	/**
	 * @param point the point to set
	 
	public void setPoint(int point) {
		this.point = point;
	}*/

	/**
	 * @return the etat
	 */
	public Etat getEtat() {
		return etat;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	/**
	 * @return the effet
	 
	public Effet[] getEffet() {
		return effet;
	}

	/**
	 * @param effet the effet to set
	 
	public void setEffet(Effet[] effet) {
		this.effet = effet;
	}*/
	
	public String toString(){
		StringBuffer s = new StringBuffer();
		
		if(this.valeur == null){
			s.append("Joker");
		} else {
			s.append(this.valeur);
			s.append(" de ");
			s.append(this.forme);
		}
		return s.toString();
	}

	public ArrayList<Effet> getEffet() {
		return this.effet;
	}

	public void addEffet(Effet effet) {
		this.effet.add(effet);
	}

	public Effet getEffectValide() {
		return effectValide;
	}

	public void setEffectValide(Effet effectValide) {
		this.effectValide = effectValide;
	}
}
