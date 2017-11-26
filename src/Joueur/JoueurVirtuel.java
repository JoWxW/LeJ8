package Joueur;
import java.util.LinkedList;
import carte.*;
import enumeration.*;

public class JoueurVirtuel extends Joueur{
    
	//la strategie de joueur virtuel
	private StrategieDeJoueur strategie;
	//choisir une carte parmi toutes les cartes candidates en fonction de sa strategie
	public Carte poserUneCarte(LinkedList<Carte> carteCandidate,LinkedList<Carte> a) {
		Carte c = this.strategie.poser(carteCandidate, a);
		return c;
	}
	//1 pour simple,2 pour moyen,3 pour difficile
    public void setStrategie(StrategieDeJoueur s) {
    	this.strategie = s;
    }
    
    
    
}
