package com.Conway.GameOfLive;

public class Conway {
    GameMap gameMap;
    public static final int[][] CORNER = {{0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}, {-1,0}, {-1,1}};

    //Conway algorithm
    protected void transition(Tuple coordinate) {
        if (gameMap.map[coordinate.getX()][coordinate.getY()].getState() == State.SUSPECTED){
            if (getAliveNeighbor(coordinate)< 2 || getAliveNeighbor(coordinate) > 3){
                gameMap.map[coordinate.getX()][coordinate.getY()].setState(State.INFECT);
            } else if (getAliveNeighbor(coordinate) == 2 || getAliveNeighbor(coordinate) == 3) {
                gameMap.map[coordinate.getX()][coordinate.getY()].setState(State.SUSPECTED);
            }
        } else {
            if (getAliveNeighbor(coordinate) == 3) {
                gameMap.map[coordinate.getX()][coordinate.getY()].setState(State.SUSPECTED);
            }
        }
    }

    //get number of alive cells
    protected short getAliveNeighbor(Tuple coordinate) {
        short count = 0;
        int x = coordinate.getX();
        int y = coordinate.getY();
        int currentX;
        int currentY;
        for (short i = 0; i < 8; i++){
            currentX = x + CORNER[i][0];
            currentY = y + CORNER[i][1];
            if (gameMap.map[currentX][currentY].getState() == State.SUSPECTED) count++;
        }
        return count;
    }

}
