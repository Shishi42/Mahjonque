package Core;

import androidx.annotation.NonNull;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class represent a tile of the mahjong game
 * @author Mano Brabant
 * @version 1.0
 */
public class Tile implements Comparable<Tile> {

    private static final Set<Tile> tiles = Tile.getTiles();

    private final TileType type;
    private final TileNum hauteur;
    private final int num;

    /**
     * This class method return a list of all the tiles of a mahjong game
     * @return The list of tiles
     */
    public static Set<Tile> getTiles() {

        if(tiles != null) {
            return tiles;
        }

        Set<Tile> ret = new HashSet<>();


        for (TileType type : TileType.values()) {
            for (TileNum num : TileNum.values()) {
                ret.add(new Tile(type, num, 0));
                ret.add(new Tile(type, num, 1));
                ret.add(new Tile(type, num, 2));
                ret.add(new Tile(type, num, 3));
            }
        }


        ret = ret.stream().
                filter(t -> !(t.getType() == TileType.WIND && t.getHeight().getNum() > 3)).
                filter(t -> !(t.getType() == TileType.DRAGON && t.getHeight().getNum() > 2)).
                collect(Collectors.toSet());


        return ret;

    }

    /**
     * This class method return a tile of a mahjong game
     * @param type The type of the wanted tile
     * @param height The height of the wanted tile
     * @return The wanted tile
     * @throws IllegalArgumentException If the combination of type and height are incorrect
     */
    public static Tile getTile(TileType type, TileNum height) throws IllegalArgumentException {

        Optional<Tile> tile = Tile.getTiles().stream().
                filter(t -> t.getType() == type && t.getHeight() == height).
                findFirst();

        if(!tile.isPresent()) {
            throw new IllegalArgumentException();
        }

        return tile.get();

    }


    /**
     * This class method return a tile of a mahjong game
     * @param type The type of the wanted tile
     * @param height The height of the wanted tile
     * @param num The number of the wanted tile
     * @return The wanted tile
     * @throws IllegalArgumentException If the combination of type and height are incorrect
     */
    public static Tile getTile(TileType type, TileNum height, int num) throws IllegalArgumentException {

        Optional<Tile> tile = Tile.getTiles().stream().
                filter(t -> t.getType() == type && t.getHeight() == height && t.getNum() == num).
                findFirst();

        if(!tile.isPresent()) {
            throw new IllegalArgumentException();
        }

        return tile.get();

    }


    /**
     * This constructor create a new Tile
     * @param type The type of the tile
     * @param hauteur The height of the tile
     * @param num The nim of the tile
     */
    private Tile(TileType type, TileNum hauteur, int num) {

        this.type = type;
        this.hauteur = hauteur;
        this.num = num;

    }


    /**
     * This method return the type of the tile
     * @return The type
     */
    public TileType getType() {
        return this.type;
    }


    /**
     * This method return the height of the tile
     * @return The height
     */
    public TileNum getHeight() {
        return this.hauteur;
    }


    /**
     * This method return the number of the tile
     * @return The number
     */
    public int getNum() {
        return this.num;
    }


    @Override
    public int compareTo(Tile tile) {
        return this.getPos() - tile.getPos();
    }


    /**
     * This method return the position in the order of the different tiles
     * @return The position
     */
    public int getPos() {
        return this.getType().getNum() * 100 + this.getHeight().getNum();
    }

    @NonNull
    @Override
    public String toString() {
        return this.getType().toString() + " : " + this.getHeight().toString() + " : " + this.getNum();
    }

}
