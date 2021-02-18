package Core;

import com.example.mahjong.R;

public enum TypeTuile {

    BAMBOU(R.string.bambou),
    FEU(R.string.feu),
    PIECE(R.string.piece),
    VENT(R.string.vent),
    DRAGON(R.string.dragon);

    private String nom;

    private TypeTuile(String nom) {
        this.nom = nom;
    }

}
