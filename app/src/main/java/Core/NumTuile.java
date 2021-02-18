package Core;

import com.example.mahjong.R;

public enum NumTuile {

    Un(R.string.un),
    Deux(R.string.deux),
    Trois(R.string.trois),
    Quatre(R.string.quatre),
    Cinq(R.string.cinq),
    Six(R.string.six),
    Sept(R.string.sept),
    Huit(R.string.huit),
    Neuf(R.string.neuf);

    private String nom;

    private NumTuile(String nom) {
        this.nom = nom;
    }

}
