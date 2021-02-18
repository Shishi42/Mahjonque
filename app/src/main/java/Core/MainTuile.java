package Core;

import androidx.annotation.NonNull;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MainTuile {

    private Set<Tuile> tuiles;

    public MainTuile() {
        this.tuiles = new LinkedHashSet<Tuile>();
    }

    public void ajoute(Tuile tuile) {
        this.tuiles.add(tuile);
    }

    public void retire(Tuile tuile) {
        this.tuiles.remove(tuile);
    }

    public int getTaille() {
        return this.tuiles.size();
    }


    @Override
    public String toString() {
       return this.tuiles.toString();
       //return tuiles.stream().map(t -> t.toString()).collect(Collectors.joining(", "));
    }
}
