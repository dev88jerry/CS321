package simulation;

/**
 * Name: Gregory Mierzwinski
 * Date: 03/15/2016
 * Description: This class will be used as the clock.
 *
 * @author Gregory
 */

public class Time {

	//The time of the clock
	private static int clock = 0;


	/**
	 * Get the time.
	 * @return Time of the clock.
	 */
	public static int getClock(){
		return clock;
	}


	/**
	 * Increase the time.
	 * @param time Time to move to.
	 */
	public static void increaseTime(int time){
		clock = time;
	}
}
