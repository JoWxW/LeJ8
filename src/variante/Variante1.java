package variante;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import carte.Carte;
import effet.*;
import joueur.Joueur;

public class Variante1 extends Variante {

	public Variante1() {
		super();
		this.setNom("Variante 1");
		this.setNumero("1");
	}

	@Override
	public void addEffet(LinkedList<Carte> tas,ArrayList<Joueur> joueurs) {
		ObligeRejouer obligeReJouer = new ObligeRejouer();
		FairePiocher fairePiocher2 = new FairePiocher(2);
		PasserSonTour passerSonTour = new PasserSonTour();
		ChangerSens changerSens = new ChangerSens();
		SecretDeRoiEtDame roiEtDame = new SecretDeRoiEtDame();
		FairePiocher fairePiocher1 = new FairePiocher(1);
		PiocherDeLaMain piocherDeLaMain = new PiocherDeLaMain();
		DonnerDeuxCartes donnerDeuxCartes = new DonnerDeuxCartes();
		Dire4 dire4 = new Dire4();
		ArreterAttaque effetDe5 = new ArreterAttaque();
		PasserMonTourAGauche passerMonTourAGauche = new PasserMonTourAGauche();
		ChangerForme changerForme = new ChangerForme();

		Iterator<Carte> it = tas.iterator();
		while (it.hasNext()) {
			Carte c = it.next();
			if (c.getEffet().size() == 0) {
				switch (c.getValeur().getId()) {
				case 2:
					c.addEffetVariante(fairePiocher2);
					break;
				case 10:
					c.addEffetVariante(obligeReJouer);
					break;
				case 7:
					c.addEffetVariante(passerSonTour);
					break;
				case 11:
					c.addEffetVariante(changerSens);
					break;
				case 12:
				case 13:
					c.addEffetVariante(roiEtDame);
					break;
				case 6:
					c.addEffetVariante(fairePiocher1);
					break;
				case 9:
					c.addEffetVariante(piocherDeLaMain);
					break;
				case 1:
					c.addEffetVariante(donnerDeuxCartes);
					break;
				case 4:
					c.addEffetVariante(dire4);
					break;
				case 5:
					c.addEffetVariante(effetDe5);
					break;
				case 3:
					if (c.getForme().getId() == 1) {
						c.addEffetVariante(passerMonTourAGauche);
					}
					break;
				case 8:
					c.addEffetVariante(changerForme);
					break;
				}
			}
		}

	}

}
