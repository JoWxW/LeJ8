/**
 * 
 */
package jeu;
import carte.*;
import effet.*;
import enumeration.*;
import joueur.*;
import java.util.Scanner;
import java.util.*;

/**
 * @author wxw
 *
 */
public class Jeu {
	
	private TasDeCarte tas;
	private LinkedList<Joueur> joueurs;
	private Joueur joueurActuel;
	private int nbCartePiocher;
	
	public Joueur getJoueurActuel(){
		return this.joueurActuel;
	}
	
	public Carte getCarteDepuisTas(){
		Carte c = this.tas.getCarte();
		return c;
	}
	
	public int getNbCartePiocher(){
		return this.nbCartePiocher;
	}
	public void setNbcartePiocher(int nb){
		this.nbCartePiocher = nb;
	}
	
	public static void main(String[] args){
		System.out.println("Combien de jeux de cartes voulez vous joueur?");
		Scanner jeux = new Scanner(System.in);
		Scanner avecJoker = new Scanner(System.in);
	}
}
