/**
 * 
 */
package effet;
import java.util.Observable;


/**
 * @author wxw
 *
 */
public class Effet extends Observable{
	private String nom;
	//����һ��attaque������������ͳ�ƣ�����и��õĽ���취��ɾ��
	private int carteAttaque;
	//effet ��������ǲ��Ǵ���һ��jeu ��objet��Ϊ�������ٷ���һ��jeu���Ӷ����jeu�ĸ���
	//����main������
	//effet = carte.effet.getEffet();
	//jeu = effet.effet(Jeu jeu)  
	//�������Ҫ��һ�£�����effect�������������е���
	public Effet(){}
	/**
	 * @param nom
	 */
	/*public Effet(String nom) {
		super();
		this.nom = nom;
	}
	
	public void effectuer(){}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	
	public int getCarteAttaque() {
		return carteAttaque;
	}
	public void setCarteAttaque(int carteAttaque) {
		this.carteAttaque = carteAttaque;
	}
}