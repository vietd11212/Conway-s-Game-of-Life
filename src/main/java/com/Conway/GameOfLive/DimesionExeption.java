package com.Conway.GameOfLive;

public class DimesionExeption extends Exception {
    DimesionExeption(int width, int height) {
        System.out.println("Dimension Exception with width "+ width+ " and height " + height);
    }
}
