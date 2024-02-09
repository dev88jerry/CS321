package assign5;

/**
*
* Name: Gregory Mierzwinski
* Date: 04/04/2016
* Description: This is the test class.
*
* @author Gregory
*
*/

public class Simulation {
	public static void main(String[] args){

		//Create the bridge...if you build it they will come
		Bridge b = new Bridge(10);

		//The cars to run over the bridge
		BishBound bB = new BishBound(b);
		BishBound bB2 = new BishBound(b);
		BishBound bB3 = new BishBound(b);
		LionBound lB = new LionBound(b);
		LionBound lB2 = new LionBound(b);

		//Threads containing the cars to run
		Thread tb = new Thread(bB);
		Thread tl = new Thread(lB);
		Thread tl2 = new Thread(lB2);
		Thread tb2 = new Thread(bB2);
		Thread tb3 = new Thread(bB3);

		//Start them
		tb.start();
		tl.start();
		tl2.start();
		tb2.start();
		tb3.start();

	}
}
