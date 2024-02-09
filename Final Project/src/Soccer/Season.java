/**
 * Name: Jerry Lau
 * Date: 28 Apr 2022
 * Description: Singleton design pattern
 */

package Soccer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Singleton that has access to teams created in simulation
 */
public class Season {

    private static Season instance;
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<String> gameToPlay = new ArrayList<>();
    private int gamesPlayed;
    private int extraCalls;
    private static int numTeams;

    /**
     * Singleton constructor
     */
    private Season(){
        this.gamesPlayed = 0;
        this.extraCalls = 0;
    }

    /**
     * Method to call singleton instance
     * @return Season object
     */
    public static Season getInstance(){
        if(instance == null){
            instance = new Season();
        }
        return instance;
    }

    /**
     * Method to create teams
     * Currently fixed to 8 teams max
     * Will change the number of teams back to an even number
     * @param numTeams int for number of teams in the season
     */
    public void startSeason(int numTeams){
        TeamCreator tc = new TeamCreator();
        if(numTeams > 8){
            numTeams = 8;
        }
        else if(numTeams % 2 != 0){
            numTeams++;
        }

        this.numTeams = numTeams;
        for(int i=0;i<numTeams;i++){
            Team t = tc.createTeam();
            this.teams.add(t);
        }
        this.generateMatches();
        Collections.shuffle(gameToPlay);
    }

    /**
     * Method to generate matches for each team in the season
     * Each team will player the other teams twice
     */
    public void generateMatches(){
        int[] arr = new int[teams.size()];
        int[] visited = new int[teams.size()];
        for(int i = 1; i<teams.size()+1;i++){
            arr[i-1] = i;
        }
        int j = 0;
        for(Team t : teams){
            visited[j]=0;
            j++;
        }
        int N = nPr(teams.size(),2);
        getPermutations(arr,visited,0,2,N,"",gameToPlay);
    }

    /**
     * Method used by skeleton to perform 1 match
     * @return
     */
    public String performTask(){
        if(gamesPlayed == gameToPlay.size()) {
            this.extraCalls++;
            return null;
        } else {
            String str = gameToPlay.get(gamesPlayed);
            this.gamesPlayed++;
            return str;
        }
    }

    /**
     * Method to extract 1 team with provided index
     * @param index int value for team index in arraylist
     * @return a Team
     */
    public Team getTeam(int index){
        Team team = teams.get(index);
        return team;
    }

    /**
     * Factorial method, recursive
     * @param n value to calculate
     * @return factorial of n
     */
    static int fact(int n)
    {
        if (n <= 1)
            return 1;
        return n * fact(n - 1);
    }

    /**
     * Permutation calculator nPr
     * @param n number of objects
     * @param r sample size
     * @return total number of permutations
     */
    static int nPr(int n, int r)
    {
        return fact(n) / fact(n - r);
    }

    /**
     * Recursive method to generate the match permutation
     * Provides a string to determine which team will play another team
     * @param arr array filled with team number (1-8)
     * @param visited empty array to be filled by method
     * @param pos index of item visited
     * @param K sample size of permutation
     * @param N number to total objects
     * @param str string to denote team ie 12 -> team1 plays team2
     * @param permu arraylist of string to be filled with permutations
     */
    private static void getPermutations(int[] arr, int[] visited, int pos, int K, int N, String str, ArrayList <String> permu){
        if (pos == K) {
            //System.out.println(str);
            permu.add(str);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // Only recur if the ith element is not visited.
            if (visited[i] == 0) {
                // mark ith element as visited.
                visited[i] = 1;
                getPermutations(arr, visited, pos + 1, K, N, str + arr[i], permu);
                // unmark ith element as visited.
                visited[i] = 0;
            }
        }
    }

    /**
     * Method to display the teams and their matches played during the season
     * Teams are sorted by lowest to highest points
     */
    public void displaySeason(){
        this.calculateSeason();
        Collections.sort(teams);
        System.out.println("Total games played in this simulation: " + (this.gamesPlayed + this.extraCalls));
        System.out.printf("Total number of games for %d of teams: %d\n", this.teams.size(), this.gameToPlay.size());
        System.out.println("After the simulation here are the results (W-D-L)");
        for (Team t: teams) {
            System.out.println(t);
        }
    }

    /**
     * Method to get total points for each team from season
     */
    private void calculateSeason(){
        for (Team t: teams) {
            t.calcPoints();
        }
    }

    /*
    Getters and setters for encapsulation
     */
    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public ArrayList<String> getGameToPlay() {
        return gameToPlay;
    }

    public void setGameToPlay(ArrayList<String> gameToPlay) {
        this.gameToPlay = gameToPlay;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getExtraCalls() {
        return extraCalls;
    }

    public void setExtraCalls(int extraCalls) {
        this.extraCalls = extraCalls;
    }

    public static int getNumTeams() {
        return numTeams;
    }

    public void setNumTeams(int numTeams) {
        this.numTeams = numTeams;
    }
}
