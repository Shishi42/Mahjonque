package Core;

import com.example.mahjong.MainActivity;
import com.example.mahjong.R;

public enum TypeTuile {

    BAMBOU("Bamboo"),
    FEU("Character"),
    PIECE("Circle"),
    VENT("Wind"),
    DRAGON("Dragon");

    private String nom;

    private TypeTuile(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return this.nom;
    }

}
