package Exception;

public class DontExist extends RuntimeException {

	
	/**
	 *represent type of exception that will be
 	 * to lift when you try to use an unexisting object
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DontExist(String message) {
		super(message);
		
	}


}
