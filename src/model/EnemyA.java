package model;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

import interfaces.InterfaceFire;
import interfaces.InterfaceReloadE;

public class EnemyA extends Enemy implements Serializable, InterfaceReloadE, InterfaceFire {

	private static final long serialVersionUID = 1L;

	private Timer timer;
	
	private TimerTask tT;
	
	private Shoot shoot;

	private boolean shooting;
	
	private long delay;
	
	private long period;
	
	/**
	 * Constructor de la clase EnemyA 
	 * @param posX != null, posX posicion x del EnemyA
	 * @param posY != null, posY posicion y del EnemyA
	 * @param puntos != null, puntos puntos que da el EnemyA cuando es golpeado
	 * @param imagen != null, imagen ruta de la imagen que tendr� en la interfaz el EnemyA
	 * @param vivo != null, vivo booleano de confirmacion para saber si el EnemyA aun esta vivo o no
	 * @param direccion != null, direccion char que indica la direccion de movimiento del EnemyA
	 */			 
	public EnemyA(int posX, int posY, int points, String image, boolean alive, char adress) {
		super(posX, posY, points, image, alive, adress);
		
		shoot=new Shoot(0);
		
		this.shooting=false;
		
		delay=3000;
		period=5000;
		
		shootEnemy();
	}
	
	/**
	 * @return the timer
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * @param timer the timer to set
	 */
	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	/**
	 * @return the tT
	 */
	public TimerTask gettT() {
		return tT;
	}

	/**
	 * @param tT the tT to set
	 */
	public void settT(TimerTask tT) {
		this.tT = tT;
	}

	/**
	 * @return the shoot
	 */
	public Shoot getShoot() {
		return shoot;
	}

	/**
	 * @param shoot the shoot to set
	 */
	public void setShoot(Shoot shoot) {
		this.shoot = shoot;
	}

	/**
	 * @return the disparando
	 */
	public boolean isShooting() {
		return shooting;
	}

	/**
	 * @param disparando the disparando to set
	 */
	public void setShooting(boolean shooting) {
		this.shooting = shooting;
	}

	/**
	 * @return the delay
	 */
	public long getDelay() {
		return delay;
	}

	/**
	 * @param delay the delay to set
	 */
	public void setDelay(long delay) {
		this.delay = delay;
	}

	/**
	 * @return the period
	 */
	public long getPeriod() {
		return period;
	}

	/**
	 * @param period the period to set
	 */
	public void setPeriod(long period) {
		this.period = period;
	}

	/**
	 * Metodo que hace al EnemigoA fire 
	 */
	public void shootEnemy() {
		timer=new Timer();
		tT=new TimerTask() {
			@Override
			public void run() {
				if(shooting==false) {
					shooting=true;
					fire();
				}
			}
		};
		timer.schedule(tT, getDelay(), getPeriod());	
	}
	
	/**
	 * Metodo que calcula si es momento de recargar la bala del EnemigoA
	 */
	@Override
	public void reloadE() {
		if(getShoot().getY()>VideoGame.LONG_WINDOW-40) {
			shooting=false;
			shoot.reloadE();
		}
	}
	
	/**
	 * Metodo que actualiza la posicion de la bala del EnemigoA
	 */
	@Override
	public void fire() {
		if(shooting=true) {
			shoot.moveE();			
			shoot.setY(getPosY());
			shoot.setX(getPosX());
			reloadE();
		}
	}
	
	/**
	 * Metodo toString() del EnemigoA
	 */
	@Override
	public String toString() {
		return getPosX()+""+ getPosY()+""+ getPoints()+""+ getImage()+""+ isAlive()+""+ getAdress();
	}
}
