package simulation;

/**
 * Name: Gregory Mierzwinski
 * Date: 03/15/2016
 * Description: This class is used to hold statistics for a server.
 *
 * @author Gregory
 */

public class Statistics {
	//Total time spent waiting
	private long totalWaitingTime;

	//Avg time spent waiting
	private long avgWaitingTime;

	//Total length
	private long totalLength;

	//Total time for weighted average of length
	private long totalSnaps;

	//Avg length of queue
	private long avgLength;

	//Number of customers in the server
	private long serverCustomers;

	//Avg transaction time
	private long avgTransTime;

	//Total transaction time
	private long totalTransTime;

	//Last time length was checked
	private long checkedLast;

	//Previous length of queue
	private long prevLength;

	//Total number of customers that have finished using the bank
	private static long totalCustomers;

	//Total time spent waiting in the bank
	private static long totalBankWaiting;

	//Average time spent in bank
	private static long avgBankWaiting;


	/**
	 * Constructor that initializes prevLength.
	 */
	public Statistics (){
		this.prevLength = 0;
	}


	/**
	 * Add to the total transaction time.
	 * @param totalTransTime Transaction time.
	 */
	public void addTotalTransTime(long totalTransTime){
		this.totalTransTime += totalTransTime;
	}


	/**
	 * Add a customer.
	 */
	public void addServerCustomer(){
		serverCustomers++;
	}


	/**
	 * Add to the total number of customers served across all the servers.
	 */
	public static void addTotalCustomer(){
		totalCustomers++;
	}


	/**
	 * Add to the total time spent in the bank.
	 * @param time
	 */
	public static void addBankWaiting(int time){
		totalBankWaiting += time;
	}


	/**
	 * Add to the total length. This is for a weighted average.
	 * @param length Length of queue.
	 */
	public void addTotalLength(int length){
		//If we've never checked before, set it to the current time
		if (this.checkedLast == 0){
			this.checkedLast = Time.getClock();
		}
		//If we are at a new length
		if (this.prevLength != length){
			//Get the amount of time the queue was the previous length
			this.totalLength += prevLength*(Time.getClock() - this.checkedLast);
			//Get the weight
			this.totalSnaps += (Time.getClock() - this.checkedLast);

			//Set the time and the new length
			this.checkedLast = Time.getClock();
			this.prevLength = length;
		}
		//If there have been weights added, get the average
		if (totalSnaps != 0){
			this.avgLength = this.totalLength/this.totalSnaps;
		}
	}


	/**
	 * Add to the time the client spent waiting in the queue.
	 * @param time The time spent waiting.
	 */
	public void addWaitingTime(int time){
		this.totalWaitingTime += time;
	}


	/**
	 * Print the server specific statistics.
	 * @param nameOfQueue The name of the queue to print statistics on.
	 */
	public void printStatistic(String nameOfQueue){
		//If we have no customers, set avg's to 0
		if(serverCustomers == 0){
			avgWaitingTime = 0;
			avgTransTime = 0;
		}
		else{
			avgWaitingTime = totalWaitingTime/serverCustomers;
			avgTransTime = totalTransTime/serverCustomers;
		}
		//If there are some weights added, calculate the avg length
		if(totalSnaps != 0){
			avgLength = totalLength/totalSnaps;
		}
		else{
			avgLength = 0;
		}
		System.out.println("Average Waiting Time in " + nameOfQueue + ": " + avgWaitingTime);
		System.out.println("Average Length of " + nameOfQueue + ": " + avgLength);
	}


	/**
	 * Print the bank statistics.
	 */
	public static void printBankStatistic(){
		if (totalCustomers != 0){
			avgBankWaiting = totalBankWaiting/(totalCustomers);
		}
		else {
			avgBankWaiting = 0;
		}
		System.out.println("Average Time Spent in Bank: " + avgBankWaiting);
	}
}
