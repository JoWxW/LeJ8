package ui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.listener.ChangeEcranListener;


public class MainFrame extends JFrame implements ChangeEcranListener{
	private static final long serialVersionUID = 1L;
	private Ecran ecran;
	
	public static void main(String[] args) {
		Accueil ea = new Accueil();
		MainFrame frame = new MainFrame(ea);
		frame.setVisible(true);
	}
	
	public MainFrame() {
		this.setSize(new Dimension(800, 600));
		this.setLocationRelativeTo(getRootPane());
		//this.setIconImage(Images.getInstance().getImage("icone_16.png"));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public MainFrame(JPanel ecran) {
		this();
		changeEcran(ecran);
		setVisible(true);
	}

	@Override
	public void changeEcran(JPanel e) {
		if(ecran != null) {
			ecran.removeChangeEcranListener(this);
			ecran.fermer();
		}
		if(e == null) {
			dispose();
		} else {
			//ecran = e;
			//e.addChangeEcranListener(this);
			setTitle("Crazy 8 - " + e.getName());
			setContentPane(e);
			validate();
			repaint();
		}
		
	}

	@Override
	public void focus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean askShowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void changeEcran(Ecran ecran) {
		// TODO Auto-generated method stub
		
	}
	
	

}
