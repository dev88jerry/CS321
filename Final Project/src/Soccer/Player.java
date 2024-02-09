/**
 * Name: Jerry Lau
 * Date: 28 Apr 2022
 * Description: Player abstract class, uses a facade pattern for specific positions
 */

package Soccer;

import java.util.Random;

/**
 * Class that defines the attributes of a player
 */
public abstract class Player implements Comparable<Player>{

    protected String name;
    protected int age;
    protected char position;
    protected int stamina;
    protected int gameStamina;
    protected int techDef;
    protected int techAtt;
    protected int phyDef;
    protected int phyAtt;
    protected int menDef;
    protected int menAtt;
    protected int totalAtt;
    protected int totalDef;

    protected static final int maxAge = 40;
    protected static final int minAge = 16;
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    /**
     * Method to generate player stats
     * Requires the implementing class to write the method
     */
    abstract void generateStats();

    /**
     * Method to sum up all attacking stats and defending stats into single parameter
     */
    protected void calcTotalStats(){
        this.totalAtt = this.menAtt + this.techAtt + this.phyAtt;
        this.totalDef = this.menDef + this.techDef + this.phyDef;
    }

    /**
     * Method to generate random alphabet name
     * @return string of name
     */
    protected String generateName(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int len = 7;

        for(int i=0;i<len;i++){
            int index = random.nextInt(alphabet.length());
            char ranChar = alphabet.charAt(index);
            sb.append(ranChar);
        }

        String ret = sb.toString();
        return ret;
    }

    /**
     * toString method that displays the players attributes and position
     * @return string of player
     */
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position=" + position +
                ", stamina=" + stamina +
                ", gameStamina=" + gameStamina +
                ", techDef=" + techDef +
                ", techAtt=" + techAtt +
                ", phyDef=" + phyDef +
                ", phyAtt=" + phyAtt +
                ", menDef=" + menDef +
                ", menAtt=" + menAtt +
                ", totalDef="+ totalDef+
                ", totalAtt="+ totalAtt+
                '}';
    }

    /*
    Getters and setters to encapsulate object parameters
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getPosition() {
        return position;
    }

    public void setPosition(char position) {
        this.position = position;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getTechDef() {
        return techDef;
    }

    public void setTechDef(int techDef) {
        this.techDef = techDef;
    }

    public int getTechAtt() {
        return techAtt;
    }

    public void setTechAtt(int techAtt) {
        this.techAtt = techAtt;
    }

    public int getPhyDef() {
        return phyDef;
    }

    public void setPhyDef(int phyDef) {
        this.phyDef = phyDef;
    }

    public int getPhyAtt() {
        return phyAtt;
    }

    public void setPhyAtt(int phyAtt) {
        this.phyAtt = phyAtt;
    }

    public int getMenDef() {
        return menDef;
    }

    public void setMenDef(int menDef) {
        this.menDef = menDef;
    }

    public int getMenAtt() {
        return menAtt;
    }

    public void setMenAtt(int menAtt) {
        this.menAtt = menAtt;
    }

    public int getGameStamina() {
        return gameStamina;
    }

    public void setGameStamina(int gameStamina) {
        this.gameStamina = gameStamina;
    }

    public int getTotalAtt() {
        return totalAtt;
    }

    public void setTotalAtt(int totalAtt) {
        this.totalAtt = totalAtt;
    }

    public int getTotalDef() {
        return totalDef;
    }

    public void setTotalDef(int totalDef) {
        this.totalDef = totalDef;
    }
}
