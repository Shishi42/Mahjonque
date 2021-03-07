package Controller;

import java.util.List;
import java.util.Random;

import Core.Cell;
import Core.Game;

public abstract class GameController {

    protected Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public void clickGrid(int row, int col) {

        this.game.getGrid().getCase(row, col).setJoueur("X");
        this.update();

    }

    public void clickReset() {
        this.game.resetGame();
    }


    public void update() {

        if(this.game.checkForWin('X')) {
            this.game.player1Wins();
        } else {
            List<Cell> cells = this.game.getCasesAvailable();

            if(cells.size() > 0) {
                this.game.getCasesAvailable().get(new Random().nextInt(this.game.getCasesAvailable().size())).setJoueur("O");
                if(this.game.checkForWin('O')) {
                    this.game.player2Wins();
                    if (this.game.getCasesAvailable().size() == 0) {
                        this.game.draw();
                    }
                }
            } else {
                this.game.draw();
            }

        }

    }
}
