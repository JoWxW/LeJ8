package variante;

import java.util.Iterator;
import java.util.LinkedList;

import carte.Carte;
import effet.*;

public class Variante1 extends Variante {

	public Variante1() {
		super();
		this.setNom("Variante 1");
		this.setNumero("1");
	}

	@Override
	public void addEffet(LinkedList<Carte> tas) {
		ObligeRejouer obligeReJouer = new ObligeRejouer();
		FairePiocher fairePiocher2 = new FairePiocher(2);
		PasserSonTour passerSonTour = new PasserSonTour();
		ChangerSens changerSens = new ChangerSens();
		SecretDeRoiEtDame roiEtDame = new SecretDeRoiEtDame();
		FairePiocher fairePiocher1 = new FairePiocher(1);
		PiocherDeLaMain piocherDeLaMain = new PiocherDeLaMain();
		DonnerDeuxCartes donnerDeuxCartes = new DonnerDeuxCartes();
		Dire4 dire4 = new Dire4();
		ChangerFormeArreterAttaqueCouleurFixe effetDe5 = new ChangerFormeArreterAttaqueCouleurFixe();
		PasserMonTourAGauche passerMonTourAGauche = new PasserMonTourAGauche();
		ChangerForme changerForme = new ChangerForme();

		Iterator<Carte> it = tas.iterator();
		while (it.hasNext()) {
			Carte c = it.next();
			if (c.getEffet().size() == 0) {
				switch (c.getValeur().getId()) {
				case 2:
					c.addEffet(fairePiocher2);
					c.setEffectValide(fairePiocher2);
					break;
				case 10:
					c.addEffet(obligeReJouer);
					c.setEffectValide(obligeReJouer);
					break;
				case 7:
					c.addEffet(passerSonTour);
					c.setEffectValide(passerSonTour);
					break;
				case 11:
					c.addEffet(changerSens);
					c.setEffectValide(changerSens);
					break;
				case 12:
				case 13:
					c.addEffet(roiEtDame);
					c.setEffectValide(roiEtDame);
					break;
				case 6:
					c.addEffet(fairePiocher1);
					c.setEffectValide(fairePiocher1);
					break;
				case 9:
					c.addEffet(piocherDeLaMain);
					c.setEffectValide(piocherDeLaMain);
					break;
				case 1:
					c.addEffet(donnerDeuxCartes);
					c.setEffectValide(donnerDeuxCartes);
					break;
				case 4:
					c.addEffet(dire4);
					c.setEffectValide(dire4);
					break;
				case 5:
					c.addEffet(effetDe5);
					c.setEffectValide(effetDe5);
					break;
				case 3:
					if (c.getForme().getId() == 1) {
						c.addEffet(passerMonTourAGauche);
						c.setEffectValide(passerMonTourAGauche);
					}
					break;
				case 8:
					c.addEffet(changerForme);
					c.setEffectValide(changerForme);
					break;
				}
			}
		}

	}

}
