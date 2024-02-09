/**
 * Name: Jerry Lau
 * Date: 28 Apr 2022
 * Description: Class to execute strategy pattern
 */

package Soccer;

/**
 * Class to execute the player strategy
 */
public class SelectXI {

    private PlayerStrategy strategy;

    public SelectXI(PlayerStrategy ps) {
        this.strategy = ps;
    }

    public void executeStrategy(Team team) {
        strategy.pickXI(team);
    }
}
