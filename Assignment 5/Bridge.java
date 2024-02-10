package assign5;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class Bridge {

	private Queue<Car> carsOnBridge;

	private int maxNumber;
	private int currentNum;
	private Semaphore bBoundOnBridge;
	private Semaphore lBoundOnBridge;

	/**
	 * @return
	 */
	public synchronized Semaphore getbBoundOnBridge() {
		return bBoundOnBridge;
	}

	/**
	 * @param bBoundOnBridge
	 */
	public synchronized void setbBoundOnBridge(Semaphore bBoundOnBridge) {
		this.bBoundOnBridge = bBoundOnBridge;
	}

	/**
	 * @return
	 */
	public synchronized Semaphore getlBoundOnBridge() {
		return lBoundOnBridge;
	}

	/**
	 * @param lBoundOnBridge
	 */
	public synchronized void setlBoundOnBridge(Semaphore lBoundOnBridge) {
		this.lBoundOnBridge = lBoundOnBridge;
	}

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
	 * Constructor
	 * @param maxNumber
	 */
	public Bridge(int maxNumber){
		this.carsOnBridge = new LinkedBlockingQueue<Car>();
		this.maxNumber = maxNumber;
		this.bBoundOnBridge = new Semaphore(1);
		this.lBoundOnBridge = new Semaphore(0);
	}

	/**
	 * @return
	 */
	public synchronized Car getTypeOnBridge(){
		return carsOnBridge.peek();
	}

	/**
	 * @return
	 */
	public synchronized boolean isEmpty(){
		return carsOnBridge.isEmpty();
	}

	/**
	 * @param c
	 */
	public synchronized void getOntoBridge(Car c) {
		System.out.println(c.toString() + " has acquired the bridge.");
		carsOnBridge.add(c);
		currentNum++;
	}

	/**
	 * @param c
	 */
	public synchronized void getOffBridge(Car c){
		currentNum--;
		System.out.println(c.toString() + " has left the bridge.");
		carsOnBridge.remove(c);
	}

	public synchronized void outputBridge(){
		Iterator<Car> it = carsOnBridge.iterator();
		System.out.println("Bridge has: ");
		while(it.hasNext()){
			System.out.println("\t" + it.next().toString());
		}
	}
}
