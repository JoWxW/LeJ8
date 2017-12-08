package exception;

public class JeuDejaArreteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JeuDejaArreteException(String m) {
		super(m);
	}

	public JeuDejaArreteException() {
		System.out.println("Le jeu est deja arrte");
	}
}
