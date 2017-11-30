/**
 * 
 */
package carte;
import java.util.*;

/**
 * @author wxw
 *
 */

public class CartePosee {
	private ArrayList<Carte> cartePosee;

	public CartePosee(){
		this.cartePosee = new ArrayList<Carte>();
	}

	/**
	 * @return the cartePosee
	 */
	public ArrayList<Carte> getCartePosee() {
		return cartePosee;
	}

	/**
	 * @param cartePosee the cartePosee to set
	 */
	public void addCartePosee(Carte cartePosee) {
		this.cartePosee.add(cartePosee);
	}
	
	public void clearCartePosee(){
		this.cartePosee.clear();
	}
}
