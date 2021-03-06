package no.njanor.gameoflife.gamelogic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class GameStateTest {

    @Test
    public void construct_withoutConstructorArgument_returnsNewGameStateWithNoLivingCells() {
        GameState gameState = new GameState();

        assertEquals(0, gameState.getAllLivingCells().size());
    }

    @Test
    public void constructGameState_withNullAsCoordinateSeed_CreatesWithoutSeed() {
        GameState gameState = new GameState((Coordinate)null);

        assertEquals(0, gameState.getAllLivingCells().size());
    }

    @Test
    public void constructGameState_withNullAsCollectionSeed_CreatesWithoutSeed() {
        GameState gameState = new GameState((List<Coordinate>)null);

        assertEquals(0, gameState.getAllLivingCells().size());
    }

    @Test
    public void constructGameState_withListOfCoordinates_createsWithCorrectSeed() {
        Coordinate firstCoordinate = new Coordinate(12, -32);
        Coordinate secondCoordinate = new Coordinate(-52, 10);
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(firstCoordinate);
        coordinates.add(secondCoordinate);

        GameState gameState = new GameState(coordinates);

        assertEquals(2, gameState.getAllLivingCells().size());
        assertTrue(gameState.getAllLivingCells().stream().map(c -> c.getCoordinate()).anyMatch(c -> c.equals(firstCoordinate)));
        assertTrue(gameState.getAllLivingCells().stream().map(c -> c.getCoordinate()).anyMatch(c -> c.equals(secondCoordinate)));
    }

    @Test
    public void getAllLivingCells_WithNoLivingCells_ReturnsEmptyCollection() {
        GameState gameState = new GameState();

        Collection<Cell> livingCells = gameState.getAllLivingCells();

        assertEquals(0, livingCells.size());
    }

    @Test
    public void getAllLivingCells_WithSingleLivingCell_ReturnsSingleCell() {
        GameState gameState = new GameState(new Coordinate(0,0));

        Collection<Cell> livingCells = gameState.getAllLivingCells();

        assertEquals(1, livingCells.size());
        assertEquals(new Coordinate(0, 0), livingCells.iterator().next().getCoordinate());
    }

    @Test
    public void getAllLivingCells_withMultipleLivingCells_returnsAllLivingCellsAtCorrectCoordinates() {

        Coordinate firstCoordinate  = new Coordinate(0, 0);
        Coordinate secondCoordinate = new Coordinate(0, 1);
        Coordinate thirdCoordinate  = new Coordinate(0, 2);
        Coordinate fourthCoordinate = new Coordinate(2, 0);
        Coordinate fifthCoordinate  = new Coordinate(2, 1);
        Coordinate sixthCoordinate  = new Coordinate(2, 2);

        GameState gameState = new GameState(
                firstCoordinate,
                secondCoordinate,
                thirdCoordinate,
                fourthCoordinate,
                fifthCoordinate,
                sixthCoordinate
        );

        Collection<Cell> livingCells = gameState.getAllLivingCells();

        assertEquals(6, livingCells.size());

        assertTrue(livingCells.contains(new Cell(firstCoordinate, true)));
        assertTrue(livingCells.contains(new Cell(secondCoordinate, true)));
        assertTrue(livingCells.contains(new Cell(thirdCoordinate, true)));
        assertTrue(livingCells.contains(new Cell(fourthCoordinate, true)));
        assertTrue(livingCells.contains(new Cell(fifthCoordinate, true)));
        assertTrue(livingCells.contains(new Cell(sixthCoordinate, true)));
    }

    @Test
    public void getNumberOfLivingNeighboursForCell_withNoLivingNeighbours_returnsZero() {
        GameState gameState = new GameState();

        gameState.getNumberOfLivingNeighbours(new Coordinate(0, 0));
    }

    @Test
    public void getNumberOfLivingNeighboursForCell_withThreeLivingNeighbours_returnsThree() {
        GameState gameState = new GameState(
                new Coordinate(0, 0),
                new Coordinate(0, 1),
                new Coordinate(0, 2)
        );

        int numberOfLivingNeighboursToCellAtOneOne = gameState.getNumberOfLivingNeighbours(new Coordinate(1, 1));

        assertEquals(3, numberOfLivingNeighboursToCellAtOneOne);
    }

    @Test
    public void getNumberOfLivingNeighboursForCell_withNoNeighboursButLiveCellsAtDistanceTwo_returnsZero() {
        GameState gameState = new GameState(
                new Coordinate(-2, -2),
                new Coordinate(-2, -1),
                new Coordinate(-2,  0),
                new Coordinate(-2,  1),
                new Coordinate(-2,  2),
                new Coordinate(-1, -2),
                new Coordinate(-1,  2),
                new Coordinate( 0, -2),
                new Coordinate( 0,  0),
                new Coordinate( 0,  2),
                new Coordinate( 1, -2),
                new Coordinate( 1,  2),
                new Coordinate( 2, -2),
                new Coordinate( 2, -1),
                new Coordinate( 2,  0),
                new Coordinate( 2,  1),
                new Coordinate( 2,  2)
        );

        int numberOfLivingNeighbours = gameState.getNumberOfLivingNeighbours(new Coordinate(0, 0));

        assertEquals(0, numberOfLivingNeighbours);
    }

    @Test
    public void getNumberOfLivingCells_oneLivingCellInAllLocations_returnOne() {
        Coordinate centerCoordinate = new Coordinate(0, 0);

        for (int x = -1; x <= 1; x++)
        {
            for (int y = -1; y <= 1; y++)
            {
                Coordinate currentCoordinate = new Coordinate(x, y);
                if (currentCoordinate.equals(centerCoordinate))
                    continue;

                GameState gameState = new GameState(currentCoordinate);

                assertEquals(1, gameState.getNumberOfLivingNeighbours(centerCoordinate));
            }
        }
    }

    @Test
    public void getCellAtCoordinate_cellIsAlive_returnsLivingCellWithCorrectCoordinates() {
        Coordinate coordinate = new Coordinate(0, 0);
        GameState gameState = new GameState(coordinate);

        Cell cell = gameState.getCellAt(coordinate);

        assertTrue(cell.isAlive());
        assertEquals(coordinate, cell.getCoordinate());
    }

    @Test
    public void getCellAtCoordinate_cellIsDead_returnsDeadCellWithCorrectCoordinates() {
        GameState gameState = new GameState();
        Coordinate coordinate = new Coordinate(10, -20);

        Cell cell = gameState.getCellAt(coordinate);

        assertFalse(cell.isAlive());
        assertEquals(coordinate, cell.getCoordinate());
    }

    @Test
    public void getAllNeighbours_forAGivenCoordinate_returnsAllItsNeighbouringCells() {
        GameState gameState = new GameState(
                new Coordinate(0, 1),
                new Coordinate(1, 0),
                new Coordinate(1, 1)
        );

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

    @Test
    public void toString_withDefinedGridOfOneByOneContainingDeadCells_drawsGrid() {
        GameState gameState = new GameState();

        String output = gameState.toString(1, 1);

        assertEquals("---\n| |\n---", output);
    }

    @Test
    public void toString_withDefinedGridOf3By3ContainingDeadCells_drawsCorrectGrid() {
        GameState gameState = new GameState();

        String output = gameState.toString(3, 3);

        final String expected = "-------\n| | | |\n| | | |\n| | | |\n-------";

        assertEquals(expected, output);
    }

    @Test
    public void toString_withDefinedGridOf1By1ContainingLivingCell_drawsCorrectGrid() {
        GameState gameState = new GameState(new Coordinate(0, 0));

        String output = gameState.toString(1, 1);

        assertEquals("---\n|x|\n---", output);
    }

    @Test
    public void toString_withDefinedGridOf3By3ContainingSomeLivingCells_drawsCorrectGrid() {
        GameState gameState = new GameState(new Coordinate(0, 0), new Coordinate(1, 1), new Coordinate(2, 2));

        String output = gameState.toString(3, 3);

        final String expected = "-------\n|x| | |\n| |x| |\n| | |x|\n-------";

        assertEquals(expected, output);
    }
}