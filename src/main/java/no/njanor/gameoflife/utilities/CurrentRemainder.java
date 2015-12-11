package no.njanor.gameoflife.utilities;

public class CurrentRemainder {
    private String current;
    private String remainder;

    public CurrentRemainder(final String input) {
        int lastIndexOfFirstCoordinate = input.indexOf(')');
        current = input.substring(0, lastIndexOfFirstCoordinate + 1).trim();

        if (hasRemainder(input, lastIndexOfFirstCoordinate)) {
            int indexOfOpeningParenthesisOfSecondCoordinate = input.indexOf('(', lastIndexOfFirstCoordinate);
            remainder = input.substring(indexOfOpeningParenthesisOfSecondCoordinate).trim();
        }
        else {
            remainder = "";
        }
    }

    private boolean hasRemainder(final String input, final int lastIndexOfFirstCoordinate) {
        return input.indexOf('(', lastIndexOfFirstCoordinate) > 0;
    }

    public String getCurrent() {
        return current;
    }

    public String getRemainder() {
        return remainder;
    }
}
