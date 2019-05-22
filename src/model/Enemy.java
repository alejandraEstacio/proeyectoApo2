package model;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Enemy implements Serializable{

	private int posX;
	private int posY;
	
	private int points;
	
	private char adress;
	
	private String image;

	private boolean alive;
	
	private Enemy next;
	
	/**
	 * Constructor de la clase Enemy
	 * @param posX != null, posX posicion x del Enemy
	 * @param posY != null, posY posicion y del Enemy
	 * @param points != null, points points que da el Enemy cuando es golpeado
	 * @param image != null, image ruta de la image que tendr� en la interfaz el Enemy
	 * @param Alive != null, Alive booleano de confirmacion para saber si el Enemy aun esta Alive o no
	 * @param adress != null, adress char que indica la adress de movimiento del Enemy
	 */
	public Enemy(int posX, int posY, int points, String image, boolean alive, char adress) {
		this.posX = posX;
		this.posY = posY;
		this.points = points;
		this.image = image;
		this.alive = alive;
		this.adress=adress;
	}

	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * @param posX the posX to set
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * @param posY the posY to set
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @return the adress
	 */
	public char getAdress() {
		return adress;
	}

	/**
	 * @param adress the adress to set
	 */
	public void setAdress(char adress) {
		this.adress = adress;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the alive
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * @param Alive the Alive to set
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * @return the next
	 */
	public Enemy getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Enemy next) {
		this.next = next;
	}

	public void moveD() {
		posX+=5;
	}
	
	public void moveI() {
		posX-=5;
	}
	
}

