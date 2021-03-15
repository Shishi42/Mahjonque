package Controller;

import com.example.mahjong.MainActivityBoardGame;

import Core.BoardGame;
import Core.BoardPlayer;


/**
 * This class represent a controller for Tic Tac Toe game
 * @author Mano Brabant
 * @version 1.0
 */
public class TicTacToeController extends GameController {

    public TicTacToeController(BoardGame boardGame, MainActivityBoardGame view) {
        super(boardGame, view);
    }

    @Override
    public void clickGrid(int row, int col) {

        if(this.boardGame.ended()) {
            return;
        }

        if(this.boardGame.getGrid().getCell(row, col).getPlayer().equals(BoardPlayer.NONE)) {

            this.boardGame.getGrid().getCell(row, col).setPlayer(BoardPlayer.PLAYER_ONE);
            this.update();

        }

    }

}
