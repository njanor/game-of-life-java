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

    public String toString(int width, int height) {
        StringBuilder result = new StringBuilder();
        result.append(getDelimiter(width));
        result.append('\n');
        for (int i = 0; i < width; i++) {
            result.append('|');
            for (int j = 0; j < height; j++) {
                result.append(writeCellAt(i, j));
            }
            result.append('\n');
        }
        result.append(getDelimiter(width));
        return result.toString();
    }

    private String getDelimiter(int numberOfCells) {
        StringBuilder delimiter = new StringBuilder();
        for (int i = 0; i < (numberOfCells * 2) + 1; i++)
            delimiter.append('-');
        return delimiter.toString();
    }

    private String writeCellAt(final int x, final int y) {
        if (getCellAt(new Coordinate(x, y)).isAlive())
            return "x|";
        return " |";
    }
}
