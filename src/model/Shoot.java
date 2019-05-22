package model;

import java.io.Serializable;

import interfaces.InterfaceReloadE;
import interfaces.InterfaceReloadP;


@SuppressWarnings("serial")
public class Shoot implements Serializable, InterfaceReloadP, InterfaceReloadE{

	private int length;
	private int width;
	
	private int x;
	private int y;
	
	private int damage;
	
	/**
	 * Constructor de la clase Disparo
	 * @param x != null, posicion x del disparo
	 */
	public Shoot(int x) {
		length=50;
		width=20;
		y=VideoGame.LONG_WINDOW-165;
		setDamage(250);
	}
	
	/**
	 * @return the largo
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param largo the largo to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the ancho
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 * Metodo que setea la posicion y del disparo del enemigo en una posicion por defecto
	 */
	@Override
	public void reloadE() {
		setY(35);
	}
	
	/**
	 * Metodo que setea la posicion y del disparo del personaje en una posicion por defecto
	 */
	@Override
	public void reloadP() {
		setY(VideoGame.LONG_WINDOW-165);
	}
	
	/**
	 * Metodo que cambia la posicion del disparo -50 puntos
	 */
	public void moveP() {
		y-=50;
	}

	/**
	 * Metodo que cambia la posicion del disparo +50 pixeles
	 */
	public void moveE() {
		y+=50;
	}
	
}
