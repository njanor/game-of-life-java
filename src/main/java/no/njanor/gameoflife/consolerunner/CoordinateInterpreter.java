package no.njanor.gameoflife.consolerunner;

import no.njanor.gameoflife.gamelogic.Coordinate;
import no.njanor.gameoflife.utilities.CurrentRemainder;

import java.util.ArrayList;
import java.util.List;

public class CoordinateInterpreter {
    public static List<Coordinate> interpretString(final String input) {
        return getRemainingCoordinates(new ArrayList<>(), input);
    }

    private static List<Coordinate> getRemainingCoordinates(List<Coordinate> coordinates, final String input) {
        if (input == null || input.trim().isEmpty())
            return coordinates;

        final String coordinateListPattern = "^\\s*\\([-+0-9,\\s]*?\\)(\\s*,\\s*\\([-+0-9,\\s]*?\\))*\\s*$";
        if (!input.matches(coordinateListPattern))
            throw new IllegalArgumentException();

        CurrentRemainder currentRemainder = new CurrentRemainder(input);

        coordinates.add(Coordinate.fromString(currentRemainder.getCurrent()));
        return getRemainingCoordinates(coordinates, currentRemainder.getRemainder());
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
