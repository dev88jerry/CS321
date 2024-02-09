/**
 * Name: Jerry Lau
 * Date: 28 Apr 2022
 * Description: Game class that is used by 2 teams to determine the winner
 */

package Soccer;

/**
 * Class that defines required items by 2 teams for a game
 */
public class Game {

    private Team team1;
    private Team team2;
    private boolean aWin;
    private boolean bWin;
    private int teamAstm;
    private int teamBstm;
    private int teamAscore;
    private int teamBscore;

    public Game(Team t1, Team t2) {
        this.team1 = t1;
        this.team2 = t2;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public boolean isaWin() {
        return aWin;
    }

    public void setaWin(boolean aWin) {
        this.aWin = aWin;
    }

    public boolean isbWin() {
        return bWin;
    }

    public void setbWin(boolean bWin) {
        this.bWin = bWin;
    }

    public int getTeamAstm() {
        return teamAstm;
    }

    public void setTeamAstm(int teamAstm) {
        this.teamAstm = teamAstm;
    }

    public int getTeamBstm() {
        return teamBstm;
    }

    public void setTeamBstm(int teamBstm) {
        this.teamBstm = teamBstm;
    }

    public int getTeamAscore() {
        return teamAscore;
    }

    public void setTeamAscore(int teamAscore) {
        this.teamAscore = teamAscore;
    }

    public int getTeamBscore() {
        return teamBscore;
    }

    public void setTeamBscore(int teamBscore) {
        this.teamBscore = teamBscore;
    }
}
