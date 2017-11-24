/**
 * 
 */
package enumeration;

/**
 * @author wxw
 *
 */
public enum Valeur {
	AS(1),
	DEUX(2),
	TROIS(3),
	QUATRE(4),
	CINQ(5),
	SIX(6),
	SEPT(7),
	HUIT(8),
	NEUF(9),
	DIX(10),
	VALET(11),
	DAME(12),
	ROI(13);
	
	private final int id;
	public final static int size = Valeur.values().length;
	
	Valeur(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
}