
package Utils;

import java.util.List;
import java.util.LinkedList;

/**
 * Cette interface définit les comportements des objets qui peuvent être observé par d'autre
 * @author Salome Miha
 * @version 0.1
 */
public interface Observable {

	/**
	 * Cette méthode permet d'ajouter un observateur
	 * @param observateur L'observateur à ajouter
	 */
	public void attacheObservateur(Observateur observateur);

	/**
	 * Cette méthode permet de retirer un observateur
	 * @param observateur L'observateur à retirer
	 */
	public void detacheObservateur(Observateur observateur);

	/**
	 * Cette méthode permet de notifier tous les observateurs
	 */
	public void notifieObservateurs();

}
