package no.njanor.gameoflife.gamelogic;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class CoordinateTests {

    @Test
    public void equals_withSameXAndY_AreEqual() {
        final int x = 1;
        final int y = 4;
        Coordinate coordinate1 = new Coordinate(x, y);
        Coordinate coordinate2 = new Coordinate(x, y);

        assertEquals(coordinate1, coordinate2);
    }

    @Test
    public void toString_withAValidCoordinate_returnsReasonablyFormattedString() {
        Coordinate coordinate = new Coordinate(23, 312);

        assertEquals("(23, 312)", coordinate.toString());
    }

    @Test
    public void fromString_withValidFormat_returnsCorrectCoordinate() {
        final String input = "(1, 2)";

        Coordinate coordinate = Coordinate.fromString(input);

        assertEquals(input, coordinate.toString());
    }

    @Test
    public void fromString_withLettersForXCoordinate_throwsException() {
        final String input = "(x, 2)";

        try {
            Coordinate.fromString(input);
            fail();
        }
        catch (IllegalArgumentException iae) {

        }
    }

    @Test
    public void fromString_withLettersForYCoordinate_throwsException() {
        final String input = "(1, y)";

        try {
            Coordinate.fromString(input);
            fail();
        }
        catch (IllegalArgumentException iae) {

        }
    }

    @Test
    public void fromString_withoutOpeningParenthesis_throwsException() {
        final String input = "2, 4)";

        try {
            Coordinate.fromString(input);
            fail();
        }
        catch (IllegalArgumentException iae) {

        }
    }

    @Test
    public void fromString_withoutClosingParenthesis_throwException() {
        final String input = "(2, 4";

        try {
            Coordinate.fromString(input);
            fail();
        }
        catch (IllegalArgumentException iae) {

        }
    }

    @Test
    public void fromString_withLeadingWhitespace_returnsCorrectCoordinate() {
        final String input = "(123, 321)";

        Coordinate coordinate = Coordinate.fromString("       " + input);

        assertEquals(input, coordinate.toString());
    }

    @Test
    public void fromString_withTrailingWhitespace_returnsCorrectCoordinate() {
        final String input = "(10, 123)";

        Coordinate coordinate = Coordinate.fromString(input + "                  ");

        assertEquals(input, coordinate.toString());
    }

    @Test
    public void fromString_withNegativeXAndYCoordinates_returnsCorrectCoordinate() {
        final String input = "(-1, -214)";

        Coordinate coordinate = Coordinate.fromString(input);

        assertEquals(input, coordinate.toString());
    }

    @Test
    public void fromString_withPlusSignsBeforeCoordinates_returnsCorrectCoordinate() {
        final String input = "(+41, +12)";

        Coordinate coordinate = Coordinate.fromString(input);

        assertEquals("(41, 12)", coordinate.toString());
    }

    @Test
    public void fromString_withXCoordinateZero_returnsCorrectCoordinate() {
        final String input = "(0, 41)";

        Coordinate coordinate = Coordinate.fromString(input);

        assertEquals(input, coordinate.toString());
    }

    @Test
    public void fromString_withYCoordinateZero_returnsCorrectCoordinate() {
        final String input = "(1231, 0)";

        Coordinate coordinate = Coordinate.fromString(input);

        assertEquals(input, coordinate.toString());
    }
}
