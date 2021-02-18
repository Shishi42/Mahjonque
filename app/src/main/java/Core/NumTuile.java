package Core;

import com.example.mahjong.MainActivity;
import com.example.mahjong.R;

public enum NumTuile {

    UN("One", 1),
    DEUX("Two", 2),
    TROIS("Three", 3),
    QUATRE("Four", 4),
    CINQ("Five", 5),
    SIX("Six", 6),
    SEPT("Seven", 7),
    HUIT("Eight", 8),
    NEUF("Nine", 9);

    private String nom;
    private int num;

    private NumTuile(String nom, int num) {

        this.nom = nom;
        this.num = num;

    }

    public int getNum() {
        return this.num;
    }

    @Override
    public String toString() {
        return this.nom;
    }

}
