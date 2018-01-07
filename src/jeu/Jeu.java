/**
 * 
 */
package jeu;

import carte.*;
import effet.*;
import enumeration.*;
import exception.SaisiNonValideException;
import joueur.*;
import ui.Accueil;
import variante.*;

import java.util.*;

/**
 * @author wxw
 *
 */
public class Jeu extends Observable implements Runnable {
	private static Jeu jeu;
	// <<<<<<< HEAD

	private TasDeCartePosee tasDeCartePosee;
	private TasDeCarteEnAttente tasDeCarteEnAttente;
	private ArrayList<Joueur> joueurs;
	private ArrayList<Joueur> joueursGagne;
	private Joueur joueurActuel;
	private int nbCartePiocher;
	private Carte carteActuelle;
	private Variante variante;
	private ArrayList<Observer> observers;

	private boolean jeuEnCours = false;
	private boolean parametrerTermine = false;
	private boolean changed = false;
	Thread thread;

	// pour determiner la strategie pour les joueus virtuels
	/*
	 * =======
	 * 
	 * private TasDeCarte tas; private LinkedList<Joueur> joueurs; private
	 * LinkedList<Joueur> joueursGagne; private Joueur joueurActuel; private int
	 * nbCartePiocher; private Carte carteActuel; private boolean jeuEnCours;
	 */

	// compte point: 1 positive,0 negatif
	private static int nombreDeJeux;
	private static int nombreDeJoueurs;
	private static int avecJoker;
	private static int versionDeVariante;
	private static int difficulte;
	private static int methodeCompte;
	private static boolean croissante = true;
	private static Scanner scanner;

	public static void main(String[] args) {
		Jeu j = Jeu.getJeu();
		Accueil accueil = new Accueil(j);

	}

	private Jeu() {
		/*
		 * this.tas = new TasDeCarte(); this.joueurs = new LinkedList<Joueur>();
		 * 
		 */
		this.joueursGagne = new ArrayList<Joueur>();
		this.nbCartePiocher = 0;
		// scanner = new Scanner(System.in);
		/*
		 * scanner = new Scanner(System.in); =======
		 */
		this.jeuEnCours = false;
		observers = new ArrayList<Observer>();
		thread = new Thread(this);
		thread.start();

	}

	@Override
	public void run() {
		Jeu jeu = Jeu.getJeu();
		while (!jeu.parametrerTermine) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while (!this.jeuTermine()) {
			Iterator<Joueur> it = getJoueurs().iterator();
			while (it.hasNext()) {
				Joueur j = it.next();
				if (j.aGagne()) {
					getJoueursGagne().add(j);
					it.remove();
				}
			}
			if (getJoueurs().size() == 1) {
				getJoueursGagne().add(getJoueurs().get(0));
				break;
			}
			if (getTasDeCarteEnAttente().getTailleDeTas() > 0) {
				if (getJoueurActuel() instanceof JoueurPhysique) {
					this.setChanged(true);
					this.notifyObservers("carteAPoser");
					System.out.println("Carte de joueur physique£∫ " + this.joueurActuel.getCartes());
					jeu.getJoueurActuel().setTourTermine(false);
					while (!jeu.getJoueurActuel().isTourTermine()) {
						try {
							Thread.sleep(500);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
					jeu.getJoueurActuel().setTourTermine(false);
					if (jeu.getJoueurActuel().getPose()) {
						jeu.getJoueurActuel().setPose(false);
						try {
							jeu.getCarteActuelle().getEffectValide().validerSuperpower(jeu);
						} catch (SaisiNonValideException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					this.setChanged(true);
					this.notifyObservers("carteEnMain");
					try {
						Thread.sleep(500);
					} catch (Exception ex) {
						ex.printStackTrace();
					}

				} else {
					jeu.joueurJoueUnTour();
				}
				jeu.renouvelerJouerActuel();
			} else {
				jeu.renouvelerTasDeCarteEnattente();

			}
		}

	}

	public static Jeu getJeu() {
		if (jeu == null) {
			jeu = new Jeu();
		}
		return jeu;
	}

	/*
	 * @Override public void run() { do { try { Thread.sleep(1000); } catch
	 * (Exception e) { e.printStackTrace(); } } while (!jeuEnCours); do { try {
	 * Thread.sleep(1000); } catch (Exception e) { e.printStackTrace(); } } while
	 * (!parametrerTermine); this.initialiser(); while (!this.jeuTermine()) {
	 * 
	 * Iterator<Joueur> it = this.joueurs.iterator(); while (it.hasNext()) { Joueur
	 * j = it.next(); if (j.aGagne()) { this.joueursGagne.add(j); it.remove(); } }
	 * if (this.joueurs.size() == 1) { this.joueursGagne.add(this.joueurs.get(0));
	 * break; } if (this.getTasDeCarteEnAttente().getTailleDeTas() > 0) {
	 * joueurJoueUnTour(); this.renouvelerJouerActuel(); } else {
	 * this.renouvelerTasDeCarteEnattente();
	 * 
	 * } } this.compterPoint(); Jeu.getScanner().close(); }
	 */

	public void paramtrerJeu() {
		// Exception
		if (jeuEnCours == false) {
			// Scanner scanner = new Scanner(System.in);
			Jeu.setNombreDeJeux(this.validerUneSaisie(
					"Combien de jeux de cartes voulez vous joueur? Veuilliez saisir '1' ou '2'.", 1, 2));
			// toujours avec joker?
			Jeu.setAvecJoker(this.validerUneSaisie(
					"Voulez-vous ajouter les carte 'Joker'? Veuilliez saisir '1' pour oui ou '0' pour non.", 0, 1));
			if (this.nombreDeJeux == 1) {
				Jeu.setNombreDeJoueurs(
						this.validerUneSaisie("Veuillez saisir le nombre de joueurs en total dans votre jeu.", 2, 8));
			} else {
				Jeu.setNombreDeJoueurs(
						this.validerUneSaisie("Veuillez saisir le nombre de joueurs en total dans votre jeu.", 2, 12));
			}
			Jeu.setVersionDeVariante(this.validerUneSaisie("Veuillez choisir la version de variante.", 0, 16));
			Jeu.setMethodeCompte(this.validerUneSaisie(
					"Veuillez choisir le methode de compter, 1 pour compte positif, 0 pour compte negatif", 0, 1));
			Jeu.setDifficulte(this.validerUneSaisie(
					"Veuillez choisir la difficulte,1 pour simple,2 pour moyenne,3 pour difficile.", 1, 3));
			// scanner.close();
		}
	}

	public int validerUneSaisie(String phrase, int min, int max) {
		try {
			int res = demandeUser(phrase, max, min);
			return res;
		} catch (SaisiNonValideException e) {
			System.out.println("ERREUR!!" + e.getMessage());
			int res;
			do {
				System.out.println(phrase);
				res = scanner.nextInt();
			} while (res > max || res < min);
			return res;
		}
	}

	public int demandeUser(String phrase, int max, int min) throws SaisiNonValideException {
		System.out.println(phrase);
		int resultat = scanner.nextInt();
		if (resultat >= min && resultat <= max) {
			return resultat;
		} else {
			throw new SaisiNonValideException("Mauvaise saisie, la valeur doit etre entre " + min + " et " + max);
		}

	}
	/*
	 * public void setJoueurActuel(Joueur j){ this.joueurActuel = j; }
	 * 
	 * public Carte getCarteDepuisTas(){ Carte c = this.tas.getCarte(); return c;
	 * >>>>>>> ca675586e93af1bb5753feb2ea35e89104768ce5 }
	 */

	public void setVariante(int i) {
		switch (i) {
		case 0:
			variante = new Minimale();
			break;
		case 11:
			variante = new Monclar();
			break;
		case 1:
			variante = new Variante1();
			break;
		case 5:
			variante = new Variante5();
		}
	}

	public void initialiser() {
		jeuEnCours = true;
		tasDeCarteEnAttente = new TasDeCarteEnAttente();
		setVariante(versionDeVariante);
		variante.addEffet(tasDeCarteEnAttente.getTasDeCarte(), joueurs);
		tasDeCartePosee = new TasDeCartePosee();
		initialiserJoueurs();
		distribuerCarte();
		// System.out.println("On a distrribue toutes les carte, c'est parti!");
		// System.out.println("La carte actuelle est" + carteActuelle.toString());
		// System.out.println("La joueur actuel est" + joueurActuel.toString());
	}

	public void initialiserJoueurs() {
		joueurs = new ArrayList<Joueur>();
		for (int i = 0; i < Jeu.getNombreDeJoueurs() - 1; i++) {
			JoueurVirtuel j = new JoueurVirtuel("jv" + i, "Joueur " + i, Jeu.getDifficulte());
			joueurs.add(j);
		}
		JoueurPhysique jp = new JoueurPhysique("jp", "wxw");
		joueurs.add(jp);

	}

	// detetminer la premiere carte dans la carte actuelle
	// supposons la distribution commence par place 0
	// il vaut mieux refaire avec un random()
	public void distribuerCarte() {
		tasDeCarteEnAttente.melanger();
		Iterator<Joueur> it = joueurs.iterator();
		while ((!distributionEstTerminee())) {
			if (it.hasNext()) {
				Joueur j = it.next();
				Carte c = tasDeCarteEnAttente.getCarte();
				j.getCartes().add(c);
			} else {
				it = joueurs.iterator();
			}

		}
		System.out.println("Distribution terminee");
		Carte cartePosee = tasDeCarteEnAttente.getCarte();
		tasDeCartePosee.addCartePosee(cartePosee);
		this.setCarteActuelle(cartePosee);
		int position = (int) (Math.random() * (Jeu.getNombreDeJoueurs() - 1));
		this.setJoueurActuel(joueurs.get(position));

	}

	public boolean distributionEstTerminee() {
		boolean res = false;
		int nbCarte = 8;
		if (Jeu.getNombreDeJoueurs() == 2) {
			switch (Jeu.getNombreDeJeux()) {
			case 1:
				nbCarte = 10;
				break;
			case 2:
				nbCarte = 15;
				break;
			}
		} else if (Jeu.getNombreDeJoueurs() == 3) {
			switch (Jeu.getNombreDeJeux()) {
			case 1:
				nbCarte = 8;
				break;
			case 2:
				nbCarte = 12;
				break;
			}
		} else {
			switch (Jeu.getNombreDeJeux()) {
			case 1:
				nbCarte = 6;
				break;
			case 2:
				nbCarte = 9;
				break;
			}

		}
		Joueur j = joueurs.get(Jeu.getNombreDeJoueurs() - 1);
		if (j.getCartes().size() == nbCarte) {
			res = true;
		}
		return res;
	}

	public void joueurPiocher(int nbCarte) {
		Joueur jou = this.getJoueurActuel();
		if (this.getTasDeCarteEnAttente().getTailleDeTas() < nbCarte) {
			this.renouvelerTasDeCarteEnattente();
		}
		for (int i = 0; i < nbCarte; i++) {
			jou.piocher(this.getCarteDepuisTas());
		}
	}

	public boolean jeuTermine() {
		boolean res = false;
		if (methodeCompte == 0) {
			Iterator<Joueur> it = joueurs.iterator();
			while (it.hasNext()) {
				Joueur j = it.next();
				if (j.aGagne()) {
					res = true;
				}
			}
		} else {
			if (this.joueursGagne.size() > 2) {
				res = true;
			}
			// boolean res = false;
			/*
			 * Iterator<Joueur> it = joueurs.iterator(); int nbGagne = 0; int place = 1;
			 * while (it.hasNext()) { Joueur j = it.next(); if (j.aGagne()) { nbGagne++;
			 * j.setPlace(place); System.out.println(j.toString()+"est de place " + place);
			 * place +=1; } } if (nbGagne >= 3) { return true; } else { return false; }
			 */
		}
		return res;
	}

	public void annoncer() {
		Iterator<Joueur> it = joueurs.iterator();
		while (it.hasNext()) {
			Joueur j = it.next();
			if (j.getCartes().size() == 1) {
				j.annoncer();
			}
		}
	}

	public void compterPoint() {
		System.out.println("Point des joueurs");
		/*
		 * Iterator<Joueur> it = joueurs.iterator(); while (it.hasNext()) { Joueur j =
		 * it.next(); System.out.println(j.toString() + " : " + j.calculerPoint()); }
		 */
		if (Jeu.methodeCompte == 0) {
			Iterator<Joueur> it = joueurs.iterator();
			while (it.hasNext()) {
				Joueur j = it.next();
				System.out.println(j.toString() + " : " + j.calculerPoint());
			}
		} else {
			this.joueursGagne.get(0).setPoint(50);
			this.joueursGagne.get(1).setPoint(20);
			this.joueursGagne.get(2).setPoint(10);
			StringBuffer sb = new StringBuffer();
			Iterator<Joueur> it = this.joueursGagne.iterator();
			while (it.hasNext()) {
				Joueur j = it.next();
				sb.append(j.getNom() + " : " + j.getPoint() + " points\n");
			}
			System.out.println(sb);
		}
	}

	/*
	 * public void setCarteActuel(Carte c){ this.carteActuel = c; } public Carte
	 * getCarteActuel(){ return this.carteActuel; }
	 * 
	 * public void setNbJeux() { String nbJeux =
	 * demandeUser("Combien de jeux de cartes voulez vous joueur? Veuilliez saissir '1' ou '2'."
	 * ); if(nbJeux == "1") { Jeu.NOMBRE_DE_JEUX = 1; }else if(nbJeux == "2"){
	 * Jeu.NOMBRE_DE_JEUX = 2; }else { //Exception? >>>>>>>
	 * ca675586e93af1bb5753feb2ea35e89104768ce5 } }
	 */
	public void renouvelerJouerActuel() {
		this.getJoueurActuel().getMyAction().agir(this.getJoueurActuel());
		int i = joueurs.indexOf(joueurActuel);
		int nbJoueurTotal = this.joueurs.size();
		if (croissante == true) {
			if (i + 1 < nbJoueurTotal/* Jeu.getNombreDeJoueurs() */) {
				this.joueurActuel = joueurs.get(i + 1);
			} else {
				this.joueurActuel = joueurs.get(0);
			}

		} else {
			if (i - 1 >= 0) {
				this.joueurActuel = joueurs.get(i - 1);
			} else {
				this.joueurActuel = joueurs.get(nbJoueurTotal/* Jeu.nombreDeJoueurs */ - 1);
			}
		}
	}

	public void renouvelerTasDeCarteEnattente() {
		this.getTasDeCarteEnAttente().addCartesPosees(this.getTasDeCartePosee());
		this.getTasDeCartePosee().clearCartePosee();
	}

	public void derouler() {
		this.paramtrerJeu();
		this.initialiser();
		Iterator<Joueur> itJ = this.joueurs.iterator();
		while (itJ.hasNext()) {
			Joueur ja = itJ.next();
			System.out.println(ja.getCartes());
		}
		int nb = 1;

		while ((!this.jeuTermine())) {
			Iterator<Joueur> it = this.joueurs.iterator();
			while (it.hasNext()) {
				Joueur j = it.next();
				if (j.aGagne()) {
					this.joueursGagne.add(j);
					it.remove();
				}
			}
			if (this.joueurs.size() == 1) {
				this.joueursGagne.add(this.joueurs.get(0));
				break;
			}
			if (this.getTasDeCarteEnAttente().getTailleDeTas() > 0) {
				System.out.println(" ");
				System.out.println("C'est le tour " + nb);
				System.out.println(this.getJoueurs());
				nb++;
				joueurJoueUnTour();
				/*
				 * LinkedList<Carte> carteCandidate =
				 * this.getJoueurActuel().getCarteCandidate(this.getCarteActuelle());
				 * System.out.println("------Carte Acteulle------" + this.carteActuelle); if
				 * (carteCandidate.size() == 0) {
				 * this.getJoueurActuel().piocher(this.getCarteDepuisTas());
				 * System.out.println(this.getJoueurActuel().toString() + " pioche"); } else {
				 * try { // verifier si la carte est bonne(pas besoin alors) Carte c =
				 * this.getJoueurActuel().poserUneCarte(carteCandidate,
				 * this.getJoueurActuel().getCartes()); //
				 * jeu.getJoueurActuel().getCartes().remove(c);
				 * System.out.println(this.getJoueurActuel().toString() + " pose " +
				 * c.toString()); this.setCarteActuelle(c);
				 * this.getTasDeCartePosee().addCartePosee(c); // zhege juzi keneng youwenti
				 * c.getEffectValide().validerSuperpower(this); System.out.println(" ÷≈∆£∫ " +
				 * this.joueurActuel.getCartes());
				 * 
				 * } catch (SaisiNonValideException e) { e.printStackTrace(); } }
				 */
				this.renouvelerJouerActuel();
			} else {
				this.renouvelerTasDeCarteEnattente();

			}
			// this.annoncer();
			System.out.println("nombre en attente" + this.getTasDeCarteEnAttente().getTailleDeTas());
			System.out.println("nombre de carte posee" + this.getTasDeCartePosee().getCartePosee().size());
		}
		this.compterPoint();
		// Jeu.getScanner().close();

		// jeu.initialiserJeu();
		// System.out.println(jeu.get);

	}

	public void joueurJoueUnTour() {
		LinkedList<Carte> carteCandidate = this.getJoueurActuel().getCarteCandidate(this.getCarteActuelle());
		System.out.println("------Carte Acteulle------" + this.carteActuelle);
		if (carteCandidate.size() == 0) {
			this.getJoueurActuel().piocher(this.getCarteDepuisTas());
			System.out.println(this.getJoueurActuel().toString() + " pioche");
		} else {
			try {
				// verifier si la carte est bonne(pas besoin alors)
				Carte c = this.getJoueurActuel().poserUneCarte(carteCandidate, this.getJoueurActuel().getCartes());
				// jeu.getJoueurActuel().getCartes().remove(c);
				System.out.println(this.getJoueurActuel().toString() + " pose " + c.toString());
				this.setCarteActuelle(c);
				this.getTasDeCartePosee().addCartePosee(c);
				// zhege juzi keneng youwenti
				c.getEffectValide().validerSuperpower(this);
				//System.out.println("Carte a la main£∫ " + this.joueurActuel.getCartes());
				System.out.println("       ");
				this.changed = true;
				jeu.notifyObservers("carteActuelle");
				Thread.sleep(2000);

			} catch (SaisiNonValideException e) {
				e.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	// Observable
	public void add(Observer o) {
		if (observers.contains(o)) {
			return;
		}
		observers.add(o);
	}

	public void notifyObservers(Object arg) {
		if (!changed) {
			return;
		}
		Iterator<Observer> it = observers.iterator();
		while (it.hasNext()) {
			Observer o = it.next();
			o.update(this, arg);
		}
		this.clearChanged();

	}

	public void clearChanged() {
		this.changed = false;
	}

	// setter et getter
	public boolean isChanged() {
		return this.changed;
	}

	public void setChanged(boolean b) {
		this.changed = b;
	}

	public boolean isJeuEnCours() {
		return jeuEnCours;
	}

	public void setJeuEnCours(boolean jeuEnCours) {
		this.jeuEnCours = jeuEnCours;
	}

	public Joueur getJoueurActuel() {
		return this.joueurActuel;
	}

	public void setJoueurActuel(Joueur j) {
		this.joueurActuel = j;
	}

	public Carte getCarteDepuisTas() {
		Carte c = this.tasDeCarteEnAttente.getCarte();
		return c;
	}

	public boolean aAssezDeCarte() {
		boolean res = true;
		if (this.getNbCartePiocher() > this.getTasDeCarteEnAttente().getTailleDeTas()) {
			res = false;
		}
		return res;
	}

	public int getNbCartePiocher() {
		return this.nbCartePiocher;
	}

	public void setNbcartePiocher(int nb) {
		this.nbCartePiocher = nb;
	}

	public static int getMethodeCompte() {
		return methodeCompte;
	}

	public static void setMethodeCompte(int methodeCompte) {
		Jeu.methodeCompte = methodeCompte;
	}

	public Carte getCarteActuelle() {
		return carteActuelle;
	}

	public void setCarteActuelle(Carte carteActuelle) {
		this.carteActuelle = carteActuelle;
	}

	public void setParametrerTermine(boolean b) {
		this.parametrerTermine = b;
	}

	public boolean getParametrerTermine() {
		return this.parametrerTermine;
	}

	public static int getDifficulte() {
		return difficulte;
	}

	public static void setDifficulte(int difficulte) {
		Jeu.difficulte = difficulte;
	}

	public static int getNombreDeJeux() {
		return nombreDeJeux;
	}

	public static void setNombreDeJeux(int nombreDeJeux) {
		Jeu.nombreDeJeux = nombreDeJeux;
	}

	public static int getNombreDeJoueurs() {
		return nombreDeJoueurs;
	}

	public static void setNombreDeJoueurs(int nombreDeJoueurs) {
		Jeu.nombreDeJoueurs = nombreDeJoueurs;
	}

	public static int getAvecJoker() {
		return avecJoker;
	}

	public static void setAvecJoker(int avecJoker) {
		Jeu.avecJoker = avecJoker;
	}

	public static int getVersionDeVariante() {
		return versionDeVariante;
	}

	public static void setVersionDeVariante(int versionDeVariante) {
		Jeu.versionDeVariante = versionDeVariante;
	}

	/*
	 * ======= public void initialiserJeu() { if(this.jeuEnCours == false){
	 * this.parametrerJeu();
	 * 
	 * //Joueurs
	 * 
	 * JoueurPhysique jp = new JoueurPhysique(); this.joueurs.add(jp); for(int i =
	 * 1; i<Jeu.NOMBRE_DE_JOUEURS; i++){ JoueurVirtuel jv = new JoueurVirtuel();
	 * this.joueurs.add(jv); } this.melangerJoueurs(); Joueur joueurInitial =
	 * this.joueurs.get(0); this.setJoueurActuel(joueurInitial);
	 * 
	 * //Tas de cartes //ne pas prendre en compte les exigences de nombre de carte
	 * dans certaines variantes this.tas.melanger(); this.distribuerCarte(); Carte
	 * carteInitiale = this.tas.getCarte(); this.setCarteActuel(carteInitiale); }
	 * 
	 * }
	 * 
	 * public void parametrerJeu(){ //Exception Scanner scanner = new
	 * Scanner(System.in); Jeu.NOMBRE_DE_JEUX = this.
	 * demandeUser("Combien de jeux de cartes voulez vous joueur? Veuilliez saisir '1' ou '2'."
	 * , scanner); Jeu.AVEC_JOKER = this.
	 * demandeUser("Voulez-vous ajouter les carte 'Joker'? Veuilliez saisir '1' pour oui ou '0' pour non."
	 * , scanner); Jeu.NOMBRE_DE_JOUEURS = this.
	 * demandeUser("Veuillez saisir le nombre de joueurs en total dans votre jeu.",
	 * scanner); for(Variante v : Variante.values()){ System.out.println(v + " : " +
	 * v.getNumero() + "\n"); } Jeu.NUMERO_DE_VERSION_DE_VARIANTE =
	 * this.demandeUser("Veuillez choisir la version de variante.", scanner);
	 * Jeu.METHODE_COMPTE = this.
	 * demandeUser("Quel est la m®¶thode de compter les points? Veuillez saisir '1' pour compte positif, '2' pour compte n®¶gatif"
	 * , scanner); scanner.close(); >>>>>>> ca675586e93af1bb5753feb2ea35e89104768ce5
	 * }
	 */
	public ArrayList<Joueur> getJoueurs() {
		return this.joueurs;
	}

	public static boolean isCroissante() {
		return croissante;
	}

	public static void setCroissante(boolean coissante) {
		Jeu.croissante = coissante;
	}

	public TasDeCarteEnAttente getTasDeCarteEnAttente() {
		return this.tasDeCarteEnAttente;
	}

	public void setTasDeCarteEnAttente(TasDeCarteEnAttente t) {
		this.tasDeCarteEnAttente = t;
	}

	public TasDeCartePosee getTasDeCartePosee() {
		return this.tasDeCartePosee;
	}

	public void setTasDeCartePosee(TasDeCartePosee t) {
		this.tasDeCartePosee = t;
	}

	public static Scanner getScanner() {
		return scanner;
	}

	public static void setScanner(Scanner scanner) {
		Jeu.scanner = scanner;
	}

	public Variante getVariante() {
		return variante;
	}

	public void setVariante(Variante variante) {
		this.variante = variante;
	}

	public ArrayList<Joueur> getJoueursGagne() {
		return joueursGagne;
	}

	/*
	 * public void setNbJeux() { String nbJeux =
	 * demandeUser("Combien de jeux de cartes voulez vous joueur? Veuilliez saissir '1' ou '2'."
	 * ); if(nbJeux == "1") { Jeu.NOMBRE_DE_JEUX = 1; }else if(nbJeux == "2"){
	 * Jeu.NOMBRE_DE_JEUX = 2; }else { //Exception? } }
	 * 
	 * public void setAvecJoker() { String avecJoker =
	 * demandeUser("Voulez-vous ajouter les carte 'Joker'? Veuilliez saissir 'oui' ou 'non'."
	 * ); if(avecJoker == "oui") { Jeu.AVEC_JOKER = 2; }else if(avecJoker == "non"){
	 * Jeu.AVEC_JOKER = 0; }else { //Exception? } }
	 */

	/*
	 * ======= public void melangerJoueurs(){ for (int i=0; i <
	 * Jeu.NOMBRE_DE_JOUEURS; i++){ int position =
	 * (int)Math.round((Jeu.NOMBRE_DE_JOUEURS - 1) * Math.random()); Joueur j =
	 * this.joueurs.pop(); this.joueurs.add(position, j); } } public void
	 * distribuerCarte(){ if(this.jeuEnCours == false){ Iterator<Joueur> it =
	 * this.joueurs.iterator(); while (!this.tas.estVide()) { if (it.hasNext()) {
	 * Joueur j = it.next(); Carte c = tas.getCarte(); j.piocher(c); // test de
	 * distribution des cartes /* System.out.println("Carte " +c.toString() + " a "
	 * + j.toString()); System.out.println("Nombre " + cartes.getCartes().size());
	 */
	/*
	 * } else { it = joueurs.iterator(); } } } } >>>>>>>
	 * ca675586e93af1bb5753feb2ea35e89104768ce5
	 */
}
