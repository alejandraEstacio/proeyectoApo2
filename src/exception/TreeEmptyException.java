package exception;


@SuppressWarnings("serial")
public class TreeEmptyException extends Exception {

	/**
	 * Constructor of the exception TreeEmptyException
	 */
	public TreeEmptyException(){
		super("This action could not be performed, the tree is empty");
	}
	
}
