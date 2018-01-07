package effet;

import exception.SaisiNonValideException;
import jeu.Jeu;

public class Dire4 extends Effet {

	public Dire4() {
		super();
		this.setNom("Dire 4");
	}

	@Override
	public Jeu validerSuperpower(Jeu j) {
		System.out.println(j.getJoueurActuel().toString() + " annonce 4");
		return j;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
