package Core;

public class Joueur {

    private MainTuile main;
    private Jeu jeu;


    public Joueur(Jeu jeu) {

        this.main = new MainTuile();
        this.jeu = jeu;

        this.initPioche();

    }

    public void initPioche() {

        for(int i = 0; i < 14; i++) {
            this.pioche();
        }

    }

    public MainTuile getMain() {
        return this.main;
    }



    public void discard(Tuile tuile) {
        this.main.retire(tuile);
        this.jeu.toDiscard(tuile, this);
    }

    public void pioche() {
        this.main.ajoute(this.jeu.pioche());
    }

    public void voleTuile() {

    }

}
