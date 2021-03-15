package Core;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * This class represent a model for a tic-tac-toe game
 * @author Mano Brabant
 * @version 1.0
 */
public class TicTacToe extends BoardGame {

    /**
     * This constructor create a new TicTacToe game
     */
    public TicTacToe() {
        super(3, 3);
    }


    @Override
    public boolean checkForWin(char car) {

        boolean ret = false;

        for(int i = 0; i < this.grid.getNbCol(); i++) {
            ret = ret || this.repeatingMoreThan(Arrays.stream(this.grid.getCellsCol(i)).map(Cell::getLetter).collect(Collectors.joining()), car, 2);
        }

        for(int i = 0; i < this.grid.getNbRow(); i++) {
            ret = ret || this.repeatingMoreThan(Arrays.stream(this.grid.getCellsRow(i)).map(Cell::getLetter).collect(Collectors.joining()), car, 2);
        }

        return ret;

    }


}
