package no.njanor.gameoflife.consolerunner;

import no.njanor.gameoflife.gamelogic.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class CoordinateInterpreter {
    public static List<Coordinate> fromString(final String input) {
        return getRemainingCoordinates(new ArrayList<>(), input);
    }

    private static List<Coordinate> getRemainingCoordinates(List<Coordinate> coordinates, final String input) {
        if (input == null || input.trim().isEmpty())
            return coordinates;
        String trimmedInput = trimInput(input);

        int indexOfCharacterAfterClosingParentheses = trimmedInput.indexOf(')') + 1;
        String nextCoordinate = trimmedInput.substring(0, indexOfCharacterAfterClosingParentheses);
        String remainingCoordinates = trimmedInput.substring(indexOfCharacterAfterClosingParentheses);
        coordinates.add(Coordinate.fromString(nextCoordinate));
        return getRemainingCoordinates(coordinates, remainingCoordinates);
    }

    private static String trimInput(String input) {
        String trimmedInput;
        if (input.charAt(0) == ',')
            trimmedInput = input.substring(1);
        else
            trimmedInput = input;
        trimmedInput = trimmedInput.trim();
        return trimmedInput;
    }
}
