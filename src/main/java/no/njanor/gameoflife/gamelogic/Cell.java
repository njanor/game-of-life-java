package no.njanor.gameoflife.gamelogic;

public class Cell {
    private final Coordinate coordinate;
    private final boolean alive;

    public Cell(Coordinate coordinate, boolean alive) {
        this.coordinate = coordinate;
        this.alive = alive;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public boolean isAlive() {
        return alive;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Cell &&
                ((Cell) obj).coordinate.equals(coordinate) &&
                ((Cell) obj).alive == alive;
    }

    @Override
    public int hashCode() {
        return alive ? 0 : 1 + coordinate.hashCode();
    }
}
