package com.example.mahjong;

import org.junit.Test;

import java.util.Arrays;

import Core.BoardGame;
import Core.MahjongGame;
import Core.Player;
import Core.Tile;
import Core.TileHand;
import Core.TileNum;
import Core.TileType;

import static org.junit.Assert.assertEquals;

public class TestTileHand {

    public TileHand testHandTile1() {
        TileHand test = new TileHand(new MahjongGame());

        test.setTiles(Arrays.asList(
                Tile.getTile(TileType.CHARACTER, TileNum.FOUR, 0),
                Tile.getTile(TileType.CHARACTER, TileNum.FIVE, 0),
                Tile.getTile(TileType.CHARACTER, TileNum.SIX, 0),
                Tile.getTile(TileType.CHARACTER, TileNum.SIX, 1),
                Tile.getTile(TileType.CHARACTER, TileNum.SEVEN, 0),
                Tile.getTile(TileType.CHARACTER, TileNum.SEVEN, 1),
                Tile.getTile(TileType.CHARACTER, TileNum.EIGHT, 0),
                Tile.getTile(TileType.CHARACTER, TileNum.EIGHT, 1),
                Tile.getTile(TileType.CIRCLE, TileNum.ONE, 0),
                Tile.getTile(TileType.CIRCLE, TileNum.TWO, 0),
                Tile.getTile(TileType.CIRCLE, TileNum.FOUR, 0),
                Tile.getTile(TileType.CIRCLE, TileNum.FIVE, 0),
                Tile.getTile(TileType.CIRCLE, TileNum.SIX, 0),
                Tile.getTile(TileType.CIRCLE, TileNum.EIGHT, 0)

        ));

        test.sort();
        return test;
    }


    public TileHand testHandTile2() {
        TileHand test = new TileHand(new MahjongGame());

        test.setTiles(Arrays.asList(
                Tile.getTile(TileType.CHARACTER, TileNum.FOUR, 0),
                Tile.getTile(TileType.CHARACTER, TileNum.FIVE, 0),
                Tile.getTile(TileType.CHARACTER, TileNum.SIX, 0),
                Tile.getTile(TileType.DRAGON, TileNum.ONE, 0),
                Tile.getTile(TileType.CHARACTER, TileNum.SEVEN, 0),
                Tile.getTile(TileType.CHARACTER, TileNum.SEVEN, 1),
                Tile.getTile(TileType.CHARACTER, TileNum.EIGHT, 0),
                Tile.getTile(TileType.CHARACTER, TileNum.EIGHT, 1),
                Tile.getTile(TileType.CIRCLE, TileNum.ONE, 0),
                Tile.getTile(TileType.CIRCLE, TileNum.TWO, 0),
                Tile.getTile(TileType.CIRCLE, TileNum.FOUR, 0),
                Tile.getTile(TileType.CIRCLE, TileNum.FIVE, 0),
                Tile.getTile(TileType.CIRCLE, TileNum.SIX, 0),
                Tile.getTile(TileType.CIRCLE, TileNum.EIGHT, 0)

        ));

        test.sort();
        return test;
    }

    @Test
    public void containThreeOfAKind_is_correct() {

        assertEquals(0, testHandTile1().containsThreeOfAKind());
        assertEquals(0, testHandTile2().containsThreeOfAKind());

    }

    @Test
    public void containRow_is_correct() {

        assertEquals(3, testHandTile1().containsRow());
        assertEquals(2, testHandTile2().containsRow());

    }

}