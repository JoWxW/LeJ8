/**
 * 
 */
package carte;

/**
 * @author wxw
 *
 */
public class TasDeCarte {
	private Carte[] carteEnAttend;

	/**
	 * @param carteEnAttend
	 */
	public TasDeCarte(Carte[] carteEnAttend) {
		this.carteEnAttend = carteEnAttend;
	}
	
	public TasDeCarte(){}

	/**
	 * @return the carteEnAttend
	 */
	public Carte[] getCarteEnAttend() {
		return carteEnAttend;
	}

	/**
	 * @param carteEnAttend the carteEnAttend to set
	 */
	public void setCarteEnAttend(Carte[] carteEnAttend) {
		this.carteEnAttend = carteEnAttend;
	}
	
	public void addCarte(Carte c){}
	public void deleteCarte(Carte c){}
}
