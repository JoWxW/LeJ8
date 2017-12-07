/**
 * 
 */
package effet;

import jeu.Jeu;
import joueur.*;
import carte.*;
import java.util.*;
import enumeration.*;

/**
 * @author wxw
 *
 */
public class ArreterAttaque extends Effet{
	public ArreterAttaque(){
		super();
		this.setNom("Arreter les attaques");
	}
	
	public Jeu validerSuperpower(Jeu j){
		/*Joueur joueur = j.getJoueurActuel();
		LinkedList<Carte> cartes = joueur.getCartes();
		Iterator<Carte> itC = cartes.iterator();
		ArrayList<Carte> cartesTarget = new ArrayList<Carte>();
		while(itC.hasNext()){
			Carte c = itC.next();
			if(c.getValeur() == this.valeur){
				cartesTarget.add(c);
			}
		}
		
		Iterator<Carte> itCT = cartesTarget.iterator();
		while(itCT.hasNext()){
			Carte c = itCT.next();
			if(!joueur.getCartesCandidates().contains(c)){
				joueur.addCarteCandidate(c);
			}
		}*/
		this.declarer();
		j.setNbcartePiocher(0);
		
		return j;
	}
}
