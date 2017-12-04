/**
 * 
 */
package carte;
import java.util.*;

/**
 * @author wxw
 *
 */

public class TasDeCartePosee {
	private LinkedList<Carte> cartePosee;

	public TasDeCartePosee(){
		this.cartePosee = new LinkedList<Carte>();
	}

	/**
	 * @return the cartePosee
	 */
	public LinkedList<Carte> getCartePosee() {
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
