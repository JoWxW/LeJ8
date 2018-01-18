package ui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChoisirCouleur implements Observer{
	private JFrame frame;
	private JLabel label;
	private JButton pique;
	private JButton coeur;
	private JButton Carreau;
	private JButton trefle;
	
	
	public ChoisirCouleur() {
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
