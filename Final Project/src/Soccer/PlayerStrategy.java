/**
 * Name: Jerry Lau
 * Date: 28 Apr 2022
 * Description: Implementation of strategy design pattern
 */

package Soccer;

/**
 * Strategy design pattern implementation to select the startingXI in a team
 */
public interface PlayerStrategy {

    public void pickXI(Team team);

}
