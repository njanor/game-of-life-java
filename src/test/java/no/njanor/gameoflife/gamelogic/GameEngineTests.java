package no.njanor.gameoflife.gamelogic;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class GameEngineTests {
    @Test
    public void getNewGameState_livingCellWith0LivingNeighbours_cellDies() {
        Grid grid = new Grid(new boolean[][]{
                {   false,  false,  false},
                {   false,  true,   false},
                {   false,  false,  false}
        });

        Grid newGameState = GameEngine.evolve(grid);

        assertFalse(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }

    @Test
    public void getNewGameState_livingCellWith1LivingNeighbours_cellDies() {
        Grid grid = new Grid(new boolean[][]{
                {   true,   false,  false},
                {   false,  true,   false},
                {   false,  false,  false}
        });

        Grid newGameState = GameEngine.evolve(grid);

        assertFalse(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }

    @Test
    public void getNewGameState_livingCellWith2LivingNeighbours_cellLives() {
        Grid grid = new Grid(new boolean[][]{
                {   true,   true,   false},
                {   false,  true,   false},
                {   false,  false,  false}
        });

        Grid newGameState = GameEngine.evolve(grid);

        assertTrue(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }
}
