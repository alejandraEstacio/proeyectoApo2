package exception;


@SuppressWarnings("serial")
public class RepeatedUserException extends Exception {

	/**
	 * Constructor of the Exception RepeatedUserException
	 * @param name != null, name of the existing user
	 */
	public RepeatedUserException(int name) {
		super("There is already a user with the specified name: "+name);
	}

}