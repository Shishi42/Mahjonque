
package Utils;

/**
 * This class represent an action that must wait before repeating itself
 */
public class TimerAction {

  private Procedure proc;
  private int int_nbTikMax;
  private int int_nbTik;

  public TimerAction(Procedure proc, int int_nbTikMax) {

      this.proc = proc;
      this.int_nbTikMax = int_nbTikMax;
      this.int_nbTik = 0;

  }

  public void setNbTikMax(int nbTikMax) {
    this.int_nbTikMax = nbTikMax;
  }

  /**
   * TODO :: Faire un pattern etat
   */
  public boolean lance() {
    if(this.int_nbTik++ > int_nbTikMax) {
      this.proc.run();
      this.int_nbTik = 0;
      return true;
    } else {
      return false;
    }
  }



}
