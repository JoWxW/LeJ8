package action;

import joueur.Joueur;

public class NoAction extends Action {
	public NoAction() {
		super();
		this.setNom("No ACtion");
	}

	public void agir(Joueur jou) {
		if(jou.getCartes().size()==1) {
			System.out.println(jou.toString()+" annonce Carte");
		}
	}

}
