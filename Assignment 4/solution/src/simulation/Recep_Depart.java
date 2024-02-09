package simulation;

/**
 * Name: Gregory Mierzwinski
 * Date: 03/15/2016
 * Description: Event for a receptionist departure.
 *
 * @author Gregory
 */

public class Recep_Depart extends Event {

	/**
	 * Constructor for departure at a given time.
	 * @param time Time of departure.
	 */
	public Recep_Depart(int time){
		this.time = time;
	}

	/**
	 * This takes the client out of the server, adds a new customer to the server if there is one, collects
	 * statistics and finally adds the client to the teller.
	 */
	@Override
	void process() {
		//Set the time
		Time.increaseTime(time);

		//Get the server and remove the client
		Server<Client> recep = BankSim.getServers().getServer("Receptionist");
		Client toTeller = recep.removeFromServer();

		//Get the stats for the server
		Statistics stat = BankSim.getStats().getServerStatistics("Receptionist");

		//If the queue is not empty
		if(!recep.isEmpty()){
			//Add the next client in line to the server
			Client toRecep = recep.removFromServerQ();
			toRecep.setEndWait(time);
			recep.setToServer(toRecep);
			int transTime = (int)RandBox.expo(toRecep.getNumOfTransactions() * bank.avgT());
			//Gather stats
			stat.addServerCustomer();

			//Waiting time = time exited - time entered
			stat.addWaitingTime(toRecep.getEndWait() - toRecep.getTime());
			stat.addTotalLength(BankSim.getServers().getServer("Receptionist").getSize());

			//Schedule a departure
			EventQueue.addEvent(new Recep_Depart(Time.getClock() + transTime));
		}
		stat.addTotalTransTime(time - toTeller.getEndWait());
		//Schedule an arrival at the teller
		EventQueue.addEvent(new Teller_Arrival(Time.getClock(), toTeller));
	}

}
