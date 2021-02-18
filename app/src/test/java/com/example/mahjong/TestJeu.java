package com.example.mahjong;

import org.junit.Test;

import Core.Jeu;
import Core.NumTuile;
import Core.Tuile;
import Core.TypeTuile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestJeu {
    @Test
    public void initPioche_is_correct() {

        Jeu jeu = new Jeu();

        assertEquals(136, jeu.getTaillePioche());

    }

}