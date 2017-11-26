/**
 * 
 */
package enumeration;

/**
 * @author wxw
 *
 */
public enum Forme {
	Pique(0), Coeur(1),Carreau(2), Trefle(3);
	
	private final int id;
	public final static int size = Forme.values().length;
	
	Forme(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}

}
