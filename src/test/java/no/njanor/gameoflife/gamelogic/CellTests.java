package no.njanor.gameoflife.gamelogic;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class CellTests {
    @Test
    public void equals_twoCellsWithSamePositionAndBothAreAlive_areEqual() {
        Coordinate coordinate = new Coordinate(4, 9);
        Cell cell1 = new Cell(coordinate, true);
        Cell cell2 = new Cell(coordinate, true);

        assertEquals(cell1, cell2);
    }

    @Test
    public void equals_twoCellsWithSameCoordinatesAndBothAreDead_areEqual() {
        Coordinate coordinate = new Coordinate(9, 2);
        Cell cell1 = new Cell(coordinate, false);
        Cell cell2 = new Cell(coordinate, false);

        assertEquals(cell1, cell2);
    }

    @Test
    public void equals_twoCellsWithDifferentCoordinatesAndBothAreAlive_areNotEqual() {
        Cell cell1 = new Cell(new Coordinate(1, 2), true);
        Cell cell2 = new Cell(new Coordinate(2, 1), true);

        assertFalse(cell1.equals(cell2));
    }

    @Test
    public void equals_twoCellsWithDifferentCoordinatesAndBothAreDead_areNotEqual() {
        Cell cell1 = new Cell(new Coordinate(9, 1), false);
        Cell cell2 = new Cell(new Coordinate(1, 9), false);

        assertFalse(cell1.equals(cell2));
    }

    @Test
    public void equals_TwoCellsWithSameCoordinatesAndDifferentAliveState_areNotEqual() {
        Coordinate coordinate = new Coordinate(1, 2);
        Cell cell1 = new Cell(coordinate, true);
        Cell cell2 = new Cell(coordinate, false);

        assertFalse(cell1.equals(cell2));
    }

    @Test
    public void equals_TwoCellsWithDifferentCoordinatesAndDifferentIsAliveStates_areNotEqual() {
        Cell cell1 = new Cell(new Coordinate(12, -12), true);
        Cell cell2 = new Cell(new Coordinate(-12, 12), false);

        assertFalse(cell1.equals(cell2));
    }

    @Test
    public void equals_instanceIsNull_areNotTrue() {
        Cell cell1 = new Cell(new Coordinate(1, 2), false);

        assertFalse(cell1.equals(null));
    }
}
