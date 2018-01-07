package effet;

import exception.SaisiNonValideException;
import jeu.Jeu;

public class DeMemeCouleur extends Effet {
	
	public DeMemeCouleur() {
		super();
		this.setNom("Poser toutes les cartes de meme couleur");
	}

	@Override
	public Jeu validerSuperpower(Jeu j)  {
		
		return null;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
