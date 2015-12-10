package no.njanor.gameoflife.gamelogic;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class GameEngineTests {
    @Test
    public void getNewGameState_livingCellWith0LivingNeighbours_cellDies() {
        Coordinate myCoordinate = new Coordinate(0, 0);
        GameState gameState = new GameState(
                myCoordinate
        );

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(myCoordinate).isAlive());
    }

    @Test
    public void getNewGameState_livingCellWith1LivingNeighbours_cellDies() {
        Coordinate myCoordinate = new Coordinate(0, 0);
        GameState gameState = new GameState(
                myCoordinate,
                new Coordinate(-1, -1)
        );

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(myCoordinate).isAlive());
    }

    @Test
    public void getNewGameState_livingCellWith2LivingNeighbours_cellLives() {
        Coordinate myCoordinate = new Coordinate(0, 0);
        GameState gameState = new GameState(
                myCoordinate,
                new Coordinate(-1, -1),
                new Coordinate(-1,  0)
        );

        GameState newGameState = GameEngine.evolve(gameState);

        assertTrue(newGameState.getCellAt(myCoordinate).isAlive());
    }

    @Test
    public void getNewGameState_livingCellWith3LivingNeighbours_cellLives() {
        Coordinate myCoordinate = new Coordinate(0, 0);
        GameState gameState = new GameState(
                myCoordinate,
                new Coordinate(-1, -1),
                new Coordinate(-1,  0),
                new Coordinate(-1,  1)
        );

        GameState newGameState = GameEngine.evolve(gameState);

        assertTrue(newGameState.getCellAt(myCoordinate).isAlive());
    }

    @Test
    public void getNewGameState_livingCellWith4LivingNeighbours_cellDies() {
        Coordinate myCoordinate = new Coordinate(0, 0);
        GameState gameState = new GameState(
                myCoordinate,
                new Coordinate(-1, -1),
                new Coordinate(-1,  0),
                new Coordinate(-1,  1),
                new Coordinate( 0, -1)
        );

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(myCoordinate).isAlive());
    }

    @Test
    public void getNewGameState_livingCellWith5LivingNeighbours_cellDies() {
        Coordinate myCoordinate = new Coordinate(0, 0);
        GameState gameState = new GameState(
                myCoordinate,
                new Coordinate(-1, -1),
                new Coordinate(-1,  0),
                new Coordinate(-1,  1),
                new Coordinate( 0, -1),
                new Coordinate( 0,  1)
        );

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(myCoordinate).isAlive());
    }

    @Test
    public void getNewGameState_livingCellWith6LivingNeighbours_cellDies() {
        Coordinate myCoordinate = new Coordinate(0, 0);
        GameState gameState = new GameState(
                myCoordinate,
                new Coordinate(-1, -1),
                new Coordinate(-1,  0),
                new Coordinate(-1,  1),
                new Coordinate( 0, -1),
                new Coordinate( 0,  1),
                new Coordinate( 1, -1)
        );

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(myCoordinate).isAlive());
    }

    @Test
    public void getNewGameState_livingCellWith7LivingNeighbours_cellDies() {
        Coordinate myCoordinate = new Coordinate(0, 0);
        GameState gameState = new GameState(
                myCoordinate,
                new Coordinate(-1, -1),
                new Coordinate(-1,  0),
                new Coordinate(-1,  1),
                new Coordinate( 0, -1),
                new Coordinate( 0,  1),
                new Coordinate( 1, -1),
                new Coordinate( 1,  0)
        );

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(myCoordinate).isAlive());
    }

    @Test
    public void getNewGameState_livingCellWith8LivingNeighbours_cellDies() {
        Coordinate myCoordinate = new Coordinate(0, 0);
        GameState gameState = new GameState(
                myCoordinate,
                new Coordinate(-1, -1),
                new Coordinate(-1,  0),
                new Coordinate(-1,  1),
                new Coordinate( 0, -1),
                new Coordinate( 0,  1),
                new Coordinate( 1, -1),
                new Coordinate( 1,  0),
                new Coordinate( 1,  1)
        );

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(myCoordinate).isAlive());
    }

    @Test
    public void getNewGameState_deadCellWith0LivingNeighbours_cellRemainsDead() {
        GameState gameState = new GameState();

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(0, 0)).isAlive());
    }

    @Test
    public void getNewGameState_deadCellWith1LivingNeighbours_cellRemainsDead() {
        GameState gameState = new GameState(
                new Coordinate(-1, -1)
        );

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(0, 0)).isAlive());
    }

    @Test
    public void getNewGameState_deadCellWith2LivingNeighbours_cellRemainsDead() {
        GameState gameState = new GameState(
                new Coordinate(-1, -1),
                new Coordinate(-1,  0)
        );

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(0, 0)).isAlive());
    }

    @Test
    public void getNewGameState_deadCellWith3LivingNeighbours_cellComesToLife() {
        GameState gameState = new GameState(
                new Coordinate(-1, -1),
                new Coordinate(-1,  0),
                new Coordinate(-1,  1)
        );

        GameState newGameState = GameEngine.evolve(gameState);

        assertTrue(newGameState.getCellAt(new Coordinate(0, 0)).isAlive());
    }

    @Test
    public void getNewGameState_deadCellWith4LivingNeighbours_cellRemainsDead() {
        GameState gameState = new GameState(
                new Coordinate(-1, -1),
                new Coordinate(-1,  0),
                new Coordinate(-1,  1),
                new Coordinate( 0, -1)
        );

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(0, 0)).isAlive());
    }

    @Test
    public void getNewGameState_deadCellWith5LivingNeighbours_cellRemainsDead() {
        GameState gameState = new GameState(
                new Coordinate(-1, -1),
                new Coordinate(-1,  0),
                new Coordinate(-1,  1),
                new Coordinate( 0, -1),
                new Coordinate( 0,  1)
        );

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(0, 0)).isAlive());
    }

    @Test
    public void getNewGameState_deadCellWith6LivingNeighbours_cellRemainsDead() {
        GameState gameState = new GameState(
                new Coordinate(-1, -1),
                new Coordinate(-1,  0),
                new Coordinate(-1,  1),
                new Coordinate( 0, -1),
                new Coordinate( 0,  1),
                new Coordinate( 1, -1)
        );

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(0, 0)).isAlive());
    }

    @Test
    public void getNewGameState_deadCellWith7LivingNeighbours_cellRemainsDead() {
        GameState gameState = new GameState(
                new Coordinate(-1, -1),
                new Coordinate(-1,  0),
                new Coordinate(-1,  1),
                new Coordinate( 0, -1),
                new Coordinate( 0,  1),
                new Coordinate( 1, -1),
                new Coordinate( 1,  0)
        );

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(0, 0)).isAlive());
    }

    @Test
    public void getNewGameState_deadCellWith8LivingNeighbours_cellRemainsDead() {
        GameState gameState = new GameState(
                new Coordinate(-1, -1),
                new Coordinate(-1,  0),
                new Coordinate(-1,  1),
                new Coordinate( 0, -1),
                new Coordinate( 0,  1),
                new Coordinate( 1, -1),
                new Coordinate( 1,  0),
                new Coordinate( 1,  1)
        );

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(0, 0)).isAlive());
    }
}
