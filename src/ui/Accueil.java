package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.ButtonCommencerControleur;
import controller.JeuControleur;
import jeu.Jeu;
import ui.composant.Fenetre;

public class Accueil implements Runnable{

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel window;
	private JPanel bg;
	private JLabel logo;
	private JButton commencer;
	private JButton quitter;
	private JeuControleur jeuControleur;
	private Jeu j;
	private Thread thread;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    Jeu j = Jeu.getJeu();
					new Accueil(j);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});

	}
	
	@Override
	public void run() {
		//frame.repaint();
		
	}

	public Accueil(Jeu jeu) {
		thread= new Thread(this);
		thread.start();
		j =jeu;
		jeuControleur = new JeuControleur(j);
		frame = new JFrame("Accueil");
		commencer = new JButton("Commencer");
		commencer.addActionListener(new CommencerListener());
		commencer.setPreferredSize(new Dimension(150, 30));
		quitter = new JButton("Quitter");
		quitter.setPreferredSize(new Dimension(150, 30));
		window = new JPanel();
		bg = new JPanel();
		// commencer.addActionListener(this);
		// quitter.addActionListener(this);
		
		//ajouter controleur
		//new ButtonCommencerControleur(j,commencer);

		frame.setSize(800, 600);
		frame.setBackground(Color.blue);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		ImageIcon image = new ImageIcon("sources/fond.jpg");
		ImageIcon imagLogo = new ImageIcon("sources/logo.png");
		logo = new JLabel(imagLogo);

		// background
		JLabel bgimage = new JLabel(image); // background image
		bg.setBounds(0, -5, image.getIconWidth(), image.getIconHeight());
		bg.add(bgimage);
		JLayeredPane layeredPane = new JLayeredPane();
		window.setBounds(0, -5, image.getIconWidth(), image.getIconHeight());
		window.setLayout(new BorderLayout(5, 5)); // window.setLayout(new GridLayout(3, 5, 5, 5));
		window.setOpaque(false);
		JPanel something = new JPanel();
		something.setOpaque(false);
		something.setPreferredSize(new Dimension(600, 150));
		something.add(BorderLayout.WEST, quitter);
		something.add(BorderLayout.EAST, commencer);

		window.add(logo, BorderLayout.CENTER);
		window.add(something, BorderLayout.SOUTH);

		layeredPane.add(window, JLayeredPane.MODAL_LAYER);
		layeredPane.add(bg, JLayeredPane.DEFAULT_LAYER);

		frame.setLayeredPane(layeredPane);
		frame.setLocationRelativeTo(frame.getOwner());
		frame.setResizable(false);

	}
	
	class CommencerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			jeuControleur.commencer();
			//jeuControleur.fermer(frame);
			frame.dispose();
		}

	}

	
}
