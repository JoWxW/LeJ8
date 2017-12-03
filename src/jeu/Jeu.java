/**
 * 
 */
package jeu;
import carte.*;
import effet.*;
import enumeration.*;
import joueur.*;

import java.util.*;

/**
 * @author wxw
 *
 */
public class Jeu {
	private static Jeu jeu;
	
	private TasDeCarte tas;
	private LinkedList<Joueur> joueurs;
	private LinkedList<Joueur> joueursGagne;
	private Joueur joueurActuel;
	private int nbCartePiocher;
	private Carte carteActuel;
	private boolean jeuEnCours;
	
	public static int NOMBRE_DE_JEUX;
	public static int NOMBRE_DE_JOUEURS;
	public static int AVEC_JOKER;
	public static int NUMERO_DE_VERSION_DE_VARIANTE;
	public static int METHODE_COMPTE;
	
	private Jeu() {
		this.tas = new TasDeCarte();
		this.joueurs = new LinkedList<Joueur>();
		this.joueursGagne = new LinkedList<Joueur>();
		this.nbCartePiocher = 0;
		this.jeuEnCours = false;
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
	public void setJoueurActuel(Joueur j){
		this.joueurActuel = j;
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
	public void setCarteActuel(Carte c){
		this.carteActuel = c;
	}
	public Carte getCarteActuel(){
		return this.carteActuel;
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
	
	public void initialiserJeu() {
		if(this.jeuEnCours == false){
			this.parametrerJeu();
			
			//Joueurs
			
			JoueurPhysique jp = new JoueurPhysique();
			this.joueurs.add(jp);
			for(int i = 1; i<Jeu.NOMBRE_DE_JOUEURS; i++){
				JoueurVirtuel jv  = new JoueurVirtuel();
				this.joueurs.add(jv);
			}
			this.melangerJoueurs();
			Joueur joueurInitial = this.joueurs.get(0);
			this.setJoueurActuel(joueurInitial);
			
			//Tas de cartes
			//ne pas prendre en compte les exigences de nombre de carte dans certaines variantes
			this.tas.melanger();
			this.distribuerCarte();
			Carte carteInitiale = this.tas.getCarte();
			this.setCarteActuel(carteInitiale);
		}
		
	}
	
	public void parametrerJeu(){
		//Exception
		Scanner scanner = new Scanner(System.in);
		Jeu.NOMBRE_DE_JEUX = this.demandeUser("Combien de jeux de cartes voulez vous joueur? Veuilliez saisir '1' ou '2'.", scanner);
		Jeu.AVEC_JOKER = this.demandeUser("Voulez-vous ajouter les carte 'Joker'? Veuilliez saisir '1' pour oui ou '0' pour non.", scanner);
		Jeu.NOMBRE_DE_JOUEURS = this.demandeUser("Veuillez saisir le nombre de joueurs en total dans votre jeu.", scanner);
		for(Variante v : Variante.values()){
			System.out.println(v + " : " + v.getNumero() + "\n");
		}
		Jeu.NUMERO_DE_VERSION_DE_VARIANTE = this.demandeUser("Veuillez choisir la version de variante.", scanner);
		Jeu.METHODE_COMPTE = this.demandeUser("Quel est la m¨¦thode de compter les points? Veuillez saisir '1' pour compte positif, '2' pour compte n¨¦gatif", scanner);
		scanner.close();
	}
	
	public int demandeUser(String phrase, Scanner scan) {
		System.out.println(phrase);
		int resultat = scan.nextInt();
		return resultat;
	}
	public void melangerJoueurs(){
		for (int i=0; i < Jeu.NOMBRE_DE_JOUEURS; i++){
			int position = (int)Math.round((Jeu.NOMBRE_DE_JOUEURS - 1) * Math.random());
			Joueur j = this.joueurs.pop();
			this.joueurs.add(position, j);
		} 
	}
	public void distribuerCarte(){
		if(this.jeuEnCours == false){
			Iterator<Joueur> it = this.joueurs.iterator();
			while (!this.tas.estVide()) {
				if (it.hasNext()) {
					Joueur j = it.next();
					Carte c = tas.getCarte();
					j.piocher(c);
					// test de distribution des cartes
					/*
					 * System.out.println("Carte " +c.toString() + " a " + j.toString());
					 * System.out.println("Nombre " + cartes.getCartes().size());
					 */
				} else {
					it = joueurs.iterator();
				}
			}
		}
	}
}
