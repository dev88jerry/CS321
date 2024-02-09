/**
 * Name: Jerry Lau
 * Date: 28 Apr 2022
 * Description: Matches class that extends Unit, allows calls to skeleton items for simulation
 */

import Skeleton.SimulationInput;
import Skeleton.Unit;
import Skeleton.WorkerStatistic;
import Soccer.Match;
import Soccer.Season;

/**
 * Method that implements Unit from skeleton package
 * Call upon methods from soccer for the simulation
 */
public class Matches extends Unit {

    /**
     * Constructor with 2 parameters
     * @param soccer string variable
     * @param input simulation input
     */
    public Matches(String soccer, SimulationInput input) {
        super(input);
        this.getStats().addStatistic(
                "MatchActionsPerformed",
                new WorkerStatistic("MatchActionsPerformed")
        );
    }

    /**
     * Has your unit perform a single action. For example:
     * Minning some ore.
     * Depositing some cargo.
     * Drive to a light.
     * Gathering produce from a producer.
     * ...
     * <p>
     * Your Skeleton.Unit may do a portion of a larger action as well
     * at this stage and hold a state of where it is along the path.
     * <p>
     * The unit could also attempt it all at once, but consider
     * how that will impact drift in the timing of the actions
     * (actions/second). There is nothing wrong with sleeping
     * with much longer than the actions/second rate though, and
     * it's encouraged to do so in some areas of your simulation.
     */
    @Override
    public void performAction() {
        Season season = Season.getInstance();
        Match match = new Match();
        String str = season.performTask();
        if(str != null) {
            int toPlay = Integer.parseInt(str);
            match.setTeam1(season.getTeam((toPlay / 10) - 1));
            match.setTeam2(season.getTeam((toPlay % 10) - 1));
            match.run();
            System.out.println(this.getSimInput().getInput("Playing match").get(0));
        }
        else{
            System.out.println("All games played");
        }
    }

    /**
     * Submit some statistics to the Skeleton.Statistics object.
     * <p>
     * This should handle sending statistics that don't depend on
     * what happens in the performAction method. In there, you may
     * want to also submit statistics (ore mined during action,
     * kilometers driven, tonnage of cargo deposited, etc.).
     */
    @Override
    public void submitStatistics() {
        this.getStats().getStatistic("MatchActionsPerformed").addValue(1);
    }

}
