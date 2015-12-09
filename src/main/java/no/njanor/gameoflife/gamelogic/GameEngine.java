package no.njanor.gameoflife.gamelogic;

import java.util.ArrayList;
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
        Collection<Cell> cellAndAllNeighbours = new ArrayList<>(currentGameState.getAllNeighboursToCoordinate(cell.getCoordinate()));
        cellAndAllNeighbours.add(cell);

        cellAndAllNeighbours.stream().forEach(c -> determineIfCellShouldLiveInNextState(currentGameState, newGameState, c));
    }

    private static void determineIfCellShouldLiveInNextState(Grid currentGameState, Grid newGameState, Cell cell) {
        int livingNeighboursForCurrentCell = currentGameState.getNumberOfLivingNeighbours(cell.getCoordinate());
        if (livingNeighboursForCurrentCell == 3 || (cell.isAlive() && livingNeighboursForCurrentCell == 2))
            newGameState.setCell(cell);
    }
}
