/**
 * Name: Jerry Lau
 * Date: 28 Apr 2022
 * Description: A factory design pattern for team
 */

package Soccer;

import java.util.ArrayList;

/**
 * Factory method that creates a team with 26 players
 */
public class TeamCreator extends Team{

    /**
     * Create Team method using a factory design pattern
     * Initialize with 3 goalkeepers, 9 defender, 9 midfielders, 5 attackers
     * @return a team with 26 players
     */
    public Team createTeam(){
        ArrayList<Player> myTeam = new ArrayList<>();
        Team t = new Team();
        PlayerCreator pc = new PlayerCreator();
        t.setTeamName(t.generateTeamName());

        for(int i=0;i<3;i++)
            myTeam.add(pc.createPlayer('G'));
        for(int i=0;i<9;i++) {
            myTeam.add(pc.createPlayer('D'));
            myTeam.add(pc.createPlayer('M'));
        }
        for(int i=0;i<5;i++)
            myTeam.add(pc.createPlayer('A'));

        t.setSquad(myTeam);
        t.generateTeamMoral();

        StartingXI si = new StartingXI();
        si.startingXI(t);

        return t;
    }


}
