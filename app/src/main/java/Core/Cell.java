package Core;

import androidx.annotation.NonNull;


/**
 * This class represent a cell of a board game
 * @author Mano Brabant
 * @version 1.0
 */
public class Cell {

    private BoardPlayer player;


    /**
     * This constructor create a new Cell
     */
    public Cell() {
        this.player = BoardPlayer.NONE;
    }


    /**
     * This method return the letter inside the cell
     * @return The letter that represent a player
     */
    public BoardPlayer getPlayer() {
        return this.player;
    }


    /**
     * This method is used to set the letter inside the cell
     * @param player The new letter for the cell
     */
    public void setPlayer(BoardPlayer player) {
        this.player = player;
    }


    @NonNull
    @Override
    public String toString() {
        return this.getPlayer().toString();
    }
}
