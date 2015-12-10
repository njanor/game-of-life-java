package no.njanor.gameoflife.gamelogic;

import java.util.ArrayList;
import java.util.Collection;

public class GameEngine {

    public static GameState evolve(GameState currentGameState) {
        GameState newGameState = new GameState();
        Collection<Cell> currentlyLivingCells = currentGameState.getAllLivingCells();

        for (Cell cell : currentlyLivingCells) {
            determineIfCellAndAllNeighboursShouldBeAliveInNextState(currentGameState, newGameState, cell);
        }
        return newGameState;
    }

    private static void determineIfCellAndAllNeighboursShouldBeAliveInNextState(GameState currentGameState, GameState newGameState, Cell cell) {
        Collection<Cell> cellAndAllNeighbours = new ArrayList<>(currentGameState.getAllNeighboursToCoordinate(cell.getCoordinate()));
        cellAndAllNeighbours.add(cell);

        cellAndAllNeighbours.stream().forEach(c -> determineIfCellShouldLiveInNextState(currentGameState, newGameState, c));
    }

    private static void determineIfCellShouldLiveInNextState(GameState currentGameState, GameState newGameState, Cell cell) {
        int livingNeighboursForCurrentCell = currentGameState.getNumberOfLivingNeighbours(cell.getCoordinate());
        if (livingNeighboursForCurrentCell == 3 || (cell.isAlive() && livingNeighboursForCurrentCell == 2))
            newGameState.setCell(cell);
    }
}
