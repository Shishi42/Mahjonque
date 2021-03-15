package Core;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * This class represent a model for a mahjong game
 * @author Mano Brabant
 * @version 1.0
 */
public class MahjongGame {

    private final List<Tile> library;
    private final List<Tile> discard;

    private final TileHand player1;
    private final TileHand player2;

    private int player1Points;
    private int player2Points;


    /**
     * This constructor create a new Mahjong game
     */
    public MahjongGame() {

        this.library = new LinkedList<>();
        this.discard = new LinkedList<>();

        this.player1 = new TileHand(this);
        this.player2 = new TileHand(this);

        this.reset();

    }

    /**
     * This method initialize the library of the mahjong
     * The library is the pile where player draw their tiles
     */
    public void initLibrary() {

        this.library.clear();
        this.library.addAll(Tile.getTiles());
        Collections.shuffle(this.library);

    }


    /**
     * This method reset the game
     */
    public void reset() {

        this.retry();

        this.player1Points = 0;
        this.player2Points = 0;

    }


    /**
     * This method reset the library and the player's hand
     */
    public void retry() {

        this.initLibrary();

        this.player1.initHand();
        this.player2.initHand();

    }


    /**
     * This method return the library of the mahjong game
     * @return The library
     */
    public List<Tile> getLibrary() {
        return this.library;
    }


    /**
     * This method return the discard of the mahjong game
     * @return The discard
     */
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


    /**
     * This method return the hand of the player 1
     * @return The player 1's hand
     */
    public TileHand getPlayer1Hand() {
        return this.player1;
    }


    /**
     * This method return the hand of the player 2
     * @return The player 2's hand
     */
    public TileHand getPlayer2Hand() {
        return this.player2;
    }


    /**
     * This method add a tile to the discard
     * @param tile The tile to add
     */
    public void addToDiscard(Tile tile) {
        this.discard.add(tile);
    }


    /**
     * This method return a boolean to tell if the game has ended
     * @return true if the game has ended, false otherwise
     */
    public boolean ended() {
        return this.isPlayer1Win() || this.isPlayer2Win() || this.isDraw();
    }


    /**
     * This method return a boolean to tell if the player 1 has wined
     * @return true if the player 1 has wined, false otherwise
     */
    public boolean isPlayer1Win() {
        return isPlayerWin(1);
    }


    /**
     * This method return a boolean to tell if the player 2 has wined
     * @return true if the player 2 has wined, false otherwise
     */
    public boolean isPlayer2Win() {
        return isPlayerWin(2);
    }


    /**
     * This method return a boolean to tell if a player has wined
     * @param i The number of the player
     * @return true if the given player has wined, false otherwise
     */
    private boolean isPlayerWin(int i) {

        TileHand hand;

        if(i == 1) {
            hand = this.getPlayer1Hand();
        } else {
            hand = this.getPlayer2Hand();
        }

        return hand.containsThreeOfAKind() + hand.containsRow() >= 3;

    }


    /**
     * This method return a boolean to tell if the game is a draw
     * @return true if the game is a draw, false otherwise
     */
    private boolean isDraw() {
        return this.library.size() == 0 && !(this.isPlayer1Win() || this.isPlayer2Win());
    }


}
