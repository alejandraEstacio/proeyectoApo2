package exception;


@SuppressWarnings("serial")
public class UsersNotExistException extends Exception {

	/**
	 * Constructor of the exception UsersNotExistException
	 * @param name != null, name of the user who can not be found in the ABB users
	 */
	public UsersNotExistException(String name) {
		super("No user with the specified name was found: "+name);
	}
	
}
