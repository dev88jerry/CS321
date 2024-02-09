/**
 * Name: Jerry Lau
 * Date: 28 Apr 2022
 * Description: Team class contains players
 */

package Soccer;

import java.util.*;

/**
 * Team class that defines items in a team
 */
public class Team implements Comparable<Team>{

    public ArrayList<Player> startingXI = new ArrayList<>(11);
    private ArrayList<Player> squad = new ArrayList<>(25);
    private int teamMoral;
    private String teamName;
    private int teamWins;
    private int teamLoss;
    private int teamDraw;
    private int points;
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private static final double stdDev = 2.0;
    private static final double meanSt = 12.0;

    /**
     * Team constructor, sets team points to 0
     */
    public Team(){
        this.points = 0;
    }

    /**
     * Generate Team Name method
     * @return string of team name
     */
    protected String generateTeamName(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int len = 10;

        for(int i=0;i<len;i++){
            int index = random.nextInt(alphabet.length());
            char ranChar = alphabet.charAt(index);
            sb.append(ranChar);
        }

        String ret = sb.toString();
        return ret;
    }

    /**
     * Generate Team Moral method
     * Sets team moral to a random normal distributed value using constants defined above
     */
    protected void generateTeamMoral(){
        Random ran = new Random();
        double mySample = ran.nextGaussian() * stdDev + meanSt;
        this.teamMoral = (int) Math.round(mySample);
    }

    /**
     * To String method
     * @return Team name with number of wins, draws, losses
     */
    @Override
    public String toString() {
        return this.teamName + ": " + this.teamWins + "-" + this.teamDraw + "-" + this.teamLoss + " = " + this.points;
    }

    /**
     * Print team method
     * Used for debugging
     * Will display all members in a team
     */
    public void printTeam(){
        System.out.println(this.teamName);
        System.out.println("Team moral = " + this.teamMoral);
        System.out.println("All players on team");
        for(Player p : squad)
            System.out.println(p.toString());
        System.out.println();
        System.out.println("Players in Starting XI");
        for(Player p : startingXI)
            System.out.println(p.toString());
    }

    /**
     * Calculate team points method
     * Will award a team with 3 points for each win, 1 point for each draw
     */
    public void calcPoints(){
        this.points = 3 * this.teamWins + this.teamDraw;
    }

    /*
    Getter and setters for parameters in team object
     */

    public ArrayList<Player> getSquad() {
        return squad;
    }

    public void setSquad(ArrayList<Player> squad) {
        this.squad = squad;
    }

    public int getTeamMoral() {
        return teamMoral;
    }

    public void setTeamMoral(int teamMoral) {
        this.teamMoral = teamMoral;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamWins() {
        return teamWins;
    }

    public void setTeamWins() {
        this.teamWins++;
    }

    public int getTeamLoss() {
        return teamLoss;
    }

    public void setTeamLoss() {
        this.teamLoss++;
    }

    public int getTeamDraw() {
        return teamDraw;
    }

    public void setTeamDraw() {
        this.teamDraw++;
    }

    public int getPoints() {
        return points;
    }



    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure {@link Integer#signum
     * signum}{@code (x.compareTo(y)) == -signum(y.compareTo(x))} for
     * all {@code x} and {@code y}.  (This implies that {@code
     * x.compareTo(y)} must throw an exception if and only if {@code
     * y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code
     * x.compareTo(y)==0} implies that {@code signum(x.compareTo(z))
     * == signum(y.compareTo(z))}, for all {@code z}.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Team o) {
        return this.points - o.getPoints();
    }

}
