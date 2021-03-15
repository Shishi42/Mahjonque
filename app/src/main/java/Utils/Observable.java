
package Utils;

/**
 * This interface define the behaviour of observable object.
 * @author Salome Miha
 * @version 0.1
 */
public interface Observable {

	/**
	 * This method is used to add an observer to the notification list.
	 * @param observer The observer to add
	 */
	public void addObserver(Observer observer);

	/**
	 * This method is used to remove an observer from the notification list.
	 * @param observer The observer to remove
	 */
	public void removeObserver(Observer observer);

	/**
	 * This method is used to notify the observers from the notification list.
	 */
	public void notifyObservers();

}
