package Core;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * This class represent a model for a connect four game
 * @author Mano Brabant
 * @version 1.0
 */
public class ConnectFour extends BoardGame {

    /**
     * This constructor create a new ConnectFour game
     */
    public ConnectFour() {
        super(6, 7);
    }


    @Override
    public boolean checkForWin(char car) {

        boolean ret = false;

        for(int i = 0; i < this.grid.getNbCol(); i++) {
            ret = ret || this.repeatingMoreThan(Arrays.stream(this.grid.getCellsCol(i)).map(Cell::getLetter).collect(Collectors.joining()), car, 3);
        }

        for(int i = 0; i < this.grid.getNbRow(); i++) {
            ret = ret || this.repeatingMoreThan(Arrays.stream(this.grid.getCellsRow(i)).map(Cell::getLetter).collect(Collectors.joining()), car, 3);
        }

        return ret;

    }


}
