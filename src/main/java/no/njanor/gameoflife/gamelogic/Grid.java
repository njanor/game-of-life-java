package no.njanor.gameoflife.gamelogic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Grid {
    private HashMap<Coordinate, Boolean> grid = new HashMap<Coordinate, Boolean>();

    public Grid(boolean[][] seed) {
        if (seed == null)
            return;
        for (int i = 0; i < seed.length; i++)
            for (int j = 0; j < seed[i].length; j++)
                if (seed[i][j])
                    grid.put(new Coordinate(i, j), true);
    }

    public Collection<Cell> getAllLivingCells() {
        Collection<Cell> livingCells = new ArrayList<Cell>();

        for (Coordinate coordinate :
                grid.keySet()) {
            livingCells.add(new Cell(coordinate, grid.get(coordinate)));
        }

        return livingCells;
    }

    public int getNumberOfLivingNeighbours(Coordinate coordinate) {
        int numberOfLivingNeighbours = 0;
        for (int currentX = coordinate.getX() - 1; currentX <= coordinate.getX() + 1; currentX++)
            for (int currentY = coordinate.getY() - 1; currentY <= coordinate.getY() + 1; currentY++) {
                Coordinate currentCoordinate = new Coordinate(currentX, currentY);
                boolean hasLivingCell = grid.containsKey(currentCoordinate);
                boolean isSameCoordinate = currentCoordinate.equals(coordinate);
                if (hasLivingCell && !isSameCoordinate)
                    numberOfLivingNeighbours++;
            }
        return numberOfLivingNeighbours;
    }

    public Cell getCellAt(Coordinate coordinate) {
        if (grid.containsKey(coordinate))
            return new Cell(coordinate, true);
        return new Cell(coordinate, false);
    }
}
