/**
 * Name: Jerry Lau
 * Date: 28 Apr 2022
 * Description: 1st step in chain
 */


package Soccer;

import java.util.Random;

/**
 * First step in Chain of responsibility
 * Determines the score for each team
 */
public class GameFlowLogic extends GameFlow {

    private int gameTime;
    private int teamAstm;
    private int teamBstm;

    /**
     * Implemented method for chain of responsibility
     * @param game game object with 2 teams
     */
    @Override
    void completeTask(Game game) {

        Team teamA = game.getTeam1();
        Team teamB = game.getTeam2();

        int teamAscore = 0;
        int teamBscore = 0;

        int teamAatt = 0;
        int teamAdef = 0;

        int teamBdef = 0;
        int teamBatt = 0;

        for(Player p : teamA.startingXI){
            if (p.getPosition() != 'G')
                teamAatt += p.getTotalAtt();
            teamAdef += p.getTotalDef();
            this.teamAstm += p.getGameStamina();
        }

        for(Player p : teamB.startingXI){
            if (p.getPosition() != 'G')
                teamBatt += p.getTotalAtt();
            teamBdef += p.getTotalDef();
            this.teamBstm += p.getGameStamina();
        }

        /*
        Game Logic calls
        Breaks game into 90 turns, each teams has 45 chances to score
        Score determined by player attributes in startingXI
         */
        while(this.gameTime < 90) {

            //multipliers
            //home team adv
            Random rand = new Random();

            if (gameTime % 2 == 0) {
                double teamAatk = teamAatt + (0.2 * this.teamAstm) + (0.2 * teamA.getTeamMoral());
                double teamBdfn = teamBdef + (0.2 * this.teamBstm) + (0.2 * teamB.getTeamMoral());
                int xG = (int) Math.abs(Math.round(teamAatk - teamBdfn));

                //50% chance to score
                if (teamAatk > teamBdfn) {
                    if (rand.nextGaussian() > 0.0)
                        teamAscore++;
                }
                //30% chance to score
                else if(xG == 0 || xG == 1){
                    if (rand.nextGaussian() > 0.5)
                        teamAscore++;
                }
                //30% change to score if 1st condition is true
                else if(gameTime % xG == 0 && rand.nextGaussian() > 0.5){
                    teamAscore++;
                }
                //attacking team loose 2 stamina for each player
                this.teamAstm -= 22;
                //defending team loose 1 stamina for each player
                this.teamBstm -= 11;
            }
            else {
                double teamAdfn = teamAdef + (0.2 * this.teamAstm) + (0.2 * teamA.getTeamMoral());
                double teamBatk = teamBatt + (0.2 * this.teamBstm) + (0.2 * teamB.getTeamMoral());
                int xG = (int) Math.abs(Math.round(teamBatk - teamAdfn));

                if (teamBatk > teamAdfn) {
                    if (rand.nextGaussian() > 0.0)
                        teamAscore++;
                }
                else if(xG == 0 || xG == 1){
                    if (rand.nextGaussian() > 0.5)
                        teamAscore++;
                }
                else if(gameTime % xG == 0 && rand.nextGaussian() > 0.5){
                    teamAscore++;
                }

                this.teamAstm -= 11;
                this.teamBstm -= 22;
            }

            this.gameTime++;
        }

        game.setTeamAscore(teamAscore);
        game.setTeamBscore(teamBscore);

        nextStep.completeTask(game);
    }

}
