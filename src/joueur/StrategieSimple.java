package joueur;

import java.util.*;
import carte.*;

public class StrategieSimple implements StrategieDeJoueur {
	// ��carte candidate �����ѡһ�ų���
	@Override
	// ���effet��һ��ȫ�µ��ƣ����Ǽ��д����˵�ǰ�������Ե��ƣ���ɫ���������Ƿ��й��ܣ������ֹ��ܣ�������Ϸ����ʱ����֮ǰ�������ֵ
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
