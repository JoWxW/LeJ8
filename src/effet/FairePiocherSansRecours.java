/**
 * 
 */
package effet;
import exception.SaisiNonValideException;
import jeu.Jeu;
import joueur.Joueur;

public class FairePiocherSansRecours extends FairePiocher {
	private int nbCarte;

	public FairePiocherSansRecours(int nbCarte) {
		super(nbCarte);
		this.setNom("Faire piocher " + nbCarte + " cartes sans recours");

	}

	@Override
	public Jeu validerSuperpower(Jeu j) {
		this.declarer();
		j.renouvelerJouerActuel();
		int nbAPiocher = j.getNbCartePiocher();
		nbAPiocher += nbCarte;
		j.joueurPiocher(nbAPiocher);
		j.setNbcartePiocher(0);
		return j;
	}

	public int getNbCarte() {
		return nbCarte;
	}

	public void setNbCarte(int nbCarte) {
		this.nbCarte = nbCarte;
	}

}
