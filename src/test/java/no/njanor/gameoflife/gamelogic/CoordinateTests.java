package no.njanor.gameoflife.gamelogic;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CoordinateTests {

    @Test
    public void equals_withSameXAndY_AreEqual() {
        final int x = 1;
        final int y = 4;
        Coordinate coordinate1 = new Coordinate(x, y);
        Coordinate coordinate2 = new Coordinate(x, y);

        assertEquals(coordinate1, coordinate2);
    }
}
