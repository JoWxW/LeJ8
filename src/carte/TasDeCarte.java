/**
 * 
 */
package carte;

import enumeration.*;
import java.util.*;

/**
 * @author wxw
 *
 */
public class TasDeCarte {
	//constante à voir dans la classe Carte
	public final static int sizeValeurs = Valeur.size;
	public final static int sizeFormes = Forme.size;
	//constante à voir dans la classe Jouer
	public final static int jeux = 2;
	public final static int avecJoker = 1;
	
	
	public final static int NOMBRE_DE_CARTES = TasDeCarte.jeux*(TasDeCarte.sizeFormes*TasDeCarte.sizeValeurs + TasDeCarte.avecJoker*2);
	private LinkedList<Carte> carteEnAttend;

	public TasDeCarte(){
		this.carteEnAttend = new LinkedList<Carte>();
		if(TasDeCarte.avecJoker == 1){
			Carte j = new Carte();
			this.carteEnAttend.add(j);
			this.carteEnAttend.add(j);
		}
		
		//老师好像不推荐用这个形式的for循环，他说不visible
		for(Forme f : Forme.values()){
			for(Valeur v : Valeur.values()){
				Carte c = new Carte(f, v);
				this.carteEnAttend.add(c);
			}
		}
		if(TasDeCarte.jeux == 2){
			this.carteEnAttend.addAll(carteEnAttend);
		}
	}
	
	public void melanger(){
		for(int i=0; i<this.NOMBRE_DE_CARTES; i++){
			int position = (int)Math.round((Math.random()*(TasDeCarte.NOMBRE_DE_CARTES - 1)));
			Carte c = this.carteEnAttend.pop();
			this.carteEnAttend.add(position, c);
		}
		
	}
	
	public String toString(){
		return this.carteEnAttend.toString();
	}
	
	public static void main(String[] args){
		//Carte c = new Carte(Forme.carreau, Valeur.AS);
		//System.out.println(c.toString());
		TasDeCarte tdc = new TasDeCarte();
		tdc.melanger();
		System.out.println(tdc.toString());
	}
}
