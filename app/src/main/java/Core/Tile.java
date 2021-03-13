package Core;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


public class Tile implements Comparable<Tile> {

    private static Set<Tile> tiles = new LinkedHashSet<Tile>();

    private TileType type;
    private TileNum hauteur;
    private int num;

    public static Set<Tile> getTiles() {

        if(tiles.size() == 0) {

            for (TileType type : TileType.values()) {
                for (TileNum num : TileNum.values()) {
                    tiles.add(new Tile(type, num, 0));
                    tiles.add(new Tile(type, num, 1));
                    tiles.add(new Tile(type, num, 2));
                    tiles.add(new Tile(type, num, 3));
                }
            }


            tiles = tiles.stream().
                    filter(t -> !(t.getType() == TileType.WIND && t.getHauteur().getNum() > 3)).
                    filter(t -> !(t.getType() == TileType.DRAGON && t.getHauteur().getNum() > 2)).
                    collect(Collectors.toSet());


        }


        return tiles;

    }

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

        Optional<Tile> tile = Tile.tiles.stream().
                filter(t -> t.getType() == type && t.getHauteur() == hauteur && t.getNum() == num).
                findFirst();

        if(!tile.isPresent()) {
            throw new IllegalArgumentException();
        }

        return tile.get();

    }


    private Tile(TileType type, TileNum hauteur, int num) {

        this.type = type;
        this.hauteur = hauteur;
        this.num = num;

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

        int ret = this.getType().compareTo(tile.getType());
        if(ret == 0) ret = this.getHauteur().compareTo(tile.getHauteur());

        return ret;

    }

    public int getPos() {
        return this.getType().getNum() * 100 + this.getHauteur().getNum();
    }

    @Override
    public String toString() {
        return this.getType().toString() + " : " + this.getHauteur().toString() + " : " + this.getNum();
    }

}
