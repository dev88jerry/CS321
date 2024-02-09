/**
 * Name: Jerry Lau
 * Date: 28 Apr 2022
 * Description: A factory design pattern for player
 */

package Soccer;

/**
 * A factory method that creates a player for a team
 */
public class PlayerCreator {

    /**
     * Create Player method using a factory design pattern
     * @param pos char of player position
     * @return player of requested position
     */
    public Player createPlayer(char pos){

        switch (Character.toUpperCase(pos)){
            case 'G':
                Goalkeeper gk = new Goalkeeper('G');
                gk.generateStats();
                gk.calcTotalStats();
                return gk;

            case 'D':
                Defender df = new Defender('D');
                df.generateStats();
                df.calcTotalStats();
                return df;

            case 'M':
                Midfielder mf = new Midfielder('M');
                mf.generateStats();
                mf.calcTotalStats();
                return mf;

            case 'A':
                Attacker ak = new Attacker('A');
                ak.generateStats();
                ak.calcTotalStats();
                return ak;

            default:
                return null;
        }
    }

}
