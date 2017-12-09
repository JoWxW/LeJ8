/**
 * 
 */
package variante;
import carte.*;
import effet.*;
import java.util.*;
/**
 * @author wxw
 *
 */
public class Variante5 extends Variante{
	public Variante5(){
		super();
		this.setNom("Variante5");
		this.setNumero("5");
	}


	@Override
	public void addEffet(LinkedList<Carte> tas) {
		ObligeRejouer obligeRejouer = new ObligeRejouer();
		ChangerSens changerSens = new ChangerSens();
		FairePiocherOuMeme fairePiocher = new FairePiocherOuMeme(2);
		ChangerFormeArreterAttaque changerFormeArreterAttaque = new ChangerFormeArreterAttaque();
		
		Iterator<Carte> it  = tas.iterator();
		while(it.hasNext()){
			Carte c = it.next();
			if (c.getEffet().size() == 0){
				switch(c.getValeur().getId()){
				case 10:
					c.addEffetVariante(obligeRejouer);
					break;
				case 7:
					c.addEffetVariante(changerSens);
					break;
				case 1:
					c.addEffet(fairePiocher);
					break;
				case 8:
					c.addEffet(changerFormeArreterAttaque);
					break;
				}
			}
		}
	}
	
}
