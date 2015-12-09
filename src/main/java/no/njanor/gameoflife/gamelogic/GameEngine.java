package no.njanor.gameoflife.gamelogic;

import java.util.Collection;

public class GameEngine {

    public static Grid evolve(Grid currentGameState) {
        Grid newGameState = new Grid();
        Collection<Cell> currentlyLivingCells = currentGameState.getAllLivingCells();

        for (Cell cell : currentlyLivingCells) {
            if (currentGameState.getNumberOfLivingNeighbours(cell.getCoordinate()) == 2)
                newGameState.setCell(cell);
        }
        return newGameState;
    }
}
