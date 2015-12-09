package no.njanor.gameoflife.gamelogic;

import java.util.Collection;

public class GameEngine {

    public static Grid evolve(Grid currentGameState) {
        Grid newGameState = new Grid();
        Collection<Cell> currentlyLivingCells = currentGameState.getAllLivingCells();

        for (Cell cell : currentlyLivingCells) {
            int livingNeighboursForCurrentCell = currentGameState.getNumberOfLivingNeighbours(cell.getCoordinate());
            if (livingNeighboursForCurrentCell == 2 || livingNeighboursForCurrentCell == 3)
                newGameState.setCell(cell);
        }
        return newGameState;
    }
}
