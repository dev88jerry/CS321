package assign5;

/**
*
* Name: Gregory Mierzwinski
* Date: 04/04/2016
* Description: This is a class that represents the bridge that cars will cross over.
*
* @author Gregory
*
*/

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Bridge {
	//Cars on the bridge
	private Queue<Car> carsOnBridge;

	//Max number of cars (isn't enforced)
	private int maxNumber;

	//Current number of cars
	private int currentNum;

	//Semaphore for BishBound cars
	private Semaphore bBoundOnBridge;

	//Semaphore for BishBound cars
	private Semaphore lBoundOnBridge;


	/**
	 * Gets the semaphore for BishBound.
	 * @return
	 */
	public synchronized Semaphore getbBoundOnBridge() {
		return bBoundOnBridge;
	}


	/**
	 * Sets the semaphore for BishBound.
	 * @param bBoundOnBridge
	 */
	public synchronized void setbBoundOnBridge(Semaphore bBoundOnBridge) {
		this.bBoundOnBridge = bBoundOnBridge;
	}


	/**
	 * Gets the semaphore for BishBound.
	 * @return
	 */
	public synchronized Semaphore getlBoundOnBridge() {
		return lBoundOnBridge;
	}


	/**
	 * Sets the semaphore for LionBound.
	 * @param lBoundOnBridge
	 */
	public synchronized void setlBoundOnBridge(Semaphore lBoundOnBridge) {
		this.lBoundOnBridge = lBoundOnBridge;
	}


	/**
	 * The next few methods are getters and setters.
	 */

	public Queue<Car> getCarsOnBridge() {
		return carsOnBridge;
	}

	public void setCarsOnBridge(Queue<Car> carsOnBridge) {
		this.carsOnBridge = carsOnBridge;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}

	public synchronized int getCurrentNum() {
		return currentNum;
	}

	public void setCurrentNum(int currentNum) {
		this.currentNum = currentNum;
	}

	/**
	 * Constructor to initialize the bridge.
	 * @param maxNumber
	 */
	public Bridge(int maxNumber){
		this.carsOnBridge = new LinkedBlockingQueue<Car>();
		this.maxNumber = maxNumber;
		this.bBoundOnBridge = new Semaphore(1);
		this.lBoundOnBridge = new Semaphore(0);
	}


	/**
	 * Get the type of car currently on the bridge.
	 * @return
	 */
	public synchronized Car getTypeOnBridge(){
		return carsOnBridge.peek();
	}


	/**
	 * check if the bridge is empty.
	 * @return
	 */
	public synchronized boolean isEmpty(){
		return carsOnBridge.isEmpty();
	}


	/**
	 * Get a car onto the bridge.
	 * @param c
	 */
	public synchronized void getOntoBridge(Car c) {
		System.out.println(c.toString() + " has acquired the bridge.");
		carsOnBridge.add(c);
		currentNum++;
	}


	/**
	 * Get a car off the bridge.
	 * @param c
	 */
	public synchronized void getOffBridge(Car c){
		currentNum--;
		System.out.println(c.toString() + " has left the bridge.");
		carsOnBridge.remove(c);
	}


	/**
	 * Output what is on the bridge.
	 */
	public synchronized void outputBridge(){
		Iterator<Car> it = carsOnBridge.iterator();
		System.out.println("Bridge has: ");
		while(it.hasNext()){
			System.out.println("\t" + it.next().toString());
		}
	}
}
