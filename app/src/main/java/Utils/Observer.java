
package Utils;

/**
 * This interface define the behaviour of observer object.
 * @author Salome Miha
 * @version 0.1
 */
public interface Observer {

	/**
	 * This method is called by observable object when they notify the observers
	 */
	public void actualise();

}
