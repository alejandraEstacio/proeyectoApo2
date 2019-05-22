package model;

import java.io.Serializable;

public class EnemyBoss extends EnemyA implements Serializable{

	private static final long serialVersionUID = 1L;

	private int lives;

	/**
	 * Constructor de la clase Enemigo Boss 
	 * @param posX != null, posX posicion x del EnemigoBoss
	 * @param posY != null, posY posicion y del EnemigoBoss
	 * @param puntos != null, puntos puntos que da el EnemigoBoss cuando es golpeado
	 * @param imagen != null, imagen ruta de la imagen que tendr� en la interfaz el EnemigoBoss
	 * @param vivo != null, vivo booleano de confirmacion para saber si el EnemigoBoss aun esta vivo o no
	 * @param direccion != null, direccion char que indica la direccion de movimiento del EnemigoBoss
	 */
	public EnemyBoss(int posX, int posY, int points, String image, boolean alive, char adress) {
		super(posX, posY, points, image, alive, adress);
		setPoints(300);
		lives=2500;
	}

	/**
	 * @return the vida
	 */
	public int getLives() {
		return lives;
	}

	/**
	 * @param vida the vida to set
	 */
	public void setLives(int lives) {
		this.lives = lives;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}