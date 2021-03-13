package Core;

import androidx.annotation.NonNull;

public class TupleMahjong /*implements Comparable<TupleMahjong> */ {

    TileType type;
    TileNum num;
/*
    public TupleMahjong(TileType type, TileNum num) {

        this.type = type;
        this.num = num;

    }

    public TileType getType() {
        return this.type;
    }

    public TileNum getHauteur() {
        return this.num;
    }
*/
    @NonNull
    @Override
    public String toString() {
        return this.type + " : " + this.num;
    }

/*
    @Override
    public int compareTo(TupleMahjong tile) {

        int ret = 0;
        ret = this.getType().compareTo(tile.getType());
        if(ret == 0) ret = this.getHauteur().compareTo(tile.getHauteur());

        return ret;

    }*/
}
