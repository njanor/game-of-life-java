package no.njanor.gameoflife.gamelogic;

import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class GridTest {
    @Test
    public void getAllLivingCells_WithNoLivingCells_ReturnsEmptyCollection() {
        Grid grid = new Grid(new boolean[][]{{false, false, false}, {false, false, false}, {false, false, false}});

        Collection<Cell> livingCells = grid.getAllLivingCells();

        assertEquals(0, livingCells.size());
    }
}