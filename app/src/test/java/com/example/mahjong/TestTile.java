package com.example.mahjong;

import org.junit.Test;

import Core.TileNum;
import Core.Tile;
import Core.TileType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestTile {
    @Test
    public void getTile_is_correct() {


        assertEquals("sou : two : 0", Tile.getTile(TileType.BAMBOO, TileNum.TWO).toString());

        assertEquals("sou : two : 0", Tile.getTile(TileType.BAMBOO, TileNum.TWO, 0).toString());
        assertEquals("sou : two : 1", Tile.getTile(TileType.BAMBOO, TileNum.TWO, 1).toString());
        assertEquals("sou : two : 2", Tile.getTile(TileType.BAMBOO, TileNum.TWO, 2).toString());
        assertEquals("sou : two : 3", Tile.getTile(TileType.BAMBOO, TileNum.TWO, 3).toString());


    }

    @Test
    public void getTiles_is_correct() {

        assertEquals(136, Tile.getTiles().size());
        assertEquals(136, Tile.getTiles().size());

    }

}