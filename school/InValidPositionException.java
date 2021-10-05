package school;
/**
 * It handles the exception if the user makes invalid choice.
 * @author savant
 */

public class InValidPositionException extends Exception{
	private static final long serialVersionUID = 1L;

	public InValidPositionException(String str) {
		super(str);
	}
}
