package no.njanor.gameoflife.gamelogic;

import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class GameStateTest {

    @Test
    public void construct_withoutConstructorArgument_returnsNewGameStateWithNoLivingCells() {
        GameState gameState = new GameState();

        assertEquals(0, gameState.getAllLivingCells().size());
    }

    @Test
    public void constructGameState_withNullAsSeed_CreatesWithoutSeed() {
        GameState gameState = new GameState(null);

        assertEquals(0, gameState.getAllLivingCells().size());
    }

    @Test
    public void getAllLivingCells_WithNoLivingCells_ReturnsEmptyCollection() {
        GameState gameState = new GameState(new boolean[][]{{false, false, false}, {false, false, false}, {false, false, false}});

        Collection<Cell> livingCells = gameState.getAllLivingCells();

        assertEquals(0, livingCells.size());
    }

    @Test
    public void getAllLivingCells_WithSingleLivingCell_ReturnsSingleCell() {
        GameState gameState = new GameState(new boolean[][]{{true}});

        Collection<Cell> livingCells = gameState.getAllLivingCells();

        assertEquals(1, livingCells.size());
        assertEquals(new Coordinate(0, 0), livingCells.iterator().next().getCoordinate());
    }

    @Test
    public void getAllLivingCells_withMultipleLivingCells_returnsAllLivingCellsAtCorrectCoordinates() {
        GameState gameState = new GameState(new boolean[][]{
                {true,  true,   true},  // 0,0 - 0,1 - 0,2
                {false, false,  false}, // 1,0 - 1,1 - 1,2
                {true,  true,   true}});// 2,0 - 2,1 - 2,2

        Collection<Cell> livingCells = gameState.getAllLivingCells();

        assertEquals(6, livingCells.size());

        assertTrue(livingCells.contains(new Cell(new Coordinate(0, 0), true)));
        assertTrue(livingCells.contains(new Cell(new Coordinate(0, 1), true)));
        assertTrue(livingCells.contains(new Cell(new Coordinate(0, 2), true)));
        assertTrue(livingCells.contains(new Cell(new Coordinate(2, 0), true)));
        assertTrue(livingCells.contains(new Cell(new Coordinate(2, 1), true)));
        assertTrue(livingCells.contains(new Cell(new Coordinate(2, 2), true)));
    }

    @Test
    public void getNumberOfLivingNeighboursForCell_withNoLivingNeighbours_returnsZero() {
        GameState gameState = new GameState(null);

        gameState.getNumberOfLivingNeighbours(new Coordinate(0, 0));
    }

    @Test
    public void getNumberOfLivingNeighboursForCell_withThreeLivingneighbours_returnsThree() {
        GameState gameState = new GameState(new boolean[][]{{true, true, true}}); // 0,0-2

        int numberOfLivingNeighboursToCellAtOneOne = gameState.getNumberOfLivingNeighbours(new Coordinate(1, 1));

        assertEquals(3, numberOfLivingNeighboursToCellAtOneOne);
    }

    @Test
    public void getNumberOfLivingNeighboursForCell_withNoNeighboursButLiveCellsAtDistanceTwo_returnsZero() {
        GameState gameState = new GameState(new boolean[][]{
                {true,  true,   true,   true,   true},
                {true,  false,  false,  false,  true},
                {true,  false,  true,   false,  true},
                {true,  false,  false,  false,  true},
                {true,  true,   true,   true,   true},
        });

        int numberOfLivingneigboursToCellAtTwoTwo = gameState.getNumberOfLivingNeighbours(new Coordinate(2, 2));

        assertEquals(0, numberOfLivingneigboursToCellAtTwoTwo);
    }

    @Test
    public void getNumberOfLivingCells_oneLivingCellInAllLocations_returnOne() {
        Coordinate centerCoordinate = new Coordinate(1, 1);

        for (int x = 0; x <= 2; x++)
        {
            for (int y = 0; y <= 2; y++)
            {
                Coordinate currentCoordinate = new Coordinate(x, y);
                if (currentCoordinate.equals(centerCoordinate))
                    continue;

                boolean[][] seed = new boolean[3][3];
                seed[x][y] = true;

                GameState gameState = new GameState(seed);

                assertEquals(1, gameState.getNumberOfLivingNeighbours(centerCoordinate));
            }
        }
    }

    @Test
    public void getCellAtCoordinate_cellIsAlive_returnsLivingCellWithCorrectCoordinates() {
        GameState gameState = new GameState(new boolean[][]{{true}});
        Coordinate coordinate = new Coordinate(0, 0);

        Cell cell = gameState.getCellAt(coordinate);

        assertTrue(cell.isAlive());
        assertEquals(coordinate, cell.getCoordinate());
    }

    @Test
    public void getCellAtCoordinate_cellIsDead_returnsDeadCellWithCorrectCoordinates() {
        GameState gameState = new GameState(new boolean[][]{{false}});
        Coordinate coordinate = new Coordinate(10, -20);

        Cell cell = gameState.getCellAt(coordinate);

        assertFalse(cell.isAlive());
        assertEquals(coordinate, cell.getCoordinate());
    }

    @Test
    public void getAllNeighbours_forAGivenCoordinate_returnsAllItsNeighbouringCells() {
        GameState gameState = new GameState(new boolean[][]{
                {false, true},
                {true, true}
        });

        Collection<Cell> neighbours = gameState.getAllNeighboursToCoordinate(new Coordinate(0, 0));

        assertTrue(neighbours.contains(new Cell(new Coordinate(-1, -1), false)));
        assertTrue(neighbours.contains(new Cell(new Coordinate(-1,  0), false)));
        assertTrue(neighbours.contains(new Cell(new Coordinate(-1,  1), false)));
        assertTrue(neighbours.contains(new Cell(new Coordinate( 0, -1), false)));
        assertTrue(neighbours.contains(new Cell(new Coordinate( 0,  1), true)));
        assertTrue(neighbours.contains(new Cell(new Coordinate( 1, -1), false)));
        assertTrue(neighbours.contains(new Cell(new Coordinate( 1,  0), true)));
        assertTrue(neighbours.contains(new Cell(new Coordinate( 1,  1), true)));
    }
}