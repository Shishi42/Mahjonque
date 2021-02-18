
package Utils;

import java.util.LinkedList;

/**
 * Cette classe représente un buffer circulaire
 * @author Salome Miha
 * @version 0.1
 */
public class CircularBuffer<T> {


	private int size;							//Le nombre de valeurs maximal
	private int place;
	private LinkedList<T> list;		//La liste des valeurs


	/**
	 * Ce constructeur permet de créer un nouveau buffer circulaire
	 * @param size La taille du buffer circulaire
	 */
	public CircularBuffer(int size) {

		this.size = size;
		this.place = 0;
		this.list = new LinkedList<T>();

	}


	/**
	 * Cette méthode permet d'ajouter un objet au buffer circulaire
	 * @param t L'objet à ajouter
	 */
	public void add(T t) {

		if(this.list.size() >= this.size) {
			this.list.removeFirst();
		}

		this.list.addLast(t);

	}


	/**
	 * Cette méthode permet de remplacer un objet au buffer circulaire
	 * @param t L'objet à ajouter à la place actuelle
	 */
	public void replace(T t) {

		if(this.list.size() > this.place) {

			this.list.remove(this.place);
			this.list.add(this.place, t);
			this.inc();

		}

	}


	private void inc() {
		this.place = (this.place + 1) % this.size;
	}


	/**
	 * Cette méthode permet de récupérer la liste des valeurs
	 * @return La liste des éléments
	 */
	public LinkedList<T> list() {
		return this.list;
	}

}
