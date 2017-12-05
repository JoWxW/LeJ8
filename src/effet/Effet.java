/**
 * 
 */
package effet;
import java.util.Observable;

import exception.SaisiNonValideException;
import jeu.Jeu;


/**
 * @author wxw
 *
 */
public abstract class Effet extends Observable{
	private String nom;
	//加了一个attaque的牌数，便于统计，如果有更好的解决办法再删掉
	private int carteAttaque;
	//effet 这个方法是不是传进一个jeu 的objet作为参数，再返回一个jeu，从而完成jeu的更新
	//就是main方法里
	//effet = carte.effet.getEffet();
	//jeu = effet.effet(Jeu jeu)  
	//这个名字要改一下，都是effect，，看起来都有点晕
	public Effet(){}
	/**
	 * @param nom
	 * @throws SaisiNonValideException 
	 */
	
	public abstract Jeu validerSuperpower(Jeu j) throws SaisiNonValideException;
	
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
