package Controller;

import java.util.Arrays;
import java.util.Optional;

import Core.Cell;
import Core.Game;

public class Puissance4Controller extends GameController {

    public Puissance4Controller(Game game) {
        super(game);
    }


    @Override
    public void clickGrid(int row, int col) {

        Optional<Cell> cell = Arrays.stream(this.game.getGrid().getCellsCol(col)).
                                        filter(c -> c.getJoueur() == "").
                                        reduce((first, second) -> second);

        if(cell.isPresent()) {
            cell.get().setJoueur("X");
            this.update();
        }

    }

}
