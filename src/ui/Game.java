package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import carte.Carte;
import controller.JeuControleur;
import jeu.Jeu;
import ui.composant.CarteButton;

public class Game implements Observer {

	private JFrame frame;
	private JPanel window;
	private JPanel bg;
	private JButton piocher;
	private JButton poser;
	private JPanel[] joueurs;
	private JPanel windowCenter;
	private JPanel windowNorth;
	private JPanel windowSouth;
	private JPanel windowEast;
	private JPanel windowWest;
	private JeuControleur jeuControleur;
	private int nbJoueurs;
	private JLabel carteActuelle;
	private JPanel carteMainPanel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jeu j = Jeu.getJeu();
					Game game = new Game(j);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public Game(Jeu j) {
		initialiser(j);

	}

	public void initialiser(Jeu j) {
		jeuControleur = new JeuControleur(j);
		frame = new JFrame("Game");
		window = new JPanel();
		bg = new JPanel();
		/*
		 * commencer.addActionListener(this); quitter.addActionListener(this);
		 */

		frame.setSize(800, 600);
		frame.setBackground(new Color(Integer.decode("#6a0d77")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		ImageIcon image = new ImageIcon("sources/fond.jpg");
		/*
		 * ImageIcon imagLogo = new ImageIcon("sources/logo.png"); logo = new
		 * JLabel(imagLogo);
		 */

		// background
		JLabel bgimage = new JLabel(image); // background image
		bg.setBounds(0, -5, image.getIconWidth(), image.getIconHeight());
		bg.add(bgimage);
		JLayeredPane layeredPane = new JLayeredPane();
		window.setBounds(0, -5, image.getIconWidth(), image.getIconHeight());
		window.setLayout(new BorderLayout(5, 5)); // window.setLayout(new GridLayout(3, 5, 5, 5));
		window.setOpaque(false);

		windowCenter = new JPanel();
		windowCenter.setOpaque(false);
		window.setPreferredSize(new Dimension(200, 200));
		windowCenter.setBorder(BorderFactory.createLineBorder(Color.white, 3));

		windowNorth = new JPanel();
		windowNorth.setOpaque(false);
		windowNorth.setPreferredSize(new Dimension(800, 200));
		windowNorth.setBorder(BorderFactory.createLineBorder(Color.white, 3));

		windowSouth = new JPanel();
		windowSouth.setOpaque(false);
		windowSouth.setPreferredSize(new Dimension(800, 200));
		windowSouth.setBorder(BorderFactory.createLineBorder(Color.white, 3));

		windowWest = new JPanel();
		windowWest.setOpaque(false);
		windowWest.setPreferredSize(new Dimension(100, 200));
		windowWest.setBorder(BorderFactory.createLineBorder(Color.white, 3));

		windowEast = new JPanel();
		windowEast.setOpaque(false);
		windowEast.setPreferredSize(new Dimension(100, 200));
		windowEast.setBorder(BorderFactory.createLineBorder(Color.white, 3));

		window.add(windowNorth, BorderLayout.NORTH);
		window.add(windowSouth, BorderLayout.SOUTH);
		window.add(windowEast, BorderLayout.EAST);
		window.add(windowWest, BorderLayout.WEST);

		window.add(windowCenter, BorderLayout.CENTER);
		layeredPane.add(window, JLayeredPane.MODAL_LAYER);
		layeredPane.add(bg, JLayeredPane.DEFAULT_LAYER);

		frame.setLayeredPane(layeredPane);
		frame.setLocationRelativeTo(frame.getOwner());
		frame.setResizable(false);

		ImageIcon ico = new ImageIcon("sources/1-1.png");
		nbJoueurs = Jeu.getNombreDeJoueurs();
		windowNorth.setLayout(new FlowLayout());
		joueurs = new JPanel[nbJoueurs - 1];
		// System.out.println(windowNorth.getWidth());
		for (int i = 0; i < nbJoueurs - 1; i++) {
			JLabel cardImage = new JLabel(ico);
			JPanel joueur = new JPanel();
			joueur.setOpaque(false);
			joueur.setBorder(BorderFactory.createLineBorder(Color.white, 1));
			joueur.setLayout(new BorderLayout());
			joueur.setPreferredSize((new Dimension((int) (750 / (nbJoueurs - 1)), 175)));
			joueur.add(cardImage);
			JLabel nbCarte = new JLabel("NB cartes: " + j.getJoueurs().get(i).getCartes().size());
			nbCarte.setPreferredSize(new Dimension(20, 15));
			nbCarte.setForeground(Color.WHITE);
			joueur.add(nbCarte, BorderLayout.SOUTH);

			joueurs[i] = joueur;
			windowNorth.add(joueur);

		}
		ImageIcon icoCartes = new ImageIcon("sources/cards.png");
		JLabel cartesImage = new JLabel(icoCartes);
		windowCenter.setLayout(new FlowLayout());
		windowCenter.add(cartesImage);

		JPanel vide = new JPanel();
		vide.setOpaque(false);
		vide.setPreferredSize(new Dimension(100, 100));
		windowCenter.add(vide);
		// il faut choisir la carte correspondante
		ImageIcon icoCarteActuelle = new ImageIcon("sources/" + j.getCarteActuelle().getId() + ".gif");
		carteActuelle = new JLabel(icoCarteActuelle);
		windowCenter.add(carteActuelle);

		// Les Cartes de joueur physique
		LinkedList<Carte> cartes = j.getJoueurs().get(Jeu.getNombreDeJoueurs() - 1).getCartes();
		int nbCarte = cartes.size();
		windowSouth.setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(new FlowLayout());

		piocher = new JButton("Piocher");
		piocher.addActionListener(new piocherListener());
		poser = new JButton("poser");
		buttonPanel.add(piocher);
		buttonPanel.add(poser);
		buttonPanel.setPreferredSize(new Dimension(800, 30));

		carteMainPanel =construireCarteEnMain(j);
		carteMainPanel.setPreferredSize(new Dimension(800, 160));
		windowSouth.add(buttonPanel, BorderLayout.NORTH);
		windowSouth.add(carteMainPanel, BorderLayout.SOUTH);
		// classe interne pour definir la carte
		// classe extends JButton implements MouseListener
		// JButton[] cartesEnMain = new JButton[nbCarte];
	}

	class piocherListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			jeuControleur.joueurPhysiquePiocher();
		}

	}

	class PoserListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			jeuControleur.joueurPhysiquePoser(e.getActionCommand());

		}

	}
	
	class CarteListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

	public void update(Observable o, Object arg) {
		Jeu j = (Jeu) o;
		if (arg == "carteActuelle") {
			ImageIcon icoCarteActuelle = new ImageIcon("sources/" + j.getCarteActuelle().getId() + ".gif");
			JLabel nouvelleCarte = new JLabel(icoCarteActuelle);
			windowCenter.remove(carteActuelle);
			windowCenter.add(nouvelleCarte);
			carteActuelle = nouvelleCarte;
			windowCenter.updateUI();
			//update la carte de joueur physique
			windowSouth.remove(carteMainPanel);
			carteMainPanel.removeAll();
			carteMainPanel = this.construireCarteEnMain(j);
			windowSouth.add(carteMainPanel, BorderLayout.SOUTH);
			carteMainPanel.updateUI();
			windowSouth.updateUI();
		} else if (arg == "carteEnMain") {
			windowSouth.remove(carteMainPanel);
			carteMainPanel.removeAll();
			carteMainPanel = this.construireCarteEnMain(j);
			windowSouth.add(carteMainPanel, BorderLayout.SOUTH);
			carteMainPanel.updateUI();
			windowSouth.updateUI();
		}else if(arg == "carteAPoser") {
			windowSouth.remove(carteMainPanel);
			carteMainPanel.removeAll();
			carteMainPanel = this.construireCarteCandidate(j);
			windowSouth.add(carteMainPanel, BorderLayout.SOUTH);
			carteMainPanel.updateUI();
			windowSouth.updateUI();
		}
	}
	
	public JPanel construireCarteEnMain(Jeu j) {
		JPanel carteMain = new JPanel();
		carteMain.setOpaque(false);
		carteMain.setLayout(new FlowLayout(0));
		LinkedList<Carte> cartes = j.getJoueurs().get(j.getJoueurs().size()-1).getCartes();
		Iterator<Carte> it = cartes.iterator();
		while (it.hasNext()) {
			Carte c = it.next();
			
			CarteButton carte = new CarteButton(c.getId());
			carte.addActionListener(new PoserListener());
			
			carteMain.add(carte);
		}
		return carteMain;
	}
	
	public JPanel construireCarteCandidate(Jeu j) {
		JPanel carteMain = new JPanel();
		carteMain.setOpaque(false);
		carteMain.setLayout(new FlowLayout(0));
		LinkedList<Carte> cartes = j.getJoueurs().get(j.getJoueurs().size()-1).getCarteCandidate(j.getCarteActuelle());
		Iterator<Carte> it = cartes.iterator();
		while (it.hasNext()) {
			Carte c = it.next();
			
			CarteButton carte = new CarteButton(c.getId());
			carte.addActionListener(new PoserListener());
			
			carteMain.add(carte);
		}
		return carteMain;
	}

}
