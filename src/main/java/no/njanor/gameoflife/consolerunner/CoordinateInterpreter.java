package no.njanor.gameoflife.consolerunner;

import no.njanor.gameoflife.gamelogic.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class CoordinateInterpreter {
    public static List<Coordinate> fromString(String input) {
        if (input == null || input.isEmpty())
            return new ArrayList<>();
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(Coordinate.fromString(input));
        return coordinates;
    }
}
