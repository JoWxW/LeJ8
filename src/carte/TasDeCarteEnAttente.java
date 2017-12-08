/**
 * 
 */
package carte;

import enumeration.*;
import jeu.*;
import java.util.*;

/**
 * @author wxw
 *
 */
//jeu锟叫ｏ拷每一锟街匡拷始之前verifier la taille de tas de carte, taille<5(?) 锟斤拷锟絚artes posees锟斤拷锟斤拷平锟斤拷锟�
public class TasDeCarteEnAttente {
	//constante 锟斤拷 voir dans la classe Carte
	public final static int sizeValeurs = Valeur.size;
	public final static int sizeFormes = Forme.size;
	//constante 锟斤拷 voir dans la classe Jeu
	//public final static int Jeu.jeux = 2;
	//public final static int avecJoker = 1;
	
	
	private int nbDeCarte;
	private LinkedList<Carte> carteEnAttente;


	public TasDeCarteEnAttente(){
		this.nbDeCarte = Jeu.getNombreDeJeux()*(52 + Jeu.getAvecJoker()*2);
		this.carteEnAttente = new LinkedList<Carte>();
		if(Jeu.getAvecJoker() == 1){
			Carte j = new Carte();
			this.carteEnAttente.add(j);
			this.carteEnAttente.add(j);
		}
		
		//锟斤拷师锟斤拷锟斤拷锟狡硷拷锟斤拷锟斤拷锟斤拷锟绞斤拷锟絝or循锟斤拷锟斤拷锟斤拷说锟斤拷visible
		for(int i = 0;i<4;i++){
			for(int j = 0;j<13;j++){
				Valeur v = Valeur.values()[j];
				Forme f = Forme.values()[i];
				Carte c = new Carte(f, v);
				this.carteEnAttente.add(c);
			}
		}
		if(Jeu.getNombreDeJeux() == 2){
			this.carteEnAttente.addAll(carteEnAttente);
		}
	}
	
	public int getNOMBRE_DE_CARTES(){
		return this.nbDeCarte;
	}
	
	public int getTailleDeTas(){
		return this.carteEnAttente.size();
	}
	
	public LinkedList<Carte> getTasDeCarte(){
		return this.carteEnAttente;
	}
	
	public Carte getCarte(){
		Carte c = this.carteEnAttente.pop();
		return c;
	}
	
	public void melanger(){
		for(int i=0; i<this.nbDeCarte; i++){
			int position = (int)Math.round((Math.random()*(this.nbDeCarte - 1)));
			Carte c = this.carteEnAttente.pop();
			this.carteEnAttente.add(position, c);
		}
		
	}
	
	public void addCartesPosees(TasDeCartePosee cp){
		this.carteEnAttente.addAll(cp.getCartePosee());
	}
	
	public String toString(){
		return this.carteEnAttente.toString();
	}
	
	public static void main(String[] args){
		//Carte c = new Carte(Forme.carreau, Valeur.AS);
		//System.out.println(c.toString());
		TasDeCarteEnAttente tdc = new TasDeCarteEnAttente();
		tdc.melanger();
		System.out.println(tdc.getTailleDeTas()+tdc.toString());
	}
}
