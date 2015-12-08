package no.njanor.gameoflife.gamelogic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Grid {
    private HashMap<Coordinate, Boolean> grid = new HashMap<Coordinate, Boolean>();

    public Grid(boolean[][] seed) {
        for (int i = 0; i < seed.length; i++)
            for (int j = 0; j < seed[i].length; j++)
                if (seed[i][j])
                    grid.put(new Coordinate(i, j), true);
    }

    public Collection<Cell> getAllLivingCells() {
        Collection<Cell> livingCells = new ArrayList<Cell>();

        for (Coordinate coordinate :
                grid.keySet()) {
            livingCells.add(new Cell(coordinate, grid.get(coordinate)));
        }

        return livingCells;
    }
}
