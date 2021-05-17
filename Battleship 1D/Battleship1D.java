import java.util.Random;

public class Battleship1D {

    private Tile[] tiles;
    private int shipSeed;

    public Battleship1D() {
        generateGrid();
    }

    private void generateGrid() {
        tiles = new Tile[7];
        Random random = new Random();
        shipSeed = random.nextInt(4);
        for(int i = 0; i < 7; i++) {
            boolean ship = i == shipSeed || (i - 1) == shipSeed || (i - 2) == shipSeed;
            tiles[i] = new Tile(ship);
        }
    }

    public boolean canShootTile(int i) {
        return !tiles[i].getShot();
    }

    public boolean shootTile(int i) {
        tiles[i].shoot();
        return tiles[i].getHasShip();
    }

    public boolean isShipSunk() {
        if(!tiles[shipSeed].getShot()) return false;
        if(!tiles[shipSeed + 1].getShot()) return false;
        if(!tiles[shipSeed + 2].getShot()) return false;
        return true;
    }

}
