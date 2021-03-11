
package Utils;

import java.util.LinkedList;

/**
 * This class represent a circular buffer. 
 * @author Salome Miha
 * @version 0.1
 */
public class CircularBuffer<T> {


	private int maxSize;
	private int index;
	private LinkedList<T> list;


	/**
	 * This constructor create a new circular buffer
	 * @param size The size of the circular buffer
	 */
	public CircularBuffer(int size) {

		this.maxSize = size;
		this.index = 0;
		this.list = new LinkedList<T>();

	}


	/**
	 * This method is used to add an object to the circular buffer.
	 * @param t The object to add.
	 */
	public void add(T t) {

		if(this.list.size() >= this.maxSize) {
			this.list.removeFirst();
		}

		this.list.addLast(t);

	}


	/**
	 * @deprecated
	 */
	public void replace(T t) {

		if(this.list.size() > this.index) {

			this.list.remove(this.index);
			this.list.add(this.index, t);
			this.inc();

		}

	}


	private void inc() {
		this.index = (this.index + 1) % this.maxSize;
	}


	/**
	 * This method is used to get the list of elements
	 * @return The list containing the elements
	 */
	public LinkedList<T> list() {
		return this.list;
	}

}
