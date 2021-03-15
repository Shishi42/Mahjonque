package Core;

import androidx.annotation.NonNull;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * This class represent a hand for a player in a mahjong game
 * @author Mano Brabant
 * @version 1.0
 */
public class TileHand {

    private final MahjongGame game;
    private List<Tile> tiles;


    /**
     * This constructor create a new TileHand
     * @param game The game in which this hand is played
     */
    public TileHand(MahjongGame game) {

        this.game = game;
        this.tiles = new LinkedList<>();

    }


    /**
     * This method initialize the hand
     */
    public void initHand() {

        this.tiles.clear();
        for(int i = 0;i < 14; i++) {
            this.draw();
        }
        this.sort();

    }


    /**
     * This method draw a card in the library
     */
    public void draw() {

        this.tiles.add(this.game.getLibrary().remove(0));
        this.sort();

    }


    /**
     * This method sort the hand
     */
    public void sort() {
        Collections.sort(this.tiles);
    }


    /**
     * This method discard a card
     * @param num The position of the card in the hand
     */
    public void discard(int num) {
        this.game.addToDiscard(this.tiles.remove(num));
    }


    /**
     * This method return the number of card in the hand
     * @return The number of card
     */
    public int getSize() {
        return this.tiles.size();
    }


    /**
     * This method return the tiles of the hand
     * @return The list of tile
     */
    public List<Tile> getTiles() {
        return this.tiles;
    }


    /**
     * This method set the tiles of the hand
     * @param tiles The new tiles of the hand
     */
    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }


    /**
     * This method return the tile at the given position in the hand
     * @param num The position of the wanted tile
     * @return The tile at the given position
     */
    public Tile getTile(int num) {
        return this.tiles.get(num);
    }


    @NonNull
    @Override
    public String toString() {
       return this.tiles.toString();
    }


    /**
     * This method return the number of three of a kind inside the hand
     * @return The number of three of a kind
     */
    public int containsThreeOfAKind() {

        Map<TileType, Map<TileNum, Long>> map = this.tiles.stream().
                collect(Collectors.groupingBy(Tile::getType, Collectors.groupingBy(Tile::getHeight, Collectors.counting())));  //We group them by type and height, then we count them.

        long res = map.values().stream()
                .mapToLong(tileNumLongMap -> tileNumLongMap.values().stream()
                        .mapToLong(l -> l)
                        .max().orElse(0))
                .filter(l -> l >= 3)
                .count();


       return (int)res;

    }


    /**
     * This method return the number of row inside the hand
     * @return The number of row
     */
    public int containsRow() {

        int row = 0;
        int nbRow = 0;

        for(int i = 0; i < this.getSize() - 1; i++) {

            int diff = this.tiles.get(i+1).getPos() - this.tiles.get(i).getPos();

            if(diff == 1) {
                row++;

                if(row >= 2) {
                    nbRow++;
                    row = 0;
                    i++;
                }

            } else if(diff != 0) {
                row = 0;
            }
        }

        return nbRow;

    }
}
