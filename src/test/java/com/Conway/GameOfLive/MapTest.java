package com.Conway.GameOfLive;

import org.junit.Test;

public class MapTest {
    GameMap gameMap;

    @Test
    public void displayMapTest() {
        gameMap.generateGameMapFromTextFile("alivemap.txt");

    }

}
