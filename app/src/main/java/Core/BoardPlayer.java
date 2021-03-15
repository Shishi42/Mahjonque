package Core;

import androidx.annotation.NonNull;


/**
 * This enum enumerate the different possible player in a board game
 * @author Mano Brabant
 * @version 1.0
 */
public enum BoardPlayer {

    PLAYER_ONE("x"),
    PLAYER_TWO("o"),
    NONE("_");

    private final String name;

    BoardPlayer(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }

    public char toChar() {
        return this.name.charAt(0);
    }

}
