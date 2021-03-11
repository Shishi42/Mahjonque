
package Utils;

/**
 * This enumeration represent the cardinal directions.
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
   * This method is used to get the direction from a vector.
   * @param x The x-axis number of the vector
   * @param y The y-axis number of the vector
   * @return The calculated direction
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
