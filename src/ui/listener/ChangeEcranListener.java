package ui.listener;

import java.util.EventListener;

import javax.swing.JPanel;

import ui.Ecran;

public interface ChangeEcranListener extends EventListener{
	
	public void changeEcran(Ecran ecran);

	public void focus();

	public boolean askShowed();

	void changeEcran(JPanel e);
	

}
