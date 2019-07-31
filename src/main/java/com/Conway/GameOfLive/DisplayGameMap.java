package com.Conway.GameOfLive;
import java.awt.*;
import javax.swing.*;

public class DisplayGameMap {
    GameMap gameMap;
    Graphics graphics;

    //Create a Graphic for Conway game
    public void displayGraphic(){
        short tileSize = 10;
        for (short i = 0; i < gameMap.width; i++){
            for (short j = 0; j < gameMap.height; j++) {
                graphics.setColor(gameMap.map[i][j].getState() == State.INFECT ? Color.WHITE : Color.BLACK);
                graphics.fillRect(i*tileSize,j*tileSize,tileSize,tileSize);
            }
        }
    }
}
