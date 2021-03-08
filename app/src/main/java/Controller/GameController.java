package Controller;

import com.example.mahjong.MainActivityBoardGame;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import Core.Cell;
import Core.BoardGame;

public abstract class GameController {

    protected BoardGame boardGame;
    protected MainActivityBoardGame view;

    public GameController(BoardGame boardGame, MainActivityBoardGame view) {

        this.boardGame = boardGame;
        this.view = view;

    }

    public void clickGrid(int row, int col) {

        this.boardGame.getGrid().getCase(row, col).setJoueur("X");
        this.update();

    }

    public void clickReset() {
        this.boardGame.resetGame();
    }
    public void clickRetry() {
        this.boardGame.getGrid().resetBoard();
    }


    public void update() {

        boolean reset = false;

        this.view.update();

        if(this.boardGame.checkForWin('X')) {

            this.boardGame.player1Wins();
            this.view.player1Wins();

        } else {

            List<Cell> cells = this.boardGame.getCasesAvailable();

            if(cells.size() > 0) {

                try {
                    this.getPlay().setJoueur("O");
                } catch (NoSuchElementException e) {

                    this.boardGame.draw();
                    this.view.draw();

                }

                if(this.boardGame.checkForWin('O')) {

                    this.boardGame.player2Wins();
                    this.view.player2Wins();

                    if (this.boardGame.getCasesAvailable().size() == 0) {

                        this.boardGame.draw();
                        this.view.draw();

                    }
                }
            } else {
                this.boardGame.draw();
            }

        }

    }

    public Cell getPlay() {
        return this.boardGame.getCasesAvailable().get(new Random().nextInt(this.boardGame.getCasesAvailable().size()));
    }

}
