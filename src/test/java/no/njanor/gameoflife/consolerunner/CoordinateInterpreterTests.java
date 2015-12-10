package no.njanor.gameoflife.consolerunner;

import no.njanor.gameoflife.gamelogic.Coordinate;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CoordinateInterpreterTests {
    @Test
    public void interpretCoordinates_emptyString_returnsEmptyList() {
        List<Coordinate> coordinates = CoordinateInterpreter.fromString("");

        assertEquals(0, coordinates.size());
    }

    @Test
    public void fromString_stringIsNull_returnsEmptyList() {
        List<Coordinate> coordinates = CoordinateInterpreter.fromString(null);

        assertEquals(0, coordinates.size());
    }

    @Test
    public void fromString_stringHasOnePositiveCoordinateInIt_returnsListWithCorrectCoordinate() {
        List<Coordinate> coordinates = CoordinateInterpreter.fromString("(1, 3)");

        assertEquals(1, coordinates.size());
        assertTrue(coordinates.contains(new Coordinate(1, 3)));
    }

    @Test
    public void fromString_stringHasOneNegativeCoordinateInIt_returnsListWithCorrectCoordinate() {
        List<Coordinate> coordinates = CoordinateInterpreter.fromString("(-1, -20)");

        assertEquals(1, coordinates.size());
        assertTrue(coordinates.contains(new Coordinate(-1, -20)));
    }
}
