package joueur;

import java.util.*;
import carte.*;

public class StrategieSimple implements StrategieDeJoueur {
	@Override
	
	public Carte poser(LinkedList<Carte> carteCandidate, LinkedList<Carte> myCartes) {
		if (carteCandidate.isEmpty()) {
			return null;
		} else {
			int position = (int) ((carteCandidate.size() - 1) * Math.random());
			Carte carteChoisit = carteCandidate.get(position);
			carteCandidate.remove(position);
			return carteChoisit;
		}

	}

	@Override
	public void annoncer() {
		// TODO Auto-generated method stub

	}

	public String toString() {
		return ("Strategie simples");
	}

}
