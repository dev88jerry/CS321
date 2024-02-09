package simulation;

/**
 * Name: Gregory Mierzwinski
 * Date: 03/15/2016
 * Description: Event for a teller arrival.
 *
 * @author Gregory
 */

public class Teller_Arrival extends Event {

	//Client arriving at the teller
	private Client teller;


	/**
	 * Constructs a teller arrival for a given client at the given time.
	 * @param time		Time of arrival
	 * @param atTeller	Client that is arriving
	 */
	public Teller_Arrival(int time, Client atTeller){
		this.time = time;
		this.teller = atTeller;
		atTeller.setTellerTime(this.time);
	}


	/**
	 * This adds a client to the teller. If the teller is currently serving then the client is placed in the queue.
	 * At the end it schedules a new departure.
	 */
	@Override
	void process() {
		//Set the time
		Time.increaseTime(time);

		//Get the servver and stats for the server
		Server<Client> tellerQ = BankSim.getServers().getServer("Teller");
		Statistics stats = BankSim.getStats().getServerStatistics("Teller");

		if (!tellerQ.isServing()){ //If the teller is not serving
			//Set the client to the server and collect stats
			teller.setEndTellerTime(time);
			tellerQ.setToServer(teller);

			//Waiting time = time exited - time entered
			stats.addWaitingTime(teller.getEndTellerTime()-teller.getTellerTime());
			stats.addServerCustomer();
			int transTime = (int)RandBox.expo(teller.getNumOfTransactions()*2*bank.avgT());

			//Schedule a departure for the client
			EventQueue.addEvent(new Teller_Depart(Time.getClock() + transTime));
		}
		else{ //Otherwise, we add the client to the server queue
			tellerQ.insertIntoServerQ(teller);
			stats.addTotalLength(BankSim.getServers().getServer("Teller").getSize());
		}
	}

}
