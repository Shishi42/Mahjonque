package Core;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MahjongGame {


    private List<Tile> library;
    private List<Tile> discard;

    private TileHand player1;
    private TileHand player2;

    private int player1Points;
    private int player2Points;


    public MahjongGame() {

        this.library = new LinkedList<>();
        this.discard = new LinkedList<>();

        this.player1 = new TileHand(this);
        this.player2 = new TileHand(this);

        this.reset();

    }

    public void initLibrary() {

        this.library.addAll(Tile.getTiles());

        Collections.shuffle(this.library);

    }

    public void reset() {

        this.retry();

        this.player1Points = 0;
        this.player2Points = 0;

    }

    public void retry() {

        this.initLibrary();

        this.player1.initHand();
        this.player2.initHand();

    }

    public List<Tile> getLibrary() {
        return this.library;
    }


    public List<Tile> getDiscard() {
        return this.discard;
    }


    /**
     * This method return the number of point of the player1
     * @return The number of point
     */
    public int getPlayer1Points() {
        return this.player1Points;
    }


    /**
     * This method return the number of point of the player2
     * @return The number of point
     */
    public int getPlayer2Points() {
        return this.player2Points;
    }


    /**
     * This method increments the points of the player1
     */
    public void player1Wins() {
        player1Points++;
    }


    /**
     * This method increments the points of the player2
     */
    public void player2Wins() {
        player2Points++;
    }


    /**
     * This method does nothing
     * Nothing happen in the model when there is a draw
     */
    public void draw() {

    }



    public TileHand getPlayer1Hand() {
        return this.player1;
    }


    public TileHand getPlayer2Hand() {
        return this.player2;
    }

    public void addToDiscard(Tile tile) {
        this.discard.add(tile);
    }

    public boolean ended() {

        return this.isPlayer1Win() || this.isPlayer2Win();

    }

    public boolean isPlayer1Win() {

        return isPlayerWin(1);

    }

    public boolean isPlayer2Win() {

        return isPlayerWin(2);

    }


    private boolean isPlayerWin(int i) {

        TileHand hand;

        if(i == 1) {
            hand = this.getPlayer1Hand();
        } else {
            hand = this.getPlayer2Hand();
        }

        return hand.containsThreeOfAKind() + hand.containsRow() >= 3;

    }


}
