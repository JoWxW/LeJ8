package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.ButtonLancerControleur;
import controller.JeuControleur;
import jeu.Jeu;

public class Parametrer extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel window;
	private JPanel bg;
	private JPanel jeuDeCartePanel;
	private JPanel avecJokerPanel;
	private JPanel nbJoueurPanel;
	private JPanel compterPanel;
	private JPanel variantePanel;
	private JPanel difficultePanel;
	// JLabel logo;

	private JButton lancer;
	private JButton quitter;

	private JeuControleur jeuControleur;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jeu j = Jeu.getJeu();
					JeuControleur jeuControleur = new JeuControleur();
					Parametrer parametrer = new Parametrer(j);
					j.add(parametrer);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		

	}

	public Parametrer(Jeu j) {
		jeuControleur = new JeuControleur(j);
		frame = new JFrame("Parametrer");
		lancer = new JButton("Lancer");
		lancer.addActionListener(new LancerListener());
		lancer.setPreferredSize(new Dimension(150, 30));
		quitter = new JButton("Quitter");
		quitter.setPreferredSize(new Dimension(150, 30));
		window = new JPanel();
		bg = new JPanel();
		/*
		 * commencer.addActionListener(this); quitter.addActionListener(this);
		 */

		// ajouter controleur
		// new ButtonLancerControleur(j,lancer);

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

		// les donnees a choisir
		JLabel nbJeu = new JLabel("Nombre de jeu de carte");
		JRadioButton jeu1 = new JRadioButton("1");
		jeu1.setOpaque(false);
		jeu1.addActionListener(new RadioButtonListener());
		JRadioButton jeu2 = new JRadioButton("2");
		jeu2.setOpaque(false);
		jeu2.addActionListener(new RadioButtonListener());
		jeuDeCartePanel = new JPanel();
		jeuDeCartePanel.setOpaque(false);
		jeuDeCartePanel.setLayout(new FlowLayout());
		jeuDeCartePanel.add(nbJeu);
		jeuDeCartePanel.add(jeu1);
		jeuDeCartePanel.add(jeu2);

		JLabel avecJoker = new JLabel("Avec joker?");
		JRadioButton oui = new JRadioButton("oui");
		oui.setOpaque(false);
		oui.addActionListener(new RadioButtonListener());
		JRadioButton non = new JRadioButton("non");
		non.setOpaque(false);
		non.addActionListener(new RadioButtonListener());
		avecJokerPanel = new JPanel();
		avecJokerPanel.setOpaque(false);
		avecJokerPanel.setLayout(new FlowLayout());
		avecJokerPanel.add(avecJoker);
		avecJokerPanel.add(oui);
		avecJokerPanel.add(non);

		JLabel nbJoueur = new JLabel("Nb de joueur");
		JSlider choisirNb = new JSlider(2, 10);
		choisirNb.addChangeListener(new NbJoueursListener());
		choisirNb.setOpaque(false);
		choisirNb.setPaintLabels(true);
		Hashtable<Integer, Component> labelTable = new Hashtable<Integer, Component>();
		for (int i = 2; i <= 10; i++) {
			labelTable.put(i, new JLabel("" + i));
		}
		choisirNb.setLabelTable(labelTable);
		nbJoueurPanel = new JPanel();
		nbJoueurPanel.setOpaque(false);
		nbJoueurPanel.setLayout(new FlowLayout());
		nbJoueurPanel.add(nbJoueur);
		nbJoueurPanel.add(choisirNb);

		JLabel compter = new JLabel("Compter");
		JRadioButton positif = new JRadioButton("positif");
		positif.setOpaque(false);
		positif.addActionListener(new RadioButtonListener());
		JRadioButton negatif = new JRadioButton("negatif");
		negatif.setOpaque(false);
		negatif.addActionListener(new RadioButtonListener());
		compterPanel = new JPanel();
		compterPanel.setOpaque(false);
		compterPanel.setLayout(new FlowLayout());
		compterPanel.add(compter);
		compterPanel.add(positif);
		compterPanel.add(negatif);

		JLabel variante = new JLabel("Variante");
		JComboBox<String> choisirVariante = new JComboBox<String>();
		choisirVariante.addActionListener(new VarianteComboBoxListener());
		choisirVariante.setEditable(true);
		choisirVariante.setEnabled(true);
		choisirVariante.addItem("Variante Minimale");
		choisirVariante.addItem("Variante Monclar");
		choisirVariante.addItem("Variante 1");
		choisirVariante.addItem("Variante 2");
		choisirVariante.addItem("Variante 5");
		variantePanel = new JPanel();
		variantePanel.setOpaque(false);
		variantePanel.setLayout(new FlowLayout());
		variantePanel.add(variante);
		variantePanel.add(choisirVariante);

		JLabel difficulte = new JLabel("Difficulte");
		JComboBox<String> choisirDifficulte = new JComboBox<String>();
		choisirDifficulte.setEditable(true);
		choisirDifficulte.setEnabled(true);
		choisirDifficulte.addItem("Simple");
		choisirDifficulte.addItem("Moyenne");
		choisirDifficulte.addItem("Difficile");
		difficultePanel = new JPanel();
		difficultePanel.setOpaque(false);
		difficultePanel.setLayout(new FlowLayout());
		difficultePanel.add(difficulte);
		difficultePanel.add(choisirDifficulte);

		JPanel something = new JPanel();
		something.setOpaque(false);
		something.setPreferredSize(new Dimension(600, 100));
		something.add(BorderLayout.WEST, quitter);
		something.add(BorderLayout.EAST, lancer);

		// window.add(logo, BorderLayout.CENTER);
		window.add(something, BorderLayout.SOUTH);
		// set la partie au milieu
		JPanel windowCenter = new JPanel();
		windowCenter.setSize(new Dimension(500, 200));
		windowCenter.setBackground(new Color(Integer.decode("#28b772")));
		windowCenter.setLayout(new BoxLayout(windowCenter, BoxLayout.Y_AXIS));
		windowCenter.add(jeuDeCartePanel);
		windowCenter.add(avecJokerPanel);
		windowCenter.add(nbJoueurPanel);
		windowCenter.add(compterPanel);
		windowCenter.add(variantePanel);
		windowCenter.add(difficultePanel);
		

		JPanel windowNorth = new JPanel();
		windowNorth.setOpaque(false);
		windowNorth.setPreferredSize(new Dimension(200, 100));

		JPanel windowWest = new JPanel();
		windowWest.setOpaque(false);
		windowWest.setPreferredSize(new Dimension(100, 200));

		JPanel windowEast = new JPanel();
		windowEast.setOpaque(false);
		windowEast.setPreferredSize(new Dimension(100, 200));

		window.add(windowNorth, BorderLayout.NORTH);
		window.add(windowEast, BorderLayout.EAST);
		window.add(windowWest, BorderLayout.WEST);
		window.add(windowCenter, BorderLayout.CENTER);
		layeredPane.add(window, JLayeredPane.MODAL_LAYER);
		layeredPane.add(bg, JLayeredPane.DEFAULT_LAYER);

		frame.setLayeredPane(layeredPane);
		frame.setLocationRelativeTo(frame.getOwner());
		frame.setResizable(false);
	}

	class RadioButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "1":
				jeuControleur.setNbJeux(1);
				break;
			case "2":
				jeuControleur.setNbJeux(2);
				break;
			case "oui":
				jeuControleur.setAvecJoker(1);
				break;
			case "non":
				jeuControleur.setAvecJoker(0);
				break;
			case "positif":
				jeuControleur.setCompter(1);
				break;
			case "negatif":
				jeuControleur.setCompter(0);
				break;
			}

		}

	}

	class VarianteComboBoxListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Variante Minimale":
				jeuControleur.setVariante(0);
				break;
			case "Variante Monclar":
				jeuControleur.setVariante(11);
				break;
			case "Variante 1":
				jeuControleur.setVariante(1);
				break;
			case "Variante 2":
				jeuControleur.setVariante(2);
				break;
			case "Variante 5":
				jeuControleur.setVariante(5);
				break;
			}

		}

	}

	class DifficulteComcoBoxListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "Simple":
				jeuControleur.setDifficulte(0);
				break;
			case "Moyenne":
				jeuControleur.setDifficulte(1);
				break;
			case "Difficile":
				jeuControleur.setDifficulte(2);
				break;
			}

		}

	}

	class NbJoueursListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {

			JSlider source = (JSlider) e.getSource();
			if (!source.getValueIsAdjusting()) {
				int nb = (int) source.getValue();
				for (int i = 2; i <= 12; i++) {
					if (i == nb) {
						jeuControleur.setNbJoueur(i);
						break;
					}
				}

			}

		}

	}

	class LancerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			jeuControleur.lancer();
			jeuControleur.fermer(frame);
		}

	}

	// a faire
	class QuitterListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	@Override
	public void update(Observable o, Object arg) {
		this.frame.repaint();
		
	}

}
