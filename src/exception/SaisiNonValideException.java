package exception;

public class SaisiNonValideException extends Exception{
	private static final Long serieVersionUID = 1L ;
	public SaisiNonValideException(String m ) {
		super(m);
	}
	
	public SaisiNonValideException() {
		System.out.println("Le saisi est incorrecte, il faut un entier");
	}
 
}
