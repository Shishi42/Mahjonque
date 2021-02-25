package Core;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private List<Player> players;
    private LinkedList<Tile> pioche;
    private List<Tile> deadWall;

    public Game() {

        this.players = new LinkedList<Player>();
        this.pioche = new LinkedList<Tile>();
        this.deadWall = new LinkedList<Tile>();

        this.initPioche();

    }

    public void initPioche() {

        for(TileType type : TileType.values()) {
            for(TileNum hauteur : TileNum.values()) {
                for(int i = 0; i < 4; i++) {
                    this.pioche.add(Tile.getTile(type, hauteur));
                }
            }
        }

        this.pioche = (LinkedList<Tile>) this.pioche.stream().
                filter(t -> !(t.getType() == TileType.DRAGON && t.getHauteur().getNum() > 3)).
                filter(t -> !(t.getType() == TileType.VENT && t.getHauteur().getNum() > 4)).
                collect(Collectors.toCollection(LinkedList::new));

        Collections.shuffle(this.pioche);

    }

    public void toDiscard(Tile tile, Player player) {

    }

    public int getTaillePioche() {
        return this.pioche.size();
    }

    public Tile pioche() {
        return this.pioche.removeFirst();
    }

    public List<Tile> getPioche() {
        return this.pioche;
    }
}
