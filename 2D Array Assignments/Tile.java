public class Tile {

    private boolean shot;
    private boolean hasShip;

    public Tile(boolean hasShip) {
        shot = false;
        this.hasShip = hasShip;
    }

    public boolean getShot() {
        return shot;
    }

    public boolean getHasShip() {
        return hasShip;
    }

    public void shoot() {
        shot = true;
    }

}
