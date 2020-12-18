package Exception;

public class ConflictException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * represent type of exception that will be
 	 * to lift when a rule is not respected
	 */


	public ConflictException(String message) {
		super(message);
		
	}

	
	
}
