package Controller;

import Core.Game;

public class TicTacToeController extends GameController {

    public TicTacToeController(Game game) {
        super(game);
    }

    @Override
    public void clickGrid(int row, int col) {

        if(this.game.getGrid().getCase(row, col).getJoueur() == "") {

            this.game.getGrid().getCase(row, col).setJoueur("X");
            this.update();

        }

    }

}
