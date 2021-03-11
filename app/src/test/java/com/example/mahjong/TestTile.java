package com.example.mahjong;

import org.junit.Test;

import Core.TileNum;
import Core.Tile;
import Core.TileType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestTile {
    @Test
    public void getTuile_is_correct() {


        assertEquals("Bamboo : Two : 0", Tile.getTile(TileType.BAMBOU, TileNum.TWO).toString());
        assertEquals("Bamboo : Two : 1", Tile.getTile(TileType.BAMBOU, TileNum.TWO).toString());
        assertEquals("Bamboo : Two : 2", Tile.getTile(TileType.BAMBOU, TileNum.TWO).toString());
        assertEquals("Bamboo : Two : 3", Tile.getTile(TileType.BAMBOU, TileNum.TWO).toString());

        assertEquals("Bamboo : Two : 0", Tile.getTile(TileType.BAMBOU, TileNum.TWO).toString());

        assertEquals("Bamboo : Two : 0", Tile.getTile(TileType.BAMBOU, TileNum.TWO, 0).toString());
        assertEquals("Bamboo : Two : 1", Tile.getTile(TileType.BAMBOU, TileNum.TWO, 1).toString());
        assertEquals("Bamboo : Two : 2", Tile.getTile(TileType.BAMBOU, TileNum.TWO, 2).toString());
        assertEquals("Bamboo : Two : 3", Tile.getTile(TileType.BAMBOU, TileNum.TWO, 3).toString());

        Exception exception = assertThrows(IllegalArgumentException.class, () -> Tile.getTile(TileType.BAMBOU, TileNum.TWO, 4));



    }

}