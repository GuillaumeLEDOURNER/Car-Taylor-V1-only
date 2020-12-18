package Exception;

public class AlreadyPresent extends RuntimeException {

	/**
	 * class that represent type of exception that will be
 	 *	to lift when a when you try to add an existing partType
	 */
	private static final long serialVersionUID = 1L;
		
	public AlreadyPresent(String message) {
		super(message);
		
	}
}
