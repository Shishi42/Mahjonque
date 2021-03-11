package Core;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TicTacToe extends BoardGame {

    public TicTacToe() {
        super(3, 3);

    }


    @Override
    public boolean checkForWin(char car) {

        boolean ret = false;

        for(int i = 0; i < this.grid.getNbCol(); i++) {
            ret = ret || this.repeatingMoreThan(Arrays.stream(this.grid.getCellsCol(i)).map(b -> b.getJoueur()).collect(Collectors.joining()), car, 2);
        }

        for(int i = 0; i < this.grid.getNbRow(); i++) {
            ret = ret || this.repeatingMoreThan(Arrays.stream(this.grid.getCellsRow(i)).map(b -> b.getJoueur()).collect(Collectors.joining()), car, 2);
        }

        return ret;

    }


}
