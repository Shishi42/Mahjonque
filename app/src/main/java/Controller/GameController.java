package Controller;

import com.example.mahjong.MainActivityBoardGame;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import Core.Cell;
import Core.BoardGame;

/**
 * This class represent an abstract controller for a board game
 */
public abstract class GameController {

    protected BoardGame boardGame;
    protected MainActivityBoardGame view;


    /**
     * This constructor initialize the general info for a controller of a board game
     * @param boardGame The model to control
     * @param view The view to notify when a change occurs
     */
    public GameController(BoardGame boardGame, MainActivityBoardGame view) {

        this.boardGame = boardGame;
        this.view = view;

    }

    /**
     * This method is called when a player click on a cell of the grid in the view
     * @param row The row of the cell
     * @param col The column of the cell
     */
    public void clickGrid(int row, int col) {

        this.boardGame.getGrid().getCase(row, col).setJoueur("X");
        this.update();

    }


    /**
     * This method is used to reset the game
     */
    public void clickReset() {
        this.boardGame.resetGame();
    }


    /**
     * This method is used to restart a game
     */
    public void clickRetry() {
        this.boardGame.getGrid().resetBoard();
    }


    /**
     * This method is used after the player click on a cell to check for the win et make the IA play
     * TODO::Make it look nicer
     */
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

    /**
     * This method return the cell that the IA will play
     * @return The cell played by the IA
     */
    public Cell getPlay() {
        return this.boardGame.getCasesAvailable().get(new Random().nextInt(this.boardGame.getCasesAvailable().size()));
    }

}
