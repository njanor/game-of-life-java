package no.njanor.gameoflife.gamelogic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Grid {
    private HashMap<Coordinate, Boolean> grid = new HashMap<Coordinate, Boolean>();

    public Grid(boolean[][] seed) {

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
