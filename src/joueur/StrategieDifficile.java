package joueur;

import java.util.LinkedList;

import carte.Carte;

public class StrategieDifficile implements StrategieDeJoueur {
	/*1：不要轻易发出功能牌，特别是惩罚牌，有时候可以自救；
	2：尽量保证手里的花色多样化；
	3：尽量保持手里牌的数值差异化；
	4：反转牌和跳转牌要恰当使用，如果自己周围有人uno了（就是手里只剩一张牌的时候，这个时候这样的牌很好用）；
	5：花色牌先出分值大的，就算手里牌多，但是分值少也不会输掉；*/
	@Override
	public Carte poser(LinkedList<Carte> carteCandidate, LinkedList<Carte> cartes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void annoncer() {
		// TODO Auto-generated method stub

	}

}
