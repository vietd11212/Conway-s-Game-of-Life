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

    /**
     * This method generates the gameMap based on the passed string.
     * 0 - dead (infected)
     * 1 - alive (recovered)
     * @param mapString
     * @return the gameMap
     */
    public Tile[][] convertStringToGameMap(String mapString) {
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

        return map;
    }

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
