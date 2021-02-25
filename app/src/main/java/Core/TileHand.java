package Core;

import java.util.LinkedHashSet;
import java.util.Set;

public class TileHand {

    private Set<Tile> tiles;

    public TileHand() {
        this.tiles = new LinkedHashSet<Tile>();
    }

    public void ajoute(Tile tile) {
        this.tiles.add(tile);
    }

    public void retire(Tile tile) {
        this.tiles.remove(tile);
    }

    public int getTaille() {
        return this.tiles.size();
    }

    public Set<Tile> getTiles() {
        return this.tiles;
    }


    @Override
    public String toString() {
       return this.tiles.toString();
       //return tuiles.stream().map(t -> t.toString()).collect(Collectors.joining(", "));
    }
}
