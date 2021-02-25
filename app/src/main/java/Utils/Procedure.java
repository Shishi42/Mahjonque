
package Utils;

/**
 * This functional interface represent a method with no parameters and no return.
 * @author Salome Miha
 * @version 0.1
 */
@FunctionalInterface
public interface Procedure {

	/**
	 * The method to define
	 */
	public void run();

	/**
	 * This method allow us to chain the procedure call.
	 * @param next The procedure to call next.
	 * @return A Procedure containing the two procedure.
	 */
	public default Procedure andThen(Procedure next) {

		return () -> {
			this.run();
			next.run();
		};

	}

}
