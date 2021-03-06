package no.njanor.gameoflife.gamelogic;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }

    @Override
    public int hashCode() {
        return x + y;
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof Coordinate
                && ((Coordinate) obj).x == x
                && ((Coordinate) obj).y == y;
    }

    public static Coordinate fromString(final String input) {
        final String coordinateRegExp = "\\s*\\(\\s*-?\\+?\\d+\\s*,\\s*-?\\+?\\d+\\s*\\)\\s*";
        if (!input.matches(coordinateRegExp))
            throw new IllegalArgumentException();

        String xCoordinateAsString = getTrimmedStringBetweenFirst('(', ',', input);
        String yCoordinateAsString = getTrimmedStringBetweenFirst(',', ')', input);
        int xCoordinate = Integer.parseInt(xCoordinateAsString);
        int yCoordinate = Integer.parseInt(yCoordinateAsString);
        return new Coordinate(xCoordinate, yCoordinate);
    }

    private static String getTrimmedStringBetweenFirst(final char opening, final char closing, final String input) {
        int indexOfFirstOpeningParentheses = input.indexOf(opening);
        int indexOfFirstComma = input.indexOf(closing);
        return input.substring(indexOfFirstOpeningParentheses + 1, indexOfFirstComma).trim();
    }
}
