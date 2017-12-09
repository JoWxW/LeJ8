package action;

import joueur.Joueur;

public class DireMaou extends Action {

	public DireMaou() {
		super();
		this.setNom("Dire Maou");
	}

	public void agir(Joueur jou) {
		if(jou.getCartes().size()==0) {
			System.out.println(jou.toString()+" annonce Maou");
		}else if(jou.getCartes().size()==1) {
			System.out.println(jou.toString()+" annonce Carte");
		}

	}

}
