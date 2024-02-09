/**
 * Name: Jerry Lau
 * Date: 28 Apr 2022
 * Description: 2nd step in chain
 */

package Soccer;

/**
 * 2nd step in chain of responsibility
 * Determines the winner from the previous step
 */
public class GameFlowWinner extends GameFlow {

    /**
     * Implemented method for chain of responsibility
     * Gets score from GameFlowLogic to determine winner
     * @param game game object with 2 teams
     */
    @Override
    void completeTask(Game game) {

        int teamAscore = game.getTeamAscore();
        int teamBscore = game.getTeamBscore();
        int aMoral = game.getTeam1().getTeamMoral();
        int bMoral = game.getTeam2().getTeamMoral();

        if (teamAscore > teamBscore) {
            game.setaWin(true);
            game.setbWin(false);

            game.getTeam1().setTeamMoral(aMoral + 2);
            game.getTeam2().setTeamMoral(bMoral - 1);
        }
        else if(teamBscore > teamAscore) {
            game.setbWin(true);
            game.setaWin(false);

            game.getTeam1().setTeamMoral(aMoral - 2);
            game.getTeam2().setTeamMoral(bMoral + 3);
        }
        else {
            game.setaWin(false);
            game.setbWin(false);

            game.getTeam1().setTeamMoral(aMoral + 1);
            game.getTeam2().setTeamMoral(bMoral + 1);
        }

        if(game.isaWin()) {
            System.out.println("Home Team " + game.getTeam1().getTeamName() + " wins, score was " + teamAscore + " to " + teamBscore);
            game.getTeam1().setTeamWins();
            game.getTeam2().setTeamLoss();
        }
        else if(game.isbWin()) {
            System.out.println("Away Team " + game.getTeam2().getTeamName() + " wins, score was " + teamBscore + " to " + teamAscore);
            game.getTeam1().setTeamLoss();
            game.getTeam2().setTeamWins();
        }
        else {
            System.out.println("It was a draw, score was " + teamAscore + " to " + teamBscore);
            game.getTeam1().setTeamDraw();
            game.getTeam2().setTeamDraw();
        }

    }
}
