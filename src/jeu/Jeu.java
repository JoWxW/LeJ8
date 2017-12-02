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
	private static Jeu jeu;
	
	private TasDeCarte tas;
	private LinkedList<Joueur> joueurs;
	private Joueur joueurActuel;
	private int nbCartePiocher;
	private Carte carteActuel;
	private boolean methodeCompte;
	
	public static int NOMBRE_DE_JEUX;
	public static int NOMBRE_DE_JOUEURS;
	public static int AVEC_JOKER;
	public static int NUMERO_DE_VERSION_DE_VARIANTE;
	
	private Jeu() {
		this.nbCartePiocher = 0;
	}
	public static Jeu getJeu() {
		if(jeu == null) {
			jeu = new Jeu();
		}
		return jeu;
	}
	
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
	
	/*
	public void setNbJeux() {
		String nbJeux = demandeUser("Combien de jeux de cartes voulez vous joueur? Veuilliez saissir '1' ou '2'.");
		if(nbJeux == "1") 
		{
			Jeu.NOMBRE_DE_JEUX = 1;
		}else if(nbJeux == "2"){
			Jeu.NOMBRE_DE_JEUX = 2;
		}else {
			//Exception?
		}
	}
	
	public void setAvecJoker() {
		String avecJoker = demandeUser("Voulez-vous ajouter les carte 'Joker'? Veuilliez saissir 'oui' ou 'non'.");
		if(avecJoker == "oui") 
		{
			Jeu.AVEC_JOKER = 2;
		}else if(avecJoker == "non"){
			Jeu.AVEC_JOKER = 0;
		}else {
			//Exception?
		}
	}*/
	
	public void paramtrerJeu() {
		//Exception

		Scanner scanner = new Scanner(System.in);
		Jeu.NOMBRE_DE_JEUX = this.demandeUser("Combien de jeux de cartes voulez vous joueur? Veuilliez saisir '1' ou '2'.", scanner);
		Jeu.AVEC_JOKER = this.demandeUser("Voulez-vous ajouter les carte 'Joker'? Veuilliez saisir '1' pour oui ou '0' pour non.", scanner);
		Jeu.NOMBRE_DE_JOUEURS = this.demandeUser("Veuillez saisir le nombre de joueurs en total dans votre jeu.", scanner);
		Jeu.NUMERO_DE_VERSION_DE_VARIANTE = this.demandeUser("Veuillez choisir la version de variante.", scanner);

		scanner.close();
	}
	
	public int demandeUser(String phrase, Scanner scan) {
		System.out.println(phrase);
		int resultat = scan.nextInt();
		return resultat;
	}
	
	
}
