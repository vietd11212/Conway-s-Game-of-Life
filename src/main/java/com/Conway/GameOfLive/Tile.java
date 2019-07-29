package com.Conway.GameOfLive;

public class Tile {

    private State state;

    public Tile(State state) {
        this.state = state;
    }

    //Getter
    public State getState() {
        return state;
    }

    // Setter
    public void setState(State state) {
        this.state = state;
    }
}
