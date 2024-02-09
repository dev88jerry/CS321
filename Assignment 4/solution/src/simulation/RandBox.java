package simulation;

/**
 * Name: Gregory Mierzwinski
 * Date: 03/15/2016
 * Description: This class will be used as the random number generator for arrival times and service times.
 *
 * @author Gregory
 */

public class RandBox {
	/**
	 * The function which produces a inversely exponential random number
	 * around the mean.
	 * @param mean	The mean to use.
	 * @return	The random number produced.
	 */

	public static double expo (double mean){
        double x = Math.random();
        x = -mean * Math.log(x);
        return x;
    }

}
