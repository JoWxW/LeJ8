package jeu;

import java.util.*;

import carte.Carte;
import exception.*;
import joueur.Joueur;

public class TestJeu {
	public static void main(String[] args) {
		Jeu jeu;
		jeu = Jeu.getJeu();
		jeu.derouler();
	}
}
