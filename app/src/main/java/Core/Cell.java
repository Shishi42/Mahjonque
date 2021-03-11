package Core;

import androidx.annotation.NonNull;

public class Cell {

    private String joueur;

    public Cell() {
        this.joueur = "";
    }

    public String getJoueur() {
        return this.joueur;
    }

    public void setJoueur(String joueur) {
        this.joueur = joueur;
    }

    @NonNull
    @Override
    public String toString() {
        return this.getJoueur();
    }
}
