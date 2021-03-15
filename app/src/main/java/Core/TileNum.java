package Core;

import androidx.annotation.NonNull;


/**
 * This enum enumerate the different possible height for the tiles in a mahjong game
 * @author Mano Brabant
 * @version 1.0
 */
public enum TileNum {

    ONE("one", 0),
    TWO("two", 1),
    THREE("three", 2),
    FOUR("four", 3),
    FIVE("five", 4),
    SIX("six", 5),
    SEVEN("seven", 6),
    EIGHT("eight", 7),
    NINE("nine", 8);

    private final String name;
    private final int num;

    TileNum(String name, int num) {

        this.name = name;
        this.num = num;

    }

    /**
     * This method return the number of the height
     * @return The number
     */
    public int getNum() {
        return this.num;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }

}
