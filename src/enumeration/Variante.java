/**
 * 
 */
package enumeration;

/**
 * @author wxw
 *
 */
public enum Variante {
	VersionMinimale(0),
	Variante1(1),
	Variantt2CarteEtMaou(2),
	Variantt3desUlis(3),
	Variante4(4),
	Variantt5(5),
	Variantt6(6),
	Variantt7(7),
	Variantt8(8),
	Variantt9Jules(9),
	Variantt10ParadoxHech(10),
	VersionMonclar(11),
	CourteAmicale(12),
	Us17(13),
	Koukitu(14),
	ParChoix(15),
	RosaInjuste(16);
	
	private final int numero;
	Variante(int numero){
		this.numero = numero;
	}
	
	public int getNumero(){
		return this.numero;
	}
}
