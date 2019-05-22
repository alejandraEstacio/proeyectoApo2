package model;

import java.util.Comparator;


public class ComparatorName implements Comparator<User>{

	@Override
	public int compare(User usuario1, User usuario2) {
		return usuario1.getName().compareToIgnoreCase(usuario2.getName());
	}
	

}
