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
//jeu中，每一轮开始之前verifier la taille de tas de carte, taille<5(?) 则从cartes posees里加牌进来
public class TasDeCarte {
	//constante à voir dans la classe Carte
	public final static int sizeValeurs = Valeur.size;
	public final static int sizeFormes = Forme.size;
	//constante à voir dans la classe Jeu
	//public final static int Jeu.jeux = 2;
	//public final static int avecJoker = 1;
	
	
	private int NOMBRE_DE_CARTES;
	private LinkedList<Carte> carteEnAttend;


	public TasDeCarte(int jeux, int avecJoker){
		this.NOMBRE_DE_CARTES = jeux*(TasDeCarte.sizeFormes*TasDeCarte.sizeValeurs + avecJoker*2);
		this.carteEnAttend = new LinkedList<Carte>();
		if(avecJoker == 1){
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
		if(jeux == 2){
			this.carteEnAttend.addAll(carteEnAttend);
		}
	}
	
	public int getNOMBRE_DE_CARTES(){
		return this.NOMBRE_DE_CARTES;
	}
	
	public int getTailleDeTas(){
		return this.carteEnAttend.size();
	}
	
	public LinkedList<Carte> getTasDeCarte(){
		return this.carteEnAttend;
	}
	
	public Carte getCarte(){
		Carte c = this.carteEnAttend.pop();
		return c;
	}
	
	public void melanger(){
		for(int i=0; i<this.NOMBRE_DE_CARTES; i++){
			int position = (int)Math.round((Math.random()*(this.NOMBRE_DE_CARTES - 1)));
			Carte c = this.carteEnAttend.pop();
			this.carteEnAttend.add(position, c);
		}
		
	}
	
	public void addCartesPosees(CartePosee cp){
		this.carteEnAttend.addAll(cp.getCartePosee());
	}
	
	public String toString(){
		return this.carteEnAttend.toString();
	}
	
	public static void main(String[] args){
		//Carte c = new Carte(Forme.carreau, Valeur.AS);
		//System.out.println(c.toString());
		TasDeCarte tdc = new TasDeCarte(1, 1);
		tdc.melanger();
		System.out.println(tdc.toString());
	}
}
