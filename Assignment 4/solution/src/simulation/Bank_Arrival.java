package simulation;

/**
 * Name: Gregory Mierzwinski
 * Date: 03/15/2016
 * Description: Event for initial bank arrival.
 *
 * @author Gregory
 */

public class Bank_Arrival extends Event{

	/**
	 * Constructs a bank arrival at the given time.
	 * @param time	Time of arrival
	 */
	public Bank_Arrival(int time){
		this.time = time;
	}


	/**
	 * Create a new receptionist arrival and a departure for the client being created.
	 */
	@Override
	public void process () {
		//Increase the time
		Time.increaseTime(time);

		//Create a new client and add it to the server
		Client newClient = new Client(time);
		newClient.setEndWait(time);
		BankSim.getServers().getServer("Receptionist").setToServer(newClient);

		//Set a departure and a new arrival then gather some stats
		int transTime = (int)RandBox.expo(newClient.getNumOfTransactions() * bank.avgT());
		EventQueue.addEvent(new Recep_Depart(Time.getClock() + transTime));
		EventQueue.addEvent(new Recep_Arrival(time + (int)RandBox.expo(bank.interA())));
		BankSim.getStats().getServerStatistics("Receptionist").addServerCustomer();
	}
}
