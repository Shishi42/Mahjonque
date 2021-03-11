package Core;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class TileHand {

    private MahjongGame game;
    private List<Tile> tiles;

    public TileHand(MahjongGame game) {

        this.game = game;
        this.tiles = new LinkedList<Tile>();

    }

    public void initHand() {

        this.tiles = this.game.getLibrary().stream().limit(14).collect(Collectors.toList());
        Collections.sort(this.tiles);

    }

    public void draw() {

        this.tiles.add(this.game.getLibrary().get(0));
        this.game.getLibrary().remove(0);
        Collections.sort(this.tiles);

    }

    public void discard(int num) {
        this.game.addToDiscard(this.tiles.remove(num));
    }

    public int getSize() {
        return this.tiles.size();
    }

    public List<Tile> getTiles() {
        return this.tiles;
    }

    public Tile getTile(int num) {
        return this.tiles.get(num);
    }


    @Override
    public String toString() {
       return this.tiles.toString();
    }


    /**
     * TODO::Fix this
     * @return
     */
    public boolean containsThreeOfAKind() {

        Map<TupleMahjong, List<Tile>> map = this.tiles.stream().
                collect(Collectors.groupingBy(t -> new TupleMahjong(t.getType(), t.getHauteur())));  //We group them by type and height, then we count them.

        System.out.println("Map : " + map);
/*
        Optional<Long> res = map.entrySet().stream().
                map(Map.Entry::getValue).
                max(Long::compare);

        if(res.isPresent()) {
            System.out.println("Map : " + map);
            System.out.println("Res : " + res.get());
            return res.get() >= 3;
        } else {
            return false;
        }
*/
        return true;


    }

    public boolean containsRow() {
        return false;
    }
}
