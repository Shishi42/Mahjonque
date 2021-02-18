package Core;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Jeu {

    private List<Joueur> joueurs;
    private LinkedList<Tuile> pioche;
    private List<Tuile> deadWall;

    public Jeu() {

        this.joueurs = new LinkedList<Joueur>();
        this.pioche = new LinkedList<Tuile>();
        this.deadWall = new LinkedList<Tuile>();

        this.initPioche();

    }

    public void initPioche() {

        for(TypeTuile type : TypeTuile.values()) {
            for(NumTuile hauteur : NumTuile.values()) {
                for(int i = 0; i < 4; i++) {
                    this.pioche.add(Tuile.getTuile(type, hauteur));
                }
            }
        }

        this.pioche = (LinkedList<Tuile>) this.pioche.stream().
                filter(t -> !(t.getType() == TypeTuile.DRAGON && t.getHauteur().getNum() > 3)).
                filter(t -> !(t.getType() == TypeTuile.VENT && t.getHauteur().getNum() > 4)).
                collect(Collectors.toCollection(LinkedList::new));

        Collections.shuffle(this.pioche);

    }

    public void toDiscard(Tuile tuile, Joueur joueur) {

    }

    public int getTaillePioche() {
        return this.pioche.size();
    }

    public Tuile pioche() {
        return this.pioche.removeFirst();
    }
}
