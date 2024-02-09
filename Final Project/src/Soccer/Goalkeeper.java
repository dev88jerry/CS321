/**
 * Name: Jerry Lau
 * Date: 28 Apr 2022
 * Description: Goalkeeper class that extends player
 */

package Soccer;

import java.util.Random;

/**
 * Specific type of player that has low attacking attributes
 */
public class Goalkeeper extends Player{

    private static final double stdDev = 2.0;
    private static final double meanSt = 12.0;

    /**
     * Goalkeeper constructor and sets the position
     * Generates a random name for the object
     * @param pos char of position
     */
    public Goalkeeper(char pos){
        super();
        super.position = pos;
        super.name = "GKP " + super.generateName();
    }

    /**
     * Method to generate goalkeeper stats
     * Uses a random normal distribution with constants defined at top of class
     * Attack stats for goalkeeper are the same for all 3 attributes
     */
    @Override
    void generateStats() {
        Random ran = new Random();
        double mySample = ran.nextGaussian() * stdDev + meanSt;
        super.stamina = (int) Math.round(mySample);
        super.gameStamina = super.stamina;
        mySample = ran.nextGaussian() * stdDev + meanSt;
        super.techDef = (int) Math.round(mySample);
        mySample = ran.nextGaussian() * stdDev + meanSt;
        super.menDef = (int) Math.round(mySample);
        mySample = ran.nextGaussian() * stdDev + meanSt;
        super.phyDef = (int) Math.round(mySample);
        mySample = ran.nextGaussian() * stdDev + meanSt;
        super.techAtt = (int) Math.round(mySample);
        super.menAtt = super.techAtt;
        super.phyAtt = super.menAtt;
        super.age = ran.nextInt(maxAge - minAge + 1) + minAge;
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
        public int compareTo(Player o) {
            return this.getTotalDef() - o.getTotalDef();
        }
    }
