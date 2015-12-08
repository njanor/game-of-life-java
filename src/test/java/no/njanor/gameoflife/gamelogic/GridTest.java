package no.njanor.gameoflife.gamelogic;

import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class GridTest {
    @Test
    public void getAllLivingCells_WithNoLivingCells_ReturnsEmptyCollection() {
        Grid grid = new Grid(new boolean[][]{{false, false, false}, {false, false, false}, {false, false, false}});

        Collection<Cell> livingCells = grid.getAllLivingCells();

        assertEquals(0, livingCells.size());
    }

    @Test
    public void getAllLivingCells_WithSingleLivingCell_ReturnsSingleCell() {
        Grid grid = new Grid(new boolean[][]{{true}});

        Collection<Cell> livingCells = grid.getAllLivingCells();

        assertEquals(1, livingCells.size());
        assertEquals(new Coordinate(0, 0), livingCells.iterator().next().getCoordinate());
    }

    @Test
    public void getAllLivingCells_withMultipleLivingCells_returnsAllLivingCellsAtCorrectCoordinates() {
        Grid grid = new Grid(new boolean[][]{
                {true,  true,   true},  // 0,0 - 0,1 - 0,2
                {false, false,  false}, // 1,0 - 1,1 - 1,2
                {true,  true,   true}});// 2,0 - 2,1 - 2,2

        Collection<Cell> livingCells = grid.getAllLivingCells();

        assertEquals(6, livingCells.size());

        assertTrue(livingCells.contains(new Cell(new Coordinate(0, 0), true)));
        assertTrue(livingCells.contains(new Cell(new Coordinate(0, 1), true)));
        assertTrue(livingCells.contains(new Cell(new Coordinate(0, 2), true)));
        assertTrue(livingCells.contains(new Cell(new Coordinate(2, 0), true)));
        assertTrue(livingCells.contains(new Cell(new Coordinate(2, 1), true)));
        assertTrue(livingCells.contains(new Cell(new Coordinate(2, 2), true)));
    }

    @Test
    public void constructGrid_withNullAsSeed_CreatesWithoutSeed() {
        Grid grid = new Grid(null);

        assertEquals(0, grid.getAllLivingCells().size());
    }

    @Test
    public void getNumberOfLivingNeighboursForCell_withNoLivingNeighbours_returnsZero() {
        Grid grid = new Grid(null);

        grid.getNumberOfLivingNeighbours(new Coordinate(0, 0));
    }

    @Test
    public void getNumberOfLivingNeighboursForCell_withThreeLivingneighbours_returnsThree() {
        Grid grid = new Grid(new boolean[][]{{true, true, true}}); // 0,0-2

        int numberOfLivingNeighboursToCellAtOneOne = grid.getNumberOfLivingNeighbours(new Coordinate(1, 1));

        assertEquals(3, numberOfLivingNeighboursToCellAtOneOne);
    }
}