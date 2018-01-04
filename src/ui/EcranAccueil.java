package ui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;



public class EcranAccueil extends Ecran implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private ImageIcon fond;
	private JLabel panelAccueil;
	private JButton commencer;
	private JButton quitter;
	
	public EcranAccueil() {
		fond = new ImageIcon("source/fond.jpg");
		panelAccueil =new JLabel(fond);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
