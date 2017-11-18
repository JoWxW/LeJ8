/**
 * 
 */
package carte;
import enumeration.*;

/**
 * @author wxw
 *
 */
public class Carte {
	private String id;
	private Forme forme;
	private int valeur;
	private int point;
	private Etat etat;
	private Effet[] effet;
	/**
	 * @param id
	 * @param forme
	 * @param valeur
	 * @param point
	 * @param etat
	 * @param effet
	 */
	public Carte(String id, Forme forme, int valeur, int point, Etat etat, Effet[] effet) {
		super();
		this.id = id;
		this.forme = forme;
		this.valeur = valeur;
		this.point = point;
		this.etat = etat;
		this.effet = effet;
	}
	
	public Carte(){}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

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
	public int getValeur() {
		return valeur;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
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
	 */
	public Effet[] getEffet() {
		return effet;
	}

	/**
	 * @param effet the effet to set
	 */
	public void setEffet(Effet[] effet) {
		this.effet = effet;
	}
	
	
}