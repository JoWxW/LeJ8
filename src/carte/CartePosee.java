/**
 * 
 */
package carte;

/**
 * @author wxw
 *
 */
public class CartePosee {
	private Carte cartePosee;

	/**
	 * @param cartePosee
	 */
	public CartePosee(Carte cartePosee) {
		this.cartePosee = cartePosee;
	}
	
	public CartePosee(){}

	/**
	 * @return the cartePosee
	 */
	public Carte getCartePosee() {
		return cartePosee;
	}

	/**
	 * @param cartePosee the cartePosee to set
	 */
	public void setCartePosee(Carte cartePosee) {
		this.cartePosee = cartePosee;
	}
	
	public void addCarte(Carte c){}
	public void deleteCarte(Carte c){}
}
