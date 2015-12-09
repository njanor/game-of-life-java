package no.njanor.gameoflife.gamelogic;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Grid {
    private Set<Coordinate> coordinatesOfLivingCells = new HashSet<>();

    public Grid() { }

    public Grid(boolean[][] seed) {
        if (seed == null)
            return;
        for (int i = 0; i < seed.length; i++)
            for (int j = 0; j < seed[i].length; j++)
                if (seed[i][j])
                    coordinatesOfLivingCells.add(new Coordinate(i, j));
    }

    public Collection<Cell> getAllLivingCells() {
        return coordinatesOfLivingCells.stream()
                .map(coordinate -> new Cell(coordinate, true))
                .collect(Collectors.toList());
    }

    public int getNumberOfLivingNeighbours(Coordinate coordinate) {
        int numberOfLivingNeighbours = 0;
        for (int currentX = coordinate.getX() - 1; currentX <= coordinate.getX() + 1; currentX++)
            for (int currentY = coordinate.getY() - 1; currentY <= coordinate.getY() + 1; currentY++) {
                Coordinate currentCoordinate = new Coordinate(currentX, currentY);
                boolean hasLivingCell = coordinatesOfLivingCells.contains(currentCoordinate);
                boolean isSameCoordinate = currentCoordinate.equals(coordinate);
                if (hasLivingCell && !isSameCoordinate)
                    numberOfLivingNeighbours++;
            }
        return numberOfLivingNeighbours;
    }

    public Cell getCellAt(Coordinate coordinate) {
        if (coordinatesOfLivingCells.contains(coordinate))
            return new Cell(coordinate, true);
        return new Cell(coordinate, false);
    }

    public void setCell(Cell cell) {
        coordinatesOfLivingCells.add(cell.getCoordinate());
    }
}
