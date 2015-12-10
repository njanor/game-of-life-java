package no.njanor.gameoflife.consolerunner;

import no.njanor.gameoflife.gamelogic.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class CoordinateInterpreter {
    public static List<Coordinate> fromString(String input) {
        if (input == null || input.isEmpty())
            return new ArrayList<>();
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(interpretCoordinate(input));
        return coordinates;
    }

    private static Coordinate interpretCoordinate(final String input) {
        String xCoordinateAsString = getTrimmedStringBetweenFirst('(', ',', input);
        String yCoordinateAsString = getTrimmedStringBetweenFirst(',', ')', input);
        int xCoordinate = Integer.parseInt(xCoordinateAsString);
        int yCoordinate = Integer.parseInt(yCoordinateAsString);
        return new Coordinate(xCoordinate, yCoordinate);
    }

    private static String getTrimmedStringBetweenFirst(char opening, char closing, String input) {
        int indexOfFirstOpeningParentheses = input.indexOf('(');
        int indexOfFirstComma = input.indexOf(',');
        return input.substring(indexOfFirstOpeningParentheses + 1, indexOfFirstComma).trim();
    }
}
