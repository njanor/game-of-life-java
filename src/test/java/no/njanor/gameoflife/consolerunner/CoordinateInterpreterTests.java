package no.njanor.gameoflife.consolerunner;

import no.njanor.gameoflife.gamelogic.Coordinate;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

public class CoordinateInterpreterTests {
    @Test
    public void interpretString_emptyString_returnsEmptyList() {
        List<Coordinate> coordinates = CoordinateInterpreter.interpretString("");

        assertEquals(0, coordinates.size());
    }

    @Test
    public void interpretString_stringIsNull_returnsEmptyList() {
        List<Coordinate> coordinates = CoordinateInterpreter.interpretString(null);

        assertEquals(0, coordinates.size());
    }

    @Test
    public void interpretString_stringHasOnePositiveCoordinateInIt_returnsListWithCorrectCoordinate() {
        Coordinate coordinate = new Coordinate(1, 3);

        List<Coordinate> coordinates = CoordinateInterpreter.interpretString(coordinate.toString());

        assertEquals(1, coordinates.size());
        assertTrue(coordinates.contains(coordinate));
    }

    @Test
    public void interpretString_stringHasOneNegativeCoordinateInIt_returnsListWithCorrectCoordinate() {
        Coordinate coordinate = new Coordinate(-1, -20);

        List<Coordinate> coordinates = CoordinateInterpreter.interpretString(coordinate.toString());

        assertEquals(1, coordinates.size());
        assertTrue(coordinates.contains(coordinate));
    }

    @Test
    public void interpretString_stringHasTwoCoordinatesInIt_returnsListWithCorrectCoordinates() {
        Coordinate firstCoordinate = new Coordinate(12, 34);
        Coordinate secondCoordinate = new Coordinate(-4, -1204);

        List<Coordinate> coordinates = CoordinateInterpreter.interpretString(firstCoordinate + ", " + secondCoordinate);

        assertEquals(2, coordinates.size());
        assertTrue(coordinates.contains(firstCoordinate));
        assertTrue(coordinates.contains(secondCoordinate));
    }

    @Test
    public void interpretString_stringHasSeveralOfTheSameCoordinate_returnsListWithEachOfThese() {
        final Coordinate coordinate = new Coordinate(2, 5);

        List<Coordinate> coordinates = CoordinateInterpreter.interpretString(coordinate.toString() + ", " + coordinate.toString());

        assertEquals(2, coordinates.size());
        assertEquals(coordinate, coordinates.get(0));
        assertEquals(coordinate, coordinates.get(1));
    }

    @Test
    public void interpretString_stringDoesNotContainACoordinate_throwException() {
        final String input = "1231223123123123!";

        try {
            CoordinateInterpreter.interpretString(input);
            fail();
        }
        catch (IllegalArgumentException iae) { }
    }

    @Test
    public void interpretString_onlyCommaAndNoWhitespaceBetweenCoordinates_returnsCorrectListOfCoordinates() {
        final Coordinate firstCoordinate = new Coordinate(1, 2);
        final Coordinate secondCoordinate = new Coordinate(3, 4);
        final Coordinate thirdCoordinate = new Coordinate(5, 6);

        List<Coordinate> coordinates = CoordinateInterpreter.interpretString(firstCoordinate + "," + secondCoordinate + "," + thirdCoordinate);

        assertEquals(3, coordinates.size());
        assertTrue(coordinates.contains(firstCoordinate));
        assertTrue(coordinates.contains(secondCoordinate));
        assertTrue(coordinates.contains(thirdCoordinate));
    }

    @Test
    public void interpretString_muchWhitespaceBetweenCoordinatesInInput_returnsCorrectListOfCoordinates() {
        final Coordinate firstCoordinate = new Coordinate(1, 2);
        final Coordinate secondCoordinate = new Coordinate(3, 4);

        List<Coordinate> coordinates = CoordinateInterpreter.interpretString(firstCoordinate + "    ,           " + secondCoordinate);

        assertEquals(2, coordinates.size());
        assertTrue(coordinates.contains(firstCoordinate));
        assertTrue(coordinates.contains(secondCoordinate));
    }

    @Test
    public void interpretString_missingCommaBetweenCoordinates_throwsException() {
        final String input = "(12, 34) (41, 24)";

        try {
            CoordinateInterpreter.interpretString(input);
            fail();
        }
        catch (IllegalArgumentException iae) { }
    }
}
