package no.njanor.gameoflife.gamelogic;

import java.util.*;
import java.util.stream.Collectors;

public class GameState {
    private Set<Coordinate> coordinatesOfLivingCells = new HashSet<>();

    public GameState() { }

    public GameState(Coordinate... coordinates) {
        if (coordinates == null)
            coordinatesOfLivingCells = new HashSet<>();
        else
            coordinatesOfLivingCells = Arrays.asList(coordinates).stream().filter(e -> e != null).collect(Collectors.toSet());
    }

    public Collection<Cell> getAllLivingCells() {
        return coordinatesOfLivingCells.stream()
                .map(coordinate -> new Cell(coordinate, true))
                .collect(Collectors.toList());
    }

    public int getNumberOfLivingNeighbours(Coordinate coordinate) {
        return (int)getAllNeighboursToCoordinate(coordinate).stream()
                .filter(c -> c.isAlive())
                .count();
    }

    public Cell getCellAt(Coordinate coordinate) {
        if (coordinatesOfLivingCells.contains(coordinate))
            return new Cell(coordinate, true);
        return new Cell(coordinate, false);
    }

    public void setCell(Cell cell) {
        coordinatesOfLivingCells.add(cell.getCoordinate());
    }

    public Collection<Cell> getAllNeighboursToCoordinate(Coordinate coordinate) {
        Collection<Cell> neighbours = new ArrayList<>(8);

        for (int currentX = coordinate.getX() - 1; currentX <= coordinate.getX() + 1; currentX++)
            for (int currentY = coordinate.getY() - 1; currentY <= coordinate.getY() + 1; currentY++) {
                Coordinate currentCoordinate = new Coordinate(currentX, currentY);
                if (currentCoordinate.equals(coordinate))
                    continue;
                neighbours.add(getCellAt(currentCoordinate));
            }
        return neighbours;
    }
}
