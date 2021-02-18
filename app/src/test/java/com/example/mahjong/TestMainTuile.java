package com.example.mahjong;

import org.junit.Test;

import Core.Jeu;
import Core.Joueur;

import static org.junit.Assert.assertEquals;

public class TestMainTuile {

    @Test
    public void initMain_is_correct() {

        Jeu jeu = new Jeu();
        assertEquals(136, jeu.getTaillePioche());


        Joueur joueur = new Joueur(jeu);

        System.out.println(joueur.getMain());

        assertEquals(14, joueur.getMain().getTaille());
        assertEquals(122, jeu.getTaillePioche());

        joueur = new Joueur(jeu);
        joueur = new Joueur(jeu);
        joueur = new Joueur(jeu);
        joueur = new Joueur(jeu);
        joueur = new Joueur(jeu);
        joueur = new Joueur(jeu);
        joueur = new Joueur(jeu);
        joueur = new Joueur(jeu);

        assertEquals(10, jeu.getTaillePioche());

        joueur = new Joueur(jeu);


    }

}