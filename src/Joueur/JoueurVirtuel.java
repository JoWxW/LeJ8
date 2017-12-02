package joueur;
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
<<<<<<< HEAD:src/Joueur/JoueurVirtuel.java
    public static void main(String[] args) {
    	JoueurVirtuel jv = new JoueurVirtuel();
    }
    
=======
    
    /*public static void main(String[] args){
    	JoueurVirtuel jv = new JoueurVirtuel();
    	StrategieSimple s = new StrategieSimple();
    	jv.setStrategie(s);
    	System.out.println(jv.strategie.toString());
    }*/
>>>>>>> 7e87a88cec2b4ed1204fcc845b86e3cd93c41a65:src/joueur/JoueurVirtuel.java
    
}
