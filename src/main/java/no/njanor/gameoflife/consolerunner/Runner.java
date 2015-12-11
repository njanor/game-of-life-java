package no.njanor.gameoflife.consolerunner;

import no.njanor.gameoflife.gamelogic.Coordinate;
import no.njanor.gameoflife.gamelogic.GameEngine;
import no.njanor.gameoflife.gamelogic.GameState;

import java.util.List;

public class Runner {
    public static void main(String args[]) {
        System.out.println("Starting a new Game of Life...");

        List<Coordinate> coordinates;
        try {
            coordinates = CoordinateInterpreter.interpretString(args[0]);
        }
        catch (IllegalArgumentException iae) {
            System.out.println("Provided coordinates (" + args[0] + ") are not valid. Exiting...");
            return;
        }
        catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("You did not provide any arguments. Exiting...");
            return;
        }
        GameState gameState = new GameState(coordinates);
        int generation = 0;

        do {
            System.out.println("Current generation: " + generation);
            System.out.println(gameState.toString(20, 20));
            gameState = GameEngine.evolve(gameState);
            generation++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("An error occurred, exiting");
                break;
            }
        } while (true);
    }
}
