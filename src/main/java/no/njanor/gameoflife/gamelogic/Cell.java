package no.njanor.gameoflife.gamelogic;

public class Cell {
    private Coordinate coordinate;
    private boolean isAlive;

    public Cell(Coordinate coordinate, boolean isAlive) {
        this.coordinate = coordinate;
        this.isAlive = isAlive;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Cell &&
                ((Cell) obj).coordinate.equals(coordinate) &&
                ((Cell) obj).isAlive == isAlive;
    }
}
