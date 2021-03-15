package Controller;

import com.example.mahjong.MainActivityBoardGame;

import java.util.List;
import java.util.Random;

import Core.Cell;
import Core.BoardGame;

/**
 * This class represent an abstract controller for a board game
 * @author Mano Brabant
 * @version 1.0
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

        this.boardGame.getGrid().getCell(row, col).setLetter("X");
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
     */
    public void update() {

        this.view.update();

        if(this.boardGame.checkForWin('X')) {

            this.boardGame.player1Wins();
            this.view.player1Wins();

        } else {

            List<Cell> cells = this.boardGame.getCasesAvailable();

            if(cells.size() > 0) {

                this.getPlay().setLetter("O");

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
