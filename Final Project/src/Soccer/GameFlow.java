/**
 * Name: Jerry Lau
 * Date: 28 Apr 2022
 * Description: Chain of responsibility pattern
 */

package Soccer;

/**
 * Starting class in Chain of responsibility
 */
public abstract class GameFlow {

    /**
     * Next step to process in chain of responsibility
     */
    protected GameFlow nextStep;

    /**
     * Method to set the nextStep in chain of responsibility
     * @param nextStep object of class GameFlow
     */
    public void setNextStep(GameFlow nextStep){
        this.nextStep = nextStep;
    }

    /**
     * Method to be implemented
     * @param game type of object
     */
    abstract void completeTask(Game game);

}
