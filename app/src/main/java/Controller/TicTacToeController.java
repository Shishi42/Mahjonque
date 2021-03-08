package Controller;

import com.example.mahjong.MainActivityBoardGame;

import Core.BoardGame;

public class TicTacToeController extends GameController {

    public TicTacToeController(BoardGame boardGame, MainActivityBoardGame view) {
        super(boardGame, view);
    }

    @Override
    public void clickGrid(int row, int col) {

        if(this.boardGame.ended()) {
            return;
        }

        if(this.boardGame.getGrid().getCase(row, col).getJoueur() == "") {

            this.boardGame.getGrid().getCase(row, col).setJoueur("X");
            this.update();

        }

    }

}
