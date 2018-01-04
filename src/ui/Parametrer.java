package ui;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Hashtable;

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

public class Parametrer extends JPanel {
	
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
	//JLabel logo;
	
	private JButton commencer;
	private JButton quitter;
	
	public static void main(String[] args) {
		Parametrer parametrer = new Parametrer();
		
	}

	public Parametrer() {
		frame = new JFrame("Parametrer");
		commencer = new JButton("Commencer");
		commencer.setPreferredSize(new Dimension(150,30));
		quitter = new JButton("Quitter");
		quitter.setPreferredSize(new Dimension(150,30));
		window = new JPanel();
		bg = new JPanel();
		/*commencer.addActionListener(this);
		quitter.addActionListener(this);*/

		frame.setSize(800, 600);
		frame.setBackground(new Color(Integer.decode("#6a0d77")));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		ImageIcon image = new ImageIcon("sources/fond.jpg");
		/*ImageIcon imagLogo = new ImageIcon("sources/logo.png");
		logo = new JLabel(imagLogo);*/
		
		 // background
		JLabel bgimage = new JLabel(image); // background image
		bg.setBounds(0, -5, image.getIconWidth(), image.getIconHeight());
		bg.add(bgimage);
		JLayeredPane layeredPane = new JLayeredPane();
		window.setBounds(0, -5, image.getIconWidth(), image.getIconHeight());
		window.setLayout(new BorderLayout(5, 5)); // window.setLayout(new GridLayout(3, 5, 5, 5));
		window.setOpaque(false);
		
		//les donnees a choisir
		JLabel nbJeu = new JLabel("Nombre de jeu de carte");
		JRadioButton jeu1 = new JRadioButton("1");
		JRadioButton jeu2 = new JRadioButton("2");
		jeuDeCartePanel = new JPanel();
		jeuDeCartePanel.setOpaque(false);
		jeuDeCartePanel.setLayout(new FlowLayout());
		jeuDeCartePanel.add(nbJeu);
		jeuDeCartePanel.add(jeu1);
		jeuDeCartePanel.add(jeu2);
		
		JLabel avecJoker = new JLabel("Avec joker?");
		JRadioButton oui = new JRadioButton("oui");
		JRadioButton non = new JRadioButton("non");
		avecJokerPanel = new JPanel();
		avecJokerPanel.setOpaque(false);
		avecJokerPanel.setLayout(new FlowLayout());
		avecJokerPanel.add(avecJoker);
		avecJokerPanel.add(oui);
		avecJokerPanel.add(non);
		
		JLabel nbJoueur = new JLabel("Nb de joueur");
		JSlider choisirNb = new JSlider(2,12);
		choisirNb.setOpaque(false);
		choisirNb.setPaintLabels(true);
		Hashtable<Integer, Component> labelTable = new Hashtable<Integer, Component>();
        for(int i =2;i<=12;i++) {
        	labelTable.put(i,new JLabel(""+i));
        }
        choisirNb.setLabelTable(labelTable);
		nbJoueurPanel = new JPanel();
		nbJoueurPanel.setOpaque(false);
		nbJoueurPanel.setLayout(new FlowLayout());
		nbJoueurPanel.add(nbJoueur);
		nbJoueurPanel.add(choisirNb);
		
		JLabel compter = new JLabel("Compter");
		JRadioButton positif = new JRadioButton("positif");
		JRadioButton negatif = new JRadioButton("negatif");
		compterPanel = new JPanel();
		compterPanel.setOpaque(false);
		compterPanel.setLayout(new FlowLayout());
		compterPanel.add(compter);
		compterPanel.add(positif);
		compterPanel.add(negatif);
		
		JLabel variante = new JLabel("Variante");
		JComboBox<String> choisirVariante = new JComboBox<String>();
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
		
		JLabel difficulte = new JLabel("Defficulte");
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
		something.setPreferredSize(new Dimension(600,100));
		something.add(BorderLayout.WEST,quitter);
		something.add(BorderLayout.EAST,commencer);
		
		//window.add(logo, BorderLayout.CENTER);
		window.add(something,BorderLayout.SOUTH);
		//set la partie au milieu
		JPanel windowCenter = new JPanel();
		windowCenter.setSize(new Dimension(500,200));
		windowCenter.setBackground(new Color(Integer.decode("#28b772")));
		windowCenter.setLayout(new BoxLayout(windowCenter,BoxLayout.Y_AXIS));
		windowCenter.add(jeuDeCartePanel);
		windowCenter.add(avecJokerPanel);
		windowCenter.add(nbJoueurPanel);
		windowCenter.add(compterPanel);
		windowCenter.add(variantePanel);
		windowCenter.add(difficultePanel);
		
		JPanel windowNorth = new JPanel();
		windowNorth.setOpaque(false);
		windowNorth.setPreferredSize(new Dimension(200,100));
		
		JPanel windowWest = new JPanel();
		windowWest.setOpaque(false);
		windowWest.setPreferredSize(new Dimension(100,200));
		
		JPanel windowEast = new JPanel();
		windowEast.setOpaque(false);
		windowEast.setPreferredSize(new Dimension(100,200));
		
		window.add(windowNorth,BorderLayout.NORTH);
		window.add(windowEast,BorderLayout.EAST);
		window.add(windowWest,BorderLayout.WEST);
		window.add(windowCenter,BorderLayout.CENTER);
		layeredPane.add(window, JLayeredPane.MODAL_LAYER);
		layeredPane.add(bg, JLayeredPane.DEFAULT_LAYER);
		

		frame.setLayeredPane(layeredPane);
		frame.setLocationRelativeTo(frame.getOwner());
		frame.setResizable(false);
	}
	
	

	
	
	

}
