package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import exception.TreeEmptyException;
import exception.ScoreNotExistException;
import exception.RepeatedUserException;


@SuppressWarnings("serial")
public class VideoGame implements Serializable{

	public static final int LONG_WINDOW=360;
	public static final int WIDTH_WINDOW=621;
	
	private User user;
	private ABBUser treeUser;
	
	private EnemyBoss eB;
	
	private EnemyList  listaEnemigos;
	
	/**
	 *buider of the class Game
	 */
	public VideoGame() {		
		loadEnemy();
	    loadBoss();
	}
	
	/**
	 * Method that loads the users of a serialized file
	 * @param name != null
	 * @throws RepeatedUserException If you try to add the user, find an existing user with the same name
	 */
	public void LoadUser(String name,int id, int age, String gender) throws RepeatedUserException{
		try {
			ObjectInputStream loadUsers=new ObjectInputStream(new FileInputStream("src/usuarios/arbol.dat"));
			treeUser=(ABBUser)loadUsers.readObject();
			loadUsers.close();
		}catch(Exception e) {
			treeUser=new ABBUser();
		}finally {
			user= new User(name, id, age, gender);
			treeUser.add(treeUser.getRoot(), user);
		}
	}
	
	/**
	 * Method that serializes the binary tree of the users' ship
	 */
	public void saveUser() {
		try {
			ObjectOutputStream salvar=new ObjectOutputStream(new FileOutputStream("src/usuarios/arbol.dat"));
			salvar.writeObject(treeUser);
			salvar.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que carga los enemigos desde un archivo serializado
	 */
	public void loadEnemy() {
		try {
			ObjectInputStream load=new ObjectInputStream(new FileInputStream("src/save/NormalEnemies.dat"));
			listaEnemigos=(EnemyList) load.readObject();
			load.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que lee un archivo de texto e instancia un nuevo EnemigoBoss con los
	 * valores obtenidos del archivo de texto
	 */
	public void loadBoss() {
		try {
			BufferedReader reader=new BufferedReader(new FileReader("src/save/Boss.txt"));
			String linea=reader.readLine();
			String[] str=linea.split(",");
			eB=new EnemyBoss(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), str[3], Boolean.parseBoolean(str[4]), str[5].charAt(0) );
			reader.close();
		} catch (Exception e) {

		}
	}
	
	/**
	 * Metodo que busca el mayor puntaje de todos los usuario
	 * @return El mayor puntaje de entre todos los usuarios
	 * @throws TreeEmptyException Si se intenta llamar este metodo cuando el arbol esta vacio
	 */
	public int SearchHigherScore() throws TreeEmptyException {
		int higher=0;
		ArrayList<User> users=arrayUser();
		if(users.size()==0) {
			throw new TreeEmptyException();
		}else {
			for(int i=1;i<users.size();i++) {
				User toInsert=(User)users.get(i);
				boolean finished=false;
				for(int j=i;j>0 && !finished;j--) {
					User current=(User)users.get(j-1);
					if(current.compareTo(toInsert)>0) {
						users.set(j, current);
						users.set(j-1, toInsert);
					}else {
						finished=true;
					}
				}
			}
			higher=users.get(0).getPoint();
			return higher;
		}
	}
	
	/**
	 * Metodo que ordena un arreglo conforme a los nombres de los objetos en el 
	 * @return ArrayList ordenado conforme a los nombres de los usuarios
	 */
	public ArrayList<User> orderName(){
		ArrayList<User> users= arrayUser();
		ComparatorName cN=new ComparatorName();
		for(int i=1;i<users.size();i++) {
			for(int j=i;j>0 && cN.compare(users.get(j-1), users.get(j))>0;j--) {
				User temp=users.get(j);
				users.set(j, users.get(j-1));
				users.set(j-1, temp);
			}
		}
		return users;
	}
	
	/**
	 * Metodo que ordena un arreglo conforme a los puntos de los objetos en el 
	 * @return ArrayList ordenado conforme a los puntos de los usuarios
	 */
	public ArrayList<User> orderPoint() {
		ArrayList<User> users=arrayUser();
		for(int i=1;i<users.size();i++) {
			User toInsert=(User)users.get(i);
			boolean finished=false;
			for(int j=i;j>0 && !finished;j--) {
				User current=(User)users.get(j-1);
				if(current.compareTo(toInsert)>0) {
					users.set(j, current);
					users.set(j-1, toInsert);
				}else {
					finished=true;
				}
			}
		}
		return users;
	}
	
	/**
	 * Metodo que toma un arreglo y lo convierte a un solo objeto de tipo String 
	 * @param arreglo != null
	 * @return String que contiene todos los toString() de los objetos en el parametro arreglo
	 */
	public String arrayToString(ArrayList<User> array) {
		String end="";
		for(int m=0;m<array.size();m++) {
			int j=m+1;
			end+=""+j+")"+array.get(m).toString()+" ";
			end+="\n";
		}
		return end;
	}
	
	/**
	 * Metodo recursivo que toma un arreglo y lo convierte en un solo objeto de tipo String
	 * @param arreglo != null, El arreglo a convertir 
	 * @param i != null, posicion del arreglo a tomar
	 * @param j != null, contador
	 * @param end != null, acomulador de String 
	 * @return objeto de tipo String con todos los toString() de los objetos del arreglo separados por "\n" 
	 */
	public String arrayToString(ArrayList<User> array, int i, int j, String end) {
		if(i<array.size()) {
			j=i+1;
			end+=""+j+")"+array.get(i).toString()+" ";
			end+="\n";
			return arrayToString(array, i++, j, end);
		}else {
			return end;
		}
	}
	
	/**
	 * Metodo que busca en un arreglo ordenado un usuario con un puntaje igual al parametro valor
	 * @param valor != null, Parametro con el puntje a buscar 
	 * @return el toString() del usuario encontrado con el puntaje especificado
	 * @throws ScoreNotExistException si en el arreglo no hay ningun usuario con u puntaje igul el parametro especificad
	 */
	public String searchBinary (int value) throws ScoreNotExistException{
		boolean found=false;
		int start=0;
		int half=0;
		ArrayList<User> users=orderPoint();
		int end=users.size()-1;
		while(start<=end && !found){
				half=(start+end)/2;
			if(users.get(half).getPoint()==value){
				found=true;
			}else if(users.get(half).getPoint()<value){
				end=half-1;
			}else{
				start=half+1;
			}
		}if(found==false) {
			throw new ScoreNotExistException(value); 
		}else {
			return users.get(half).toString();
		}
	}
	
	/**
	 * Metodo que convierte un arbol binario de busqueda a un ArrayList de tipo usuario
	 * @return Arraylist de tipo usuario con el contenido del arbol binario de busqueda 
	 */
	public ArrayList<User> arrayUser(){
		ArrayList<User> names = new ArrayList<User>();
		toArray(getTreeUser().getRoot(), names);
		return names;
	}
	
	/**
	 * Metodo recursivo que recorre el arbol binario de busqueda y agrega cada elemento a un ArrayList de tipo Usuario 
	 * @param actual Usuario actual en el que va el recorrido del arbol binario de busqueda
	 * @param nombres != null 
	 */
	public void toArray(User current, ArrayList<User> nombres){
		if(current!=null ) {
			if(current.isSheet()) {
				nombres.add(current);
			}else {
				nombres.add(current);
				toArray(current.getLeft(), nombres);
				toArray(current.getRight(), nombres);
			}
		}
	}

	/**
	 * @return the usuario
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the treeUser
	 */
	public ABBUser getTreeUser() {
		return treeUser;
	}

	/**
	 * @param treeUser the treeUser to set
	 */
	public void setTreeUser(ABBUser treeUser) {
		this.treeUser = treeUser;
	}

	/**
	 * @return the eB
	 */
	public EnemyBoss geteB() {
		return eB;
	}

	/**
	 * @param eB the eB to set
	 */
	public void seteB(EnemyBoss eB) {
		this.eB = eB;
	}

	/**
	 * @return the listaEnemigos
	 */
	public EnemyList  getListaEnemigos() {
		return listaEnemigos;
	}

	/**
	 * @param listaEnemigos the listaEnemigos to set
	 */
	public void setListaEnemigos(EnemyList listaEnemigos) {
		this.listaEnemigos = listaEnemigos;
	}
	
	
	
	
}
