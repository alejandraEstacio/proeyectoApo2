package model;

import java.io.Serializable;


@SuppressWarnings("serial")
public class EnemyList implements Serializable{

	private Enemy head;
	
	private int size;
	
	
	public EnemyList() {
		head=null;
		size=0;
	}
	
	/**
	 * @return the cabeza
	 */
	public Enemy getHead() {
		return head;
	}

	/**
	 * @param cabeza the cabeza to set
	 */
	public void setHead(Enemy head) {
		this.head = head;
	}

	/**
	 * @return the size
	 */
	public int size() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Metodo que agrega un nuevo enemigo a la lista de enemigos 
	 * @param new != null
	 */
	public void add(Enemy newE) {
		if(head==null) {
			head=newE;
		}else {
			Enemy temp=head;
			while(temp.getNext()!=null) {
				temp=temp.getNext();
			}
			temp.setNext(newE);
		}
		setSize(size() + 1);
	}
	
	/**
	 * Metodo que limpia la lista de enemigos, haciendo que la cabeza pierda las referencias de sus siguentes
	 * y luego hace el valor de la cabeza=null
	 */
	public void clear() {
		head.setNext(null);
		head=null;
		setSize(0);
	}
	
	/**
	 * Metodo que devuelve un Enemigo dado por el parametro index
	 * @param index != null
	 * @return El enemigo en la posicion del parametro index
	 */
	public Enemy get(int index) {
		int c=0;
		Enemy temp=head;
		while(c<index) {
			if(temp.getNext()!=null) {
				temp=temp.getNext();
			}
			c++;
		}
		return temp;
	}
	
}
