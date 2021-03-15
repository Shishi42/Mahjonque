package CoreUI;

import com.example.mahjong.MainActivityBoardGame;

import Core.BoardGame;

/**
 * @deprecated
 */
public class GameUI {


    private BoardGame boardGame;
    private MainActivityBoardGame controller;


    public GameUI(BoardGame boardGame, MainActivityBoardGame controller)  {

        this.boardGame = boardGame;
        this.controller = controller;

    }


}
