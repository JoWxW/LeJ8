package ui;

import javax.swing.JPanel;

import ui.listener.ChangeEcranListener;



public class Ecran extends JPanel {
    private static final long serialVersionUID = 1L;
	
	
	public void addChangeEcranListener(ChangeEcranListener l) {
		listenerList.add(ChangeEcranListener.class,l);
	}

	public void removeChangeEcranListener(ChangeEcranListener l) {
		listenerList.remove(ChangeEcranListener.class, l);
	}
	
	public void demandeFocus() {
		for(final ChangeEcranListener l : listenerList.getListeners(ChangeEcranListener.class))
			l.focus();
	}
	
	public boolean estAffiche() {
		boolean b = true;
		for(final ChangeEcranListener l : listenerList.getListeners(ChangeEcranListener.class))
			b = b && l.askShowed();
		return b && isShowing();
	}

	
	public boolean fermer() {
		return true;
	}
	

	public void changeEcran(Ecran nouveau) {
		for(final ChangeEcranListener l : listenerList.getListeners(ChangeEcranListener.class))
			l.changeEcran(nouveau);
	}
	

}
