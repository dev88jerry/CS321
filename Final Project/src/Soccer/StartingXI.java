/**
 * Name: Jerry Lau
 * Date: 28 Apr 2022
 * Description: Class to randomize the execute strategy pattern
 */

package Soccer;

import java.util.Random;

/**
 * Class that randomizes the execution of the strategy pattern
 */
public class StartingXI {

    /**
     * Method to randomize call to one of the 3 strategies
     * Calls randomized in a normal distribution where ~67% will be bestXI strategy
     * @param team Team of players to use strategy
     */
    public void startingXI(Team team){

        Random random = new Random();
        SelectXI sXI = new SelectXI(new BestXI());
        double d = random.nextGaussian();
        if(d < -1.0){
            sXI = new SelectXI(new WorstXI());
            sXI.executeStrategy(team);
        }
        else if(d > 1.0){
            sXI = new SelectXI(new RandomXI());
            sXI.executeStrategy(team);
        }
        else {
            sXI.executeStrategy(team);
        }
    }
}
