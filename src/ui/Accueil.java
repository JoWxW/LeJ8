package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ui.composant.Fenetre;

public class Accueil extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	JFrame frame;
	JPanel window;
	JPanel bg;
	JLabel logo;
	JButton commencer;
	JButton quitter;
	
	public static void main(String[] args) {
		Accueil accueil = new Accueil();
		
	}

	public Accueil() {
		frame = new JFrame("Accueil");
		commencer = new JButton("Commencer");
		commencer.setPreferredSize(new Dimension(150,30));
		quitter = new JButton("Quitter");
		quitter.setPreferredSize(new Dimension(150,30));
		window = new JPanel();
		bg = new JPanel();
		commencer.addActionListener(this);
		quitter.addActionListener(this);

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
		something.setPreferredSize(new Dimension(600,150));
		something.add(BorderLayout.WEST,quitter);
		something.add(BorderLayout.EAST,commencer);
		
		window.add(logo, BorderLayout.CENTER);
		window.add(something,BorderLayout.SOUTH);
	
		layeredPane.add(window, JLayeredPane.MODAL_LAYER);
		layeredPane.add(bg, JLayeredPane.DEFAULT_LAYER);
		

		frame.setLayeredPane(layeredPane);
		frame.setLocationRelativeTo(frame.getOwner());
		frame.setResizable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() =="Commencer") {
			
		}else if (e.getSource() == "Quitter") {
			
		}

	}

}
