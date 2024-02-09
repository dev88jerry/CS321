package simulation;

/**
 * Name: Gregory Mierzwinski
 * Date: 03/15/2016
 * Description: Event for a teller departure.
 *
 * @author Gregory
 */

public class Teller_Depart extends Event {

	/**
	 * Constructor for departure at a given time.
	 * @param time Time of departure.
	 */
	public Teller_Depart(int time){
		this.time = time;
	}

	/**
	 * This takes the client out of the server, adds a new customer to the server if there is one, collects
	 * statistics and finally removes the client from the bank and collects bank-wide statistics.
	 */
	@Override
	void process() {
		//Set time
		Time.increaseTime(time);

		//Get client from the server and the stats for the server
		Server<Client> tellerQ = BankSim.getServers().getServer("Teller");
		Client leavingTeller = tellerQ.removeFromServer();
		Statistics stats = BankSim.getStats().getServerStatistics("Teller");

		//If the teller's queue is not empty
		if(!tellerQ.isEmpty()){
			//Set the next client in line to the server
			Client toTeller = tellerQ.removFromServerQ();
			toTeller.setEndTellerTime(time);
			tellerQ.setToServer(toTeller);

			//Gather statistics
			stats.addServerCustomer();
			stats.addTotalLength(tellerQ.getSize());

			//Waiting time = time exited - time entered
			int transTime = (int)RandBox.expo(toTeller.getNumOfTransactions()*2*bank.avgT());
			stats.addWaitingTime(toTeller.getEndTellerTime()-toTeller.getTellerTime());

			//Schedule the departure
			EventQueue.addEvent(new Teller_Depart(Time.getClock() + transTime));
		}
		//Gather more stats
		stats.addTotalTransTime(time - leavingTeller.getEndTellerTime());
		Statistics.addTotalCustomer();
		Statistics.addBankWaiting(Time.getClock()-leavingTeller.getTime());
	}

}
