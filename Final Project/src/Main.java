import Skeleton.SimulationInput;
import Skeleton.StatisticsContainer;
import Soccer.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The main class is responsible for the testing. It has a helper method
 * that makes it easier to run many tests.
 **/
public class Main {
    /**
     * Runs a test with the given input and returns the statistics
     * produced from the test run. Simplifies the testing process.
     *
     * @param input The input to run the test with.
     * @return The statistics of the test run.
     **/
    public static StatisticsContainer runTest(SimulationInput input) {
        // Initialize the stats singleton here so the input can
        // be ignored in future calls
        StatisticsContainer stats = StatisticsContainer.getInstance(input);
        Matrix.run(input);

        return stats;
    }

    /**
     * See method above for details.
     **/
    public static StatisticsContainer runTest(ArrayList<ArrayList<String>> input) {
        return runTest(new SimulationInput(input));
    }

    public static void main(String[] args) {

        Season season = Season.getInstance();
        season.startSeason(8);

        SimulationInput si = new SimulationInput();
        si.addInput("Time", List.of("16")); // In seconds
        si.addInput("ActionsPerSecond", List.of("4"));
        //si.addInput("RobotsMustYell", List.of("HELLO, WORLD"));
        si.addInput("Playing match", List.of("Matches"));

        // Run the simulation
        StatisticsContainer stats = runTest(si);

        // Post the finalized statistics
        stats.printStatisticsContainer();

        //display season to console, sort teams
        System.out.println();
        season.displaySeason();

        //display season stats to JFrame UI
        GUI gui = new GUI();
    }
}
