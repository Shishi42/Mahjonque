package com.example.mahjong;

import org.junit.Test;

import Core.Game;
import Core.Player;

import static org.junit.Assert.assertEquals;

public class TestTileHand {

    @Test
    public void initMain_is_correct() {

        Game game = new Game();
        assertEquals(136, game.getTaillePioche());


        Player player = new Player(game);

        System.out.println(player.getMain());

        assertEquals(14, player.getMain().getTaille());
        assertEquals(122, game.getTaillePioche());

        player = new Player(game);
        player = new Player(game);
        player = new Player(game);
        player = new Player(game);
        player = new Player(game);
        player = new Player(game);
        player = new Player(game);
        player = new Player(game);

        assertEquals(10, game.getTaillePioche());

        player = new Player(game);


    }

}