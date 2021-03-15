package Core;

import androidx.annotation.NonNull;


/**
 * This enum enumerate the different possible type for the tiles in a mahjong game
 * @author Mano Brabant
 * @version 1.0
 */
public enum TileType {

    CHARACTER("man", 0),
    CIRCLE("pin", 1),
    BAMBOO("sou", 2),
    WIND("wind", 3),
    DRAGON("dragon", 4);

    private final int num;
    private final String name;

    TileType(String name, int num) {

        this.name = name;
        this.num = num;
    }


    /**
     * This method return the number of the type
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
