package simulation;

/**
 * Name: Gregory Mierzwinski
 * Date: 03/15/2016
 * Description: Event for a receptionist arrival.
 *
 * @author Gregory
 */

public class Recep_Arrival extends Event {


	/**
	 * Constructs a receptionist arrival at the given time.
	 * @param time	Time of arrival
	 */
	public Recep_Arrival(int time){
		this.time = time;
	}


	/**
	 * This adds a client to the receptionist. If the receptionist is serving, then we add it to the queue.
	 * Finally, we schedule a new receptionist arrival and a new departure for the client.
	 */
	@Override
	public void process() {
		//Set the time
		Time.increaseTime(time);
		//Create a new client that has arrived at this time and get the server and server stats
		Client newClient = new Client(time);
		Server<Client> recep = BankSim.getServers().getServer("Receptionist");
		Statistics recepStats = BankSim.getStats().getServerStatistics("Receptionist");
		int transTime = (int)RandBox.expo(newClient.getNumOfTransactions() * bank.avgT());
		if (!recep.isServing()){ //If the receptionist is not serving
			//Set the client to the server and gather stats
			newClient.setEndWait(time);
			recep.setToServer(newClient);
			recepStats.addWaitingTime(0);
			recepStats.addServerCustomer();

			//Schedule a departure
			EventQueue.addEvent(new Recep_Depart(Time.getClock() + transTime));
		}
		else{ //Otherwise, we insert the client into the queue
			recep.insertIntoServerQ(newClient);
			recepStats.addTotalLength(recep.getSize());
		}
		//Create a new client arrival event at time = currentTime + RandomNumberGeneratedFrom[InterArrivalTime]
		EventQueue.addEvent(new Recep_Arrival(Time.getClock() + (int)RandBox.expo(bank.interA())));

	}

}
