package model;

import java.io.Serializable;

import interfaces.InterfaceFire;
import interfaces.InterfaceReloadP;

/**
 * Class Character
 */
@SuppressWarnings("serial")
public class Character implements Serializable, InterfaceReloadP, InterfaceFire {
	

	public static final String RIGHT="data/userR.png";
	public static final String LEFT="data/userL.png";
	
	private String image;
		
	private int longer;
	private int width;
	
	private int posX;
	private int posY;
	
	private boolean shooting;
	
	private Shoot bullet;
	/**
	 * Constructor of the character class
	 * @param imagen != null
	 */
	public Character(String image) {
		this.image=image;
		
		posX=(VideoGame.WIDTH_WINDOW/2)-getWidth();
		posY=(VideoGame.LONG_WINDOW-100);
		
		longer=90;
		width=60;
		
		this.shooting= false;
		bullet=new Shoot(0);
		reloadP();
	}
	
	public void reloadP() {
		if(bullet.getY()<5) {
			shooting=false;
			bullet.reloadP();
		}
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
	 * @return the long
	 */
	public int getLonger() {
		return longer;
	}

	/**
	 * @param long the long to set
	 */
	public void setLonger(int longer) {
		this.longer = longer;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param ancho the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
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
	 * @return the shooting
	 */
	public boolean isShooting() {
		return shooting;
	}

	/**
	 * @param shooting the Shooting to set
	 */
	public void setShooting(boolean shooting) {
		this.shooting = shooting;
	}

	/**
	 * @return the RIGHT
	 */
	public static String getRight() {
		return RIGHT;
	}

	/**
	 * @return the LEFT
	 */
	public static String getLeft() {
		return LEFT;
	}
	
	/**
	 * @return the bullet
	 */
	public Shoot getBullet() {
		return bullet;
	}

	/**
	 * @param bullet the bullet to set
	 */
	public void setBullet(Shoot bullet) {
		this.bullet = bullet;
	}

	/**
	 * This method makes the avatar appear in default position
	 */
	public void reappear() {
		this.setPosX(VideoGame.LONG_WINDOW/2);
	}
	
	/**
	 *this method increases the position X of the avatar 5 points 
	 */
	public void moveRight() {
		setImage(RIGHT);
		if(getPosX()<VideoGame.LONG_WINDOW) {
			posX+=5;
		}
	}
	
	/**
	 * this method decreases the position X of the avatar 5 points 
	 */
	public void moveLeft() {
		setImage(LEFT);
		if(getPosX()<=VideoGame.WIDTH_WINDOW) {
			posX-=5;
		}
	}
	
	/**
	 * this method makes the character shoot 
	 */
	public void shooting() {
		if(isShooting()==true) {
			bullet.moveP();
		}
	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub
		
	}	

}
