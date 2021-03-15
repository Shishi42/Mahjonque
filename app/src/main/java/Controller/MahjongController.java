package Controller;

import com.example.mahjong.MainActivityMahjong;

import java.util.Random;

import Core.MahjongGame;


/**
 * This class represent a controller for a mahjong game
 * @author Mano Brabant
 * @version 1.0
 */
public class MahjongController {


    protected MahjongGame mahjongGame;
    protected MainActivityMahjong view;


    public MahjongController(MahjongGame mahjongGame, MainActivityMahjong view) {

        this.mahjongGame = mahjongGame;
        this.view = view;

    }

    public void clickHand(int num) {

        if(this.mahjongGame.ended()) {
            return;
        }

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
     * This method is used after the player click on a tile to check for the win et make the IA play
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
