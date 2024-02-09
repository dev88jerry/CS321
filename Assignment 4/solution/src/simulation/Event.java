package simulation;

/**
 * Name: Gregory Mierzwinski
 * Date: 03/15/2016
 * Description: This class is used as the prototype for all events.
 *
 * @author Gregory
 */

public abstract class Event implements Comparable {

	//The time of the event
	protected int time;

	//The bank the event will run in. Used to get the constants interarrival time and avg time per transaction.
	protected static BankSim bank;


	/**
	 * Must be implemented by inheritor. Used to proccess an event.
	 */
	abstract void process();


	/**
	 * Set the bank to run on.
	 * @param b The bank the simulation will run on.
	 */
	public static void addBankSim(BankSim b){
		bank = b;
	}


	/**
	 * Used to compare the events for the priority queue. The event that has a smaller time
	 * is the one that will be first.
	 */
	@Override
	public int compareTo (Object o){
		Event a = (Event)o;
		if (this.time == a.time){
			return 0;
		}
		else if (this.time < a.time){
			return -1;
		}
		else{
			return 1;
		}
	}
}
