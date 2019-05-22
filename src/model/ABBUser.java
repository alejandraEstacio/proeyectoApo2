package model;

import java.io.Serializable;

import exception.RepeatedUserException;
import exception.UsersNotExistException;

@SuppressWarnings("serial")

public class ABBUser implements Serializable {
	
	private User root;
	public ABBUser() {
		root = null;
	}
	
	/**
	 * @return the root
	 */
	public User getRoot() {
		return root;
	}
	
	/**
	 * @param root the root to set
	 */
	public void setRoot(User root) {
		this.root = root;
	}
	
	/**
	 * This method adds a new user to the search binary tree if the root is null
	 * otherwise it calls the recursive method insert of the user class 
	 * @param current != null
	 * @param nuevo != null, new user of the add
	 * @throws RepeatedUserException if the user is already registered with the same name
	 */
	public void add(User current, User nuevo) throws RepeatedUserException {
		if(root==null) {
			root=nuevo;
		}else {
			root.insert(nuevo);
		}
	}

	/**
	 * the recursive method searches for a user in the binary search tree
	 * @param current !=null, current user of the tree route 
	 * @param name of he user to search 
	 * @return the user search 
	 * @throws UserioNotExistException if a user is not found with the name entered by parameter
	 */
	public User search(User current, String name) throws UsersNotExistException {
		if(current.getName()==name) {
			return current;
		}else {
			if(name.compareToIgnoreCase(current.getName())<1) {
				if(current.getLeft()!=null) {
					return search(current.getLeft(), name);
				}else {
					throw new UsersNotExistException(name);
				}
			}else {
				if(current.getRight()!=null) {
					return search(current.getRight(), name);
				}else {
					throw new UsersNotExistException(name);
				}
			}
		}
	}
	/**
	 * this method call the method recursive remove
	 * @param name != null
	 */
	
	public void remove(String name) {
		root=root.remove(name);
	}

}
