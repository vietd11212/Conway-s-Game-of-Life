import java.util.HashMap;
public class GameMap {
    private  static GameMap instance;

    public static GameMap getInstance() {
        return (instance == null) ? instance = new GameMap() : instance;
    }


}
