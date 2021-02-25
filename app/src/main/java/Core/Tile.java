package Core;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;


public class Tile implements Comparable<Tile> {

    private static Set<Tile> tiles = new LinkedHashSet<Tile>();

    private TileType type;
    private TileNum hauteur;
    private int num;

    public static Tile getTile(TileType type, TileNum hauteur) {

        Tile tile;

        if(Tile.tiles.stream().
                filter(t -> t.getType() == type && t.getHauteur() == hauteur).
                count() < 4) {

            tile = new Tile(type, hauteur);

        } else {

            tile = Tile.tiles.stream().
                    filter(t -> t.getType() == type && t.getHauteur() == hauteur).
                    findFirst().
                    get();
        }


        Tile.tiles.add(tile);

        return tile;

    }

    public static Tile getTile(TileType type, TileNum hauteur, int num) throws IllegalArgumentException {

        Optional<Tile> tuile = Tile.tiles.stream().
                filter(t -> t.getType() == type && t.getHauteur() == hauteur && t.getNum() == num).
                findFirst();

        if(!tuile.isPresent()) {
            throw new IllegalArgumentException();
        }

        return tuile.get();

    }

    private Tile(TileType type, TileNum hauteur) {

        this.type = type;
        this.hauteur = hauteur;
        this.num = Tile.tiles.stream().
                filter(t -> t.getType() == type && t.getHauteur() == hauteur).
                mapToInt(t -> t.getNum()).
                max().
                orElse(-1) + 1;

    }

    public TileType getType() {
        return this.type;
    }

    public TileNum getHauteur() {
        return this.hauteur;
    }

    public int getNum() {
        return this.num;
    }

    @Override
    public int compareTo(Tile tile) {

        int ret = 0;
        ret = this.getType().compareTo(tile.getType());
        if(ret == 0) ret = this.getHauteur().compareTo(tile.getHauteur());
        if(ret == 0) ret = this.getNum() - tile.getNum();

        return ret;

    }

    @Override
    public String toString() {
        return this.getType().toString() + " : " + this.getHauteur().toString() + " : " + this.getNum();
    }

}
