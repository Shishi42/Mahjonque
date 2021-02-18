
package Utils;

/**
 * Cette interface fonctionnelle représente une opération qui ne prend pas de paramètres et ne retourne rien
 * @author Salome Miha
 * @version 0.1
 */
@FunctionalInterface
public interface Procedure {

	/**
	 * L'opération à définir
	 */
	public void run();

	/**
	 * Cette méthode permet permet d'enchainer les appels de procédure
	 * @param next La Procedure à appeler après
	 * @return La Procedure qui enchaine les deux Procedure
	 */
	public default Procedure andThen(Procedure next) {

		return () -> {
			this.run();
			next.run();
		};

	}

}
