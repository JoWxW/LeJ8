/**
 * 
 */
package variante;

import java.util.Iterator;
import java.util.LinkedList;

import carte.Carte;
import effet.*;

/**
 * @author wxw
 *
 */
public class Monclar extends Variante{
	public Monclar(){
		super();
		
		this.setNom("Version Monclar");
		this.setNumero("11");
	}
	
	
	public void addEffet(LinkedList<Carte> tas){
		Effet obligeRejouer = new ObligeRejouer();
		Effet passerSonTour = new PasserSonTour();
		Effet changerSens = new ChangerSens();
		Effet fairePiocher = new FairePiocher(2);
		
		Effet changerforme = new ChangerForme();
		Effet nonEffet = new NonEffet();
		Iterator<Carte> it = tas.iterator();
		while(it.hasNext()){
			Carte c = it.next();
			switch(c.getValeur().getId()){
				case 2:
					c.addEffet(fairePiocher);
					c.setEffectValide(fairePiocher);
					break;
				case 8:
					c.addEffet(changerforme);
					c.setEffectValide(changerforme);
					break;
				case 10:
					c.addEffet(obligeRejouer);
					c.setEffectValide(obligeRejouer);
					break;
			}
		}
	}
}
