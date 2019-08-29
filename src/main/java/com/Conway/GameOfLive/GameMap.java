package com.Conway.GameOfLive;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class GameMap {
    private static GameMap instance;
    Tile [][]map;
    static int width;
    static int height;


   //Contructor
    private GameMap () {}

    /**
     * This method generates the gameMap based on the passed string.
     * 0 - dead (infected)
     * 1 - alive (recovered)
     * @param mapString
     * @return the gameMap
     */
    public void convertStringToGameMap(String mapString) {
        String[] mapLines = mapString.lines().toArray(String[]::new);

        String[] s = mapLines[0].split(" ");
        width = Integer.parseInt(s[0]);
        height = Integer.parseInt(s[1]);

        //Gamemap
        map = new Tile[width][height];
        for (int i = 0; i < height; i++) {
            char[] lines = mapLines[i+1].replaceAll(" ","").toCharArray();
            for (int j = 0; j < lines.length; j++) {
                map[i][j].setState(lines[j] == '0' ? State.INFECT : State.SUSPECTED);
            }
        }
    }

    public void generateGameMapFromTextFile(String mapName) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(String.format("/%s",mapName))))) {
            convertStringToGameMap(br.lines().collect(Collectors.joining("\n")));
        } catch (IOException e) {
            System.err.println("Couldn't read file.");
            e.printStackTrace();
        }
    }

    //Getter
    public static GameMap getInstance(){
        return (instance == null) ? instance = new GameMap() : instance;
    }

}
