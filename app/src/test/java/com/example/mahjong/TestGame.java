package com.example.mahjong;

import org.junit.Test;

import Core.Game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestGame {
    @Test
    public void initPioche_is_correct() {

        Game game = new Game();

        assertEquals(136, game.getTaillePioche());

    }

}