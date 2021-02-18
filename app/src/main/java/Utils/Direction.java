
package Utils;

/**
 * Cette énumération présente les direction cardinales
 */
public enum Direction {
  NORTH("North"),
  SOUTH("South"),
  EAST("East"),
  WEST("West");

  private String name;

  private Direction(String name) {
    this.name = name;
  }


  /**
   * Cette méthode permet de récupérer la dirction en fonction d'un vecteur de déplacement
   * @param x La composante en abscisse du vecteur de déplacement
   * @param y La composante en ordonnée du vecteur de déplacement
   * @return La direction
   */
  public static Direction getDirection(double x, double y) {

    Direction ret;

    if(y > 0 && y >= Math.abs(x))         ret = SOUTH;
    else if(y < 0 && y <= -Math.abs(x))   ret = NORTH;
    else if(x > 0)                        ret = EAST;
    else                                  ret = WEST;

    return ret;

  }


  @Override
  public String toString() {
    return this.name;
  }

}
