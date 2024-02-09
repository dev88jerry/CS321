package simulation;

/**
 * Name: Gregory Mierzwinski
 * Date: 03/15/2016
 * Description: This class is used as the client for the servers.
 *
 * @author Gregory
 */

public class Client {

	//Reception arrival time
	private int time;

	//Teller arrival time
	private int tellerTime;

	//Number of transactions to be processed
	private int numOfTransactions;

	//Time that the client finished waiting in the reception queue
	private int endWait;

	//Time that the client finished waiting in the teller queue
	private int endTellerTime;

	/**
	 * Constructor which initializes the client to the giveen arrival time.
	 * @param time The arrival time.
	 */
	public Client(int time){
		//Initialize the times
		this.time = time;
		this.endWait = time;
		this.endTellerTime = time;
		this.tellerTime = time;

		//Initializes the number of transactions
		int r = ((int)(Math.random()*5))+1;
		this.numOfTransactions = r;
	}


	/**
	 * Get the time that the client ended waiting in the reception queue.
	 */
	public int getEndWait() {
		return endWait;
	}


	/**
	 * Set the time the client finished waiting at the reception queue.
	 * @param endWait End wait time.
	 */
	public void setEndWait(int endWait) {
		this.endWait = endWait;
	}


	/**
	 * Get the time the client finished waiting in the teller queue.
	 * @return Exited time.
	 */
	public int getEndTellerTime() {
		return endTellerTime;
	}


	/**
	 * Set the time that the client exited the teller queue.
	 * @param endTellerTime Exited time.
	 */
	public void setEndTellerTime(int endTellerTime) {
		this.endTellerTime = endTellerTime;
	}


	/**
	 * Get the time that the client entered the teller queue.
	 * @return The time the client entered the teller queue.
	 */
	public int getTellerTime() {
		return tellerTime;
	}


	/**
	 * Set the time the client entered the queue.
	 * @param tellerTime Time the client entered the teller queue.
	 */
	public void setTellerTime(int tellerTime) {
		this.tellerTime = tellerTime;
	}


	/**
	 * Get the time the client entered the receptionist queue.
	 * @return Time the client entered the receptionist queue
	 */
	public int getTime() {
		return time;
	}


	/**
	 * Set the time the client entered the receptionist queue.
	 * @param time Time the client entered the receptionist queue.
	 */
	public void setTime(int time) {
		this.time = time;
	}


	/**
	 * Get the number of transactions to be done.
	 * @return The number of transactions.
	 */
	public int getNumOfTransactions() {
		return numOfTransactions;
	}


	/**
	 * Set the number of transactions to be done.
	 * @param numOfTransactions The number of transactions.
	 */
	public void setNumOfTransactions(int numOfTransactions) {
		this.numOfTransactions = numOfTransactions;
	}

}
