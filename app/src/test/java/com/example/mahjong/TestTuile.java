package com.example.mahjong;

import org.junit.Test;

import Core.NumTuile;
import Core.Tuile;
import Core.TypeTuile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestTuile {
    @Test
    public void getTuile_is_correct() {


        assertEquals("Bamboo : Two : 0", Tuile.getTuile(TypeTuile.BAMBOU, NumTuile.DEUX).toString());
        assertEquals("Bamboo : Two : 1", Tuile.getTuile(TypeTuile.BAMBOU, NumTuile.DEUX).toString());
        assertEquals("Bamboo : Two : 2", Tuile.getTuile(TypeTuile.BAMBOU, NumTuile.DEUX).toString());
        assertEquals("Bamboo : Two : 3", Tuile.getTuile(TypeTuile.BAMBOU, NumTuile.DEUX).toString());

        assertEquals("Bamboo : Two : 0", Tuile.getTuile(TypeTuile.BAMBOU, NumTuile.DEUX).toString());

        assertEquals("Bamboo : Two : 0", Tuile.getTuile(TypeTuile.BAMBOU, NumTuile.DEUX, 0).toString());
        assertEquals("Bamboo : Two : 1", Tuile.getTuile(TypeTuile.BAMBOU, NumTuile.DEUX, 1).toString());
        assertEquals("Bamboo : Two : 2", Tuile.getTuile(TypeTuile.BAMBOU, NumTuile.DEUX, 2).toString());
        assertEquals("Bamboo : Two : 3", Tuile.getTuile(TypeTuile.BAMBOU, NumTuile.DEUX, 3).toString());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> Tuile.getTuile(TypeTuile.BAMBOU, NumTuile.DEUX, 4));



    }

}