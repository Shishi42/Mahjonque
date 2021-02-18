package Core;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;


public class Tuile implements Comparable<Tuile> {

    private static Set<Tuile> tuiles = new LinkedHashSet<Tuile>();

    private TypeTuile type;
    private NumTuile hauteur;
    private int num;

    public static Tuile getTuile(TypeTuile type, NumTuile hauteur) {

        Tuile tuile;

        if(Tuile.tuiles.stream().
                filter(t -> t.getType() == type && t.getHauteur() == hauteur).
                count() < 4) {

            tuile = new Tuile(type, hauteur);

        } else {

            tuile = Tuile.tuiles.stream().
                    filter(t -> t.getType() == type && t.getHauteur() == hauteur).
                    findFirst().
                    get();
        }


        Tuile.tuiles.add(tuile);

        return tuile;

    }

    public static Tuile getTuile(TypeTuile type, NumTuile hauteur, int num) throws IllegalArgumentException {

        Optional<Tuile> tuile = Tuile.tuiles.stream().
                filter(t -> t.getType() == type && t.getHauteur() == hauteur && t.getNum() == num).
                findFirst();

        if(!tuile.isPresent()) {
            throw new IllegalArgumentException();
        }

        return tuile.get();

    }

    private Tuile(TypeTuile type, NumTuile hauteur) {

        this.type = type;
        this.hauteur = hauteur;
        this.num = Tuile.tuiles.stream().
                filter(t -> t.getType() == type && t.getHauteur() == hauteur).
                mapToInt(t -> t.getNum()).
                max().
                orElse(-1) + 1;

    }

    public TypeTuile getType() {
        return this.type;
    }

    public NumTuile getHauteur() {
        return this.hauteur;
    }

    public int getNum() {
        return this.num;
    }

    @Override
    public int compareTo(Tuile tuile) {

        int ret = 0;
        ret = this.getType().compareTo(tuile.getType());
        if(ret == 0) ret = this.getHauteur().compareTo(tuile.getHauteur());
        if(ret == 0) ret = this.getNum() - tuile.getNum();

        return ret;

    }

    @Override
    public String toString() {
        return this.getType().toString() + " : " + this.getHauteur().toString() + " : " + this.getNum();
    }

}
