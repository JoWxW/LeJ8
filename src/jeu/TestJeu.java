package jeu;

public class TestJeu {
	public static void main(String[] args){
		Jeu jeu;
		jeu = Jeu.getJeu();
		jeu.paramtrerJeu();
		System.out.println(Jeu.AVEC_JOKER + "" + Jeu.NOMBRE_DE_JEUX + "" + Jeu.NOMBRE_DE_JOUEURS);
	}
}
