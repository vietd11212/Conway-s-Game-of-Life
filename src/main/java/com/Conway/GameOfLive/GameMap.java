package com.Conway.GameOfLive;

public class GameMap {
    private static GameMap instance;
    Tile [][]map;
    static int width;
    static int height;


    //Contructor
    private GameMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    //convert string to Gamemap
    public GameMap convertStringToGameMap(String mapString) {
        String[] mapLines = mapString.lines().toArray(String[]::new);

        String[] s = mapLines[0].split(" ");
        width = Integer.parseInt(s[0]);
        height = Integer.parseInt(s[1]);

        //Gamemap
        map = new Tile[width][height];
        for (int i = 0; i < height; i++) {
            Tile[] lines = mapLines[i+1].replaceAll(" ","").toTileArray();
            for (int j = 0; j < lines.length; j++) {
                map[i][j] = lines[j];
            }
        }
    }

 /*   public Tile[] toTileArray(String[] array) {
        Tile[] tileArray = new Tile [array.length];
        for (int i = 0; i < array.length; i++) {
            tileArray[i] = (State)array[i];
        }
    }*/

    //Getter
    public static GameMap getInstance(int width, int height) throws Exception{
        try{
            if (instance == null) {
                instance = new GameMap(width, height);
            } else {
                if (GameMap.width == width && GameMap.height == height) {
                    return instance;
                } else {
                    throw new DimesionExeption(width,height);
                }
            }
        }catch (DimesionExeption e) {
            e.printStackTrace();
        }
        return instance;
    }




}
