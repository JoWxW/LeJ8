package joueur;
import java.util.LinkedList;
import carte.*;
import enumeration.*;

public class JoueurVirtuel extends Joueur{

    //la strategie de joueur virtuel

    //need an id to identify one to another
	//la strategie de joueur virtuel

	private StrategieDeJoueur strategie;
	
	public JoueurVirtuel(String id, String nom, int place) {
		super(id, nom, place);
		
		// TODO Auto-generated constructor stub
	}
	public JoueurVirtuel(String id, String nom, int place,int difficulte) {
		super(id, nom, place);
		if(difficulte == 1) {
			this.strategie = new StrategieSimple();
		}else if(difficulte == 2) {
			this.strategie = new StrategieMoyenne();
		}else if(difficulte == 3) {
			this.strategie = new StrategieDifficile();
		}else {
			this.strategie = new StrategieSimple();
		}
	}
	
	//choisir une carte parmi toutes les cartes candidates en fonction de sa strategie
	public Carte poserUneCarte(LinkedList<Carte> carteCandidate,LinkedList<Carte> a) {		
		Carte c = this.strategie.poser(carteCandidate, a);
		return c;
	}
	//1 pour simple,2 pour moyen,3 pour difficile
    public void setStrategie(StrategieDeJoueur s) {
    	this.strategie = s;
    }
    
    public StrategieDeJoueur getStrategie() {
    	return strategie;
    }
    
    /*public static void main(String[] args){
    	JoueurVirtuel jv = new JoueurVirtuel();
    	StrategieSimple s = new StrategieSimple();
    	jv.setStrategie(s);
    	System.out.println(jv.strategie.toString());
    }*/
    
}
