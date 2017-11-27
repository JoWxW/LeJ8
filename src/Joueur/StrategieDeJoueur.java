package Joueur;
import java.util.LinkedList;

import carte.Carte;

public interface StrategieDeJoueur {
    //Strategies differentes pour poser une carte  
	public Carte poser(LinkedList<Carte> carteCandidate, LinkedList<Carte> cartes);
	//Strategie differentes pour annoncer carte ou contre carte;
    public void annoncer();
}
