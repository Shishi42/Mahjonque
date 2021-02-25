package Core;

public class Player {

    private TileHand main;
    private Game game;


    public Player(Game game) {

        this.main = new TileHand();
        this.game = game;

        this.initPioche();

    }

    public void initPioche() {

        for(int i = 0; i < 14; i++) {
            this.pioche();
        }

    }

    public TileHand getMain() {
        return this.main;
    }



    public void discard(Tile tile) {
        this.main.retire(tile);
        this.game.toDiscard(tile, this);
    }

    public void pioche() {
        this.main.ajoute(this.game.pioche());
    }

    public void voleTuile() {

    }

}
