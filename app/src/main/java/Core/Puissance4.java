package Core;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Puissance4 extends Game {

    public Puissance4() {
        super(6, 7);

    }


    @Override
    public boolean checkForWin(char car) {

        boolean ret = false;

        for(int i = 0; i < this.grid.getNbCol(); i++) {
            ret = ret || this.repeatingMoreThan(Arrays.stream(this.grid.getCellsCol(i)).map(b -> b.getJoueur()).collect(Collectors.joining()), car, 3);
        }

        for(int i = 0; i < this.grid.getNbRow(); i++) {
            ret = ret || this.repeatingMoreThan(Arrays.stream(this.grid.getCellsRow(i)).map(b -> b.getJoueur()).collect(Collectors.joining()), car, 3);
        }

        return ret;

    }


}
