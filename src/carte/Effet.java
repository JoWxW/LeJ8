/**
 * 
 */
package carte;

/**
 * @author wxw
 *
 */
public class Effet {
	private String nom;
	public Effet(){}
	/**
	 * @param nom
	 */
	public Effet(String nom) {
		super();
		this.nom = nom;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void effectuer(){}
}
