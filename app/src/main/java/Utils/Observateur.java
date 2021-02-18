
package Utils;

/**
 * Cette interface définit les comportements des objets qui peuvent en observer d'autre
 * @author Salome Miha
 * @version 0.1
 */
public interface Observateur {

	/**
	 * Cette méthode est appelée par les objets observables quand ils veulent notifier les observateurs
	 */
	public void actualise();

}
