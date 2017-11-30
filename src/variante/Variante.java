/**
 * 
 */
package variante;

/**
 * @author wxw
 *
 */
public class Variante {
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
	
	public Variante(){}

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

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public void addEffet(){}
	//public void test(){}
}
