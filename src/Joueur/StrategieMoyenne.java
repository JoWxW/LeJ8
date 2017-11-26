package Joueur;

import java.util.*;

import carte.Carte;

public class StrategieMoyenne implements StrategieDeJoueur {
	// 从carte candidate中选出自己最多的手牌出（颜色） 有功能牌先出功能牌

	@Override
	public Carte poser(LinkedList<Carte> carteCandidate, LinkedList<Carte> myCartes) {
		if (carteCandidate.isEmpty()) {
			return null;
		} else {
			int nbPique = 0;
			int nbCoeur = 0;
			int nbCarreau = 0;
			int nbTrefle = 0;
			Iterator<Carte> it = myCartes.iterator();
			LinkedList<Carte> carteEffet = new LinkedList<Carte>();
			while (it.hasNext()) {
				Carte c = it.next();
				switch (c.getForme().getId()) {
				case 0:
					nbPique++;
				case 1:
					nbCoeur++;
				case 2:
					nbCarreau++;
				case 3:
					nbTrefle++;
				}
				if (!(c.getEffet().isEmpty())) {
					carteEffet.add(c);
				}
			}
			if (carteEffet.isEmpty()) {
				int nbMax = choisirMax(nbPique, nbCoeur, nbCarreau, nbTrefle);
				Iterator<Carte> ite = carteCandidate.iterator();
				while (ite.hasNext()) {
					Carte c = ite.next();
					if (c.getForme().getId() != nbMax) {
						ite.remove();
					}
				}

				int position = (int) (carteCandidate.size() * Math.random());
				return carteCandidate.get(position);
			} else {
				int position = (int) (carteEffet.size() * Math.random());
				return carteEffet.get(position);
			}
		}

	}

	@Override
	public void annoncer() {
		// TODO Auto-generated method stub

	}

	public int choisirMax(int a, int b, int c, int d) {
		if (a >= b && a >= c && a >= d) {
			return 0;
		} else if (b > a && b >= c && b >= d) {
			return 1;
		} else if (c > a && c > b && c >= d) {
			return 2;
		} else {
			return 3;
		}

	}

}
