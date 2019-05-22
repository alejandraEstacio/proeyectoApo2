package exception;


@SuppressWarnings("serial")
public class ScoreNotExistException extends Exception {

	/**
	 * Constructor of the Exception ScoreNotExistException
	 * @param pt != null, non-existent score in the user ABB
	 */
	public ScoreNotExistException(int sc) {
		super("There is no score of: "+sc);
	}
	
}
