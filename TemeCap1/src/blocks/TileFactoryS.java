package blocks;

public class TileFactoryS {
    private static Tile greenTile;
    private static Tile redTile;
    private Singleton1 singleton1;
    
    private static TileFactoryS instance;
   
    public void TileFactoryS() {
        singleton1 = Singleton1.getInstance();
    }
    public static TileFactoryS getInstance() {
        if (instance == null) {
            instance = new TileFactoryS();
        }
        return instance;
    }
    public Tile newTile(Tile.Color color) {
        if (color == Tile.Color.GREEN) {
            if (greenTile == null) {
                greenTile = createGreenTile();
            }
            return greenTile;
        } else if (color == Tile.Color.RED) {
            if (redTile == null) {
                redTile = createRedTile();
            }
            return redTile;
        }

        System.err.println("Invalid color given as parameter");
        return null;
    }
    
    

    // Metoda pentru a crea un Tile verde folosind Singleton
    private static Tile createGreenTile() {
        if (greenTile == null) {
            greenTile = new TileFactory().newTile(Tile.Color.GREEN);
        }
        return greenTile;
    }

    // Metoda pentru a crea un Tile roșu folosind Singleton
    private static Tile createRedTile() {
        if (redTile == null) {
            redTile = new TileFactory().newTile(Tile.Color.RED);
        }
        return redTile;
    }
}
