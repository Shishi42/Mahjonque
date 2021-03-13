package Controller;

import com.example.mahjong.MainActivityBoardGame;
import com.example.mahjong.MainActivityMahjong;
import com.example.mahjong.R;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import Core.Cell;
import Core.MahjongGame;
import Core.Tile;

public class MahjongController {


    protected MahjongGame mahjongGame;
    protected MainActivityMahjong view;


    public MahjongController(MahjongGame mahjongGame, MainActivityMahjong view) {

        this.mahjongGame = mahjongGame;
        this.view = view;

    }

    public void clickHand(int num) {

        this.mahjongGame.getPlayer1Hand().discard(num);
        this.mahjongGame.getPlayer1Hand().draw();
        this.update();

    }



    /**
     * This method is used to reset the game
     */
    public void clickReset() {
        this.mahjongGame.reset();
    }


    /**
     * This method is used to restart a game
     */
    public void clickRetry() {
        this.mahjongGame.retry();
    }




    /**
     *
     */
    public void update() {

        this.view.update();

        if(this.mahjongGame.isPlayer1Win()) {

            this.mahjongGame.player1Wins();
            this.view.player1Wins();

        } else if (this.mahjongGame.getLibrary().size() == 0) {

            this.mahjongGame.draw();
            this.view.draw();


        } else {

            this.mahjongGame.getPlayer2Hand().discard(this.getPlay());
            this.mahjongGame.getPlayer2Hand().draw();

            if (this.mahjongGame.isPlayer2Win()) {

                this.mahjongGame.player2Wins();
                this.view.player2Wins();

            } else if (this.mahjongGame.getLibrary().size() == 0) {

                this.mahjongGame.draw();
                this.view.draw();

            }

        }

    }




    /**
     * This method return the cell that the IA will play
     * @return The cell played by the IA
     */
    public int getPlay() {
        return new Random().nextInt(this.mahjongGame.getPlayer2Hand().getSize());
    }

}
