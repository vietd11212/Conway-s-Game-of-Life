package com.Conway.GameOfLive;
import java.applet.Applet;
import java.awt.*;
import javax.swing.*;

public class DisplayGameMap extends Applet {
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

    //use Applet, (can embedded to HTML, work at client side), to draw Tilemap
    @Override
    public void init() {
        super.init();
        setSize(gameMap.width,gameMap.height);
        setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(int i = 0; i < gameMap.width; i++) {
            for (int j = 0; j < gameMap.height; j++) {
                g.fillRect(16*i, 16*j, 16, 16);
            }
        }
    }
}
