package no.njanor.gameoflife.gamelogic;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class GameEngineTests {
    @Test
    public void getNewGameState_livingCellWith0LivingNeighbours_cellDies() {
        GameState gameState = new GameState(new boolean[][]{
                {   false,  false,  false   },
                {   false,  true,   false   },
                {   false,  false,  false   }
        });

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }

    @Test
    public void getNewGameState_livingCellWith1LivingNeighbours_cellDies() {
        GameState gameState = new GameState(new boolean[][]{
                {   true,   false,  false   },
                {   false,  true,   false   },
                {   false,  false,  false   }
        });

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }

    @Test
    public void getNewGameState_livingCellWith2LivingNeighbours_cellLives() {
        GameState gameState = new GameState(new boolean[][]{
                {   true,   true,   false   },
                {   false,  true,   false   },
                {   false,  false,  false   }
        });

        GameState newGameState = GameEngine.evolve(gameState);

        assertTrue(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }

    @Test
    public void getNewGameState_livingCellWith3LivingNeighbours_cellLives() {
        GameState gameState = new GameState(new boolean[][]{
                {   true,   true,   true    },
                {   false,  true,   false   },
                {   false,  false,  false   }
        });

        GameState newGameState = GameEngine.evolve(gameState);

        assertTrue(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }

    @Test
    public void getNewGameState_livingCellWith4LivingNeighbours_cellDies() {
        GameState gameState = new GameState(new boolean[][]{
                {   true,   true,   true    },
                {   true,   true,   false   },
                {   false,  false,  false   }
        });

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }

    @Test
    public void getNewGameState_livingCellWith5LivingNeighbours_cellDies() {
        GameState gameState = new GameState(new boolean[][]{
                {   true,   true,   true    },
                {   true,   true,   true    },
                {   false,  false,  false   }
        });

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }

    @Test
    public void getNewGameState_livingCellWith6LivingNeighbours_cellDies() {
        GameState gameState = new GameState(new boolean[][]{
                {   true,   true,   true    },
                {   true,   true,   true    },
                {   true,   false,  false   }
        });

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }

    @Test
    public void getNewGameState_livingCellWith7LivingNeighbours_cellDies() {
        GameState gameState = new GameState(new boolean[][]{
                {   true,   true,   true    },
                {   true,   true,   true    },
                {   true,   true,   false   }
        });

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }

    @Test
    public void getNewGameState_livingCellWith8LivingNeighbours_cellDies() {
        GameState gameState = new GameState(new boolean[][]{
                {   true,   true,   true    },
                {   true,   true,   true    },
                {   true,   true,   true    }
        });

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }

    @Test
    public void getNewGameState_deadCellWith0LivingNeighbours_cellRemainsDead() {
        GameState gameState = new GameState(new boolean[][]{
                {   false,  false,  false   },
                {   false,  false,  false   },
                {   false,  false,  false   }
        });

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }

    @Test
    public void getNewGameState_deadCellWith1LivingNeighbours_cellRemainsDead() {
        GameState gameState = new GameState(new boolean[][]{
                {   true,   false,  false   },
                {   false,  false,  false   },
                {   false,  false,  false   }
        });

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }

    @Test
    public void getNewGameState_deadCellWith2LivingNeighbours_cellRemainsDead() {
        GameState gameState = new GameState(new boolean[][]{
                {   true,   true,   false   },
                {   false,  false,  false   },
                {   false,  false,  false   }
        });

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }

    @Test
    public void getNewGameState_deadCellWith3LivingNeighbours_cellComesToLife() {
        GameState gameState = new GameState(new boolean[][]{
                {   true,   true,   true    },
                {   false,  false,  false   },
                {   false,  false,  false   }
        });

        GameState newGameState = GameEngine.evolve(gameState);

        assertTrue(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }

    @Test
    public void getNewGameState_deadCellWith4LivingNeighbours_cellRemainsDead() {
        GameState gameState = new GameState(new boolean[][]{
                {   true,   true,   true    },
                {   true,   false,  false   },
                {   false,  false,  false   }
        });

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }

    @Test
    public void getNewGameState_deadCellWith5LivingNeighbours_cellRemainsDead() {
        GameState gameState = new GameState(new boolean[][]{
                {   true,   true,   true    },
                {   true,   false,   true    },
                {   false,  false,  false   }
        });

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }

    @Test
    public void getNewGameState_deadCellWith6LivingNeighbours_cellRemainsDead() {
        GameState gameState = new GameState(new boolean[][]{
                {   true,   true,   true    },
                {   true,   false,  true    },
                {   true,   false,  false   }
        });

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }

    @Test
    public void getNewGameState_deadCellWith7LivingNeighbours_cellRemainsDead() {
        GameState gameState = new GameState(new boolean[][]{
                {   true,   true,   true    },
                {   true,   false,  true    },
                {   true,   true,   false   }
        });

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }

    @Test
    public void getNewGameState_deadCellWith8LivingNeighbours_cellRemainsDead() {
        GameState gameState = new GameState(new boolean[][]{
                {   true,   true,   true    },
                {   true,   false,  true    },
                {   true,   true,   true    }
        });

        GameState newGameState = GameEngine.evolve(gameState);

        assertFalse(newGameState.getCellAt(new Coordinate(1, 1)).isAlive());
    }
}
