package Core;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;
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

        this.tiles.clear();
        this.game.getLibrary().stream().limit(14).forEach(t -> this.tiles.add(t));
        this.game.getLibrary().removeAll(this.tiles);
        Collections.sort(this.tiles);

    }

    public void draw() {

        this.tiles.add(this.game.getLibrary().remove(0));
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
     *
     * @return
     */
    public int containsThreeOfAKind() {

        Map<TileType, Map<TileNum, Long>> map = this.tiles.stream().
                collect(Collectors.groupingBy(Tile::getType, Collectors.groupingBy(Tile::getHauteur, Collectors.counting())));  //We group them by type and height, then we count them.

        long res = map.entrySet().stream()
                .mapToLong(m -> m.getValue().entrySet().stream()
                        .mapToLong(Map.Entry::getValue)
                        .max().orElse(0))
                .filter(l -> l >= 3)
                .count();


       return (int)res;

    }

    public int containsRow() {

        int suite = 0;
        int nbSuite = 0;

        String test = "";

        for(int i = 0; i < this.getSize() - 1; i++) {

            int diff = this.tiles.get(i+1).getPos() - this.tiles.get(i).getPos();
            test += diff + " : ";

            if(diff == 1) {
                suite++;

                if(suite >= 2) {
                    nbSuite++;
                    suite = 0;
                }

            } else if(diff != 0) {
                suite = 0;
            }
        }

        System.out.println(test);
        System.out.println(nbSuite);
        return nbSuite;

    }
}
