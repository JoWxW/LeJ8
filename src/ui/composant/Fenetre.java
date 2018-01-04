package ui.composant;

import java.awt.Color;

import javax.swing.JFrame;

public class Fenetre extends JFrame {
	
	public static void main(String[] args) {
		Fenetre f = new Fenetre("BOon");
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public Fenetre(String title) {
		this.setTitle(title);
		this.setSize(800, 600);
		this.setBackground(Color.blue);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//this.setResizable(false);
	}

}
