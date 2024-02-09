/**
 * Name: Jerry Lau
 * Date: 28 Apr 2022
 * Description: One of the player Strategies
 */

package Soccer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Player Strategy that selects the worst 11 players
 */
public class WorstXI implements PlayerStrategy{
    /**
     * Method that is required to be implemented
     * Sets the 4 player positions into different array list
     * Selects the worst players based on their attributes into the Team startingXI
     * @param team Team to set their startingXI
     *
     *
     *
     *
     *
     */
    @Override
    public void pickXI(Team team) {
        ArrayList<Player> keepers = new ArrayList<>();
        ArrayList<Player> defenders = new ArrayList<>();
        ArrayList<Player> midfielders = new ArrayList<>();
        ArrayList<Player> attackers = new ArrayList<>();

        for (Player p : team.getSquad()) {
            switch (p.getPosition()){
                case 'G':
                    keepers.add(p);
                    break;
                case 'D':
                    defenders.add(p);
                    break;
                case 'M':
                    midfielders.add(p);
                    break;
                case 'A':
                    attackers.add(p);
                    break;
            }
        }
        //Call sort on the 4 positions
        //Worst players at the front
        Collections.sort(keepers);
        Collections.sort(defenders);
        Collections.sort(midfielders);
        Collections.sort(attackers);

        team.startingXI.add(keepers.get(0));
        for(int i = 0; i < 4; i++){
            team.startingXI.add(defenders.get(i));
            team.startingXI.add(midfielders.get(i));
            if(i<2)
                team.startingXI.add(attackers.get(i));
        }
    }
}
