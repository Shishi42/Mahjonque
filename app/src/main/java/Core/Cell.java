package Core;

import androidx.annotation.NonNull;

/**
 * This class represent a cell of a board game
 * @author Mano Brabant
 * @version 1.0
 */
public class Cell {

    private String letter;

    /**
     * This constructor create a new Cell
     */
    public Cell() {
        this.letter = "";
    }

    /**
     * This method return the letter inside the cell
     * @return The letter that represent a player
     */
    public String getLetter() {
        return this.letter;
    }

    /**
     * This method is used to set the letter inside the cell
     * @param letter The new letter for the cell
     */
    public void setLetter(String letter) {
        this.letter = letter;
    }

    @NonNull
    @Override
    public String toString() {
        return this.getLetter();
    }
}
