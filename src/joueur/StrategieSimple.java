package joueur;

import java.util.*;
import carte.*;

public class StrategieSimple implements StrategieDeJoueur {
	// 从carte candidate 中随机选一张出牌
	@Override
	// 这个effet是一张全新的牌，就是集中代表了当前玩家所面对的牌，花色、点数、是否有功能，有哪种功能，都在游戏进行时根据之前的情况赋值
	public Carte poser(LinkedList<Carte> carteCandidate, LinkedList<Carte> myCartes) {
		if (carteCandidate.isEmpty()) {
			return null;
		} else {
			int position = (int) ((carteCandidate.size()-1) * Math.random());
			Carte carteChoisit = carteCandidate.get(position);
			carteCandidate.remove(position);
			return carteChoisit;
		}

	}

	@Override
	public void annoncer() {
		// TODO Auto-generated method stub

	}

}
