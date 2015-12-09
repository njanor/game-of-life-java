package no.njanor.gameoflife.gamelogic;

import java.util.Collection;

public class GameEngine {

    public static Grid evolve(Grid currentGameState) {
        Grid newGameState = new Grid();
        Collection<Cell> currentlyLivingCells = currentGameState.getAllLivingCells();

        for (Cell cell : currentlyLivingCells) {
            determineIfCellAndAllNeighboursShouldBeAliveInNextState(currentGameState, newGameState, cell);
        }
        return newGameState;
    }

    private static void determineIfCellAndAllNeighboursShouldBeAliveInNextState(Grid currentGameState, Grid newGameState, Cell cell) {
        for (int x = cell.getCoordinate().getX() - 1; x <= cell.getCoordinate().getX() + 1; x++)
            for (int y = cell.getCoordinate().getY() - 1; y <= cell.getCoordinate().getY() + 1; y++) {
                determineIfCellShouldLiveInNextState(currentGameState, newGameState, currentGameState.getCellAt(new Coordinate(x, y)));
            }
    }

    private static void determineIfCellShouldLiveInNextState(Grid currentGameState, Grid newGameState, Cell cell) {
        int livingNeighboursForCurrentCell = currentGameState.getNumberOfLivingNeighbours(cell.getCoordinate());
        if (livingNeighboursForCurrentCell == 3 || (cell.isAlive() && livingNeighboursForCurrentCell == 2))
            newGameState.setCell(cell);
    }
}
