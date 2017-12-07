/**
 * 
 */
package effet;
import exception.SaisiNonValideException;
import jeu.Jeu;
import joueur.Joueur;

public class FairePiocherSansRecours extends Effet {
	private int nbCarte;

	public FairePiocherSansRecours(int nbCarte) {
		super();
		this.setNbCarte(nbCarte);
		this.setNom("Faire piocher " + nbCarte + " cartes sans recours");

	}

	@Override
	public Jeu validerSuperpower(Jeu j) {
		this.declarer();
		j.renouvelerJouerActuel();
		j.joueurPiocher(nbCarte);
		j.setNbcartePiocher(0);
		return null;
	}

	public int getNbCarte() {
		return nbCarte;
	}

	public void setNbCarte(int nbCarte) {
		this.nbCarte = nbCarte;
	}

}
