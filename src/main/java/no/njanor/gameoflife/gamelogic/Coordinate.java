package no.njanor.gameoflife.gamelogic;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Coordinate
                && ((Coordinate) obj).x == x
                && ((Coordinate) obj).y == y;
    }
}
