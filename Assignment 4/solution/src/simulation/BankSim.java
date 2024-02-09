package simulation;

/**
 * Name: Gregory Mierzwinski
 * Date: 03/15/2016
 * Description: This class will run the simulation of the servers.
 *
 * @author Gregory
 */

public class BankSim {

	//Used to hold the statistics of the run
	private static StatisticsContainer stats;

	//Used to hold the servers needed for the run
	private static ServerContainer<Client> servers;

	//Used to hold the interarrival time and avg time per transaction
	private final double INTERARRIVAL_TIME;

	private final double AVG_TIME_PER_TRNSACTION;


	/**
	 * Get the stats.
	 * @return StatisticsContainer
	 */
	public static StatisticsContainer getStats() {
		return stats;
	}


	/**
	 * Set the stats container.
	 * @param stats StatisticsContainer to use.
	 */
	public static void setStats(StatisticsContainer stats) {
		BankSim.stats = stats;
	}


	/**
	 * Get the servers from a container.
	 * @return ServerContainer
	 */
	public static ServerContainer<Client> getServers() {
		return servers;
	}


	/**
	 * Set the server container.
	 * @param servers ServerContainer to use.
	 */
	public static void setServers(ServerContainer<Client> servers) {
		BankSim.servers = servers;
	}


	/**
	 * Get the interarrival time.
	 * @return Interarrival time
	 */
	public double interA(){
		return INTERARRIVAL_TIME;
	}


	/**
	 * Get the average time per transaction.
	 * @return Avg time per transaction
	 */
	public double avgT(){
		return AVG_TIME_PER_TRNSACTION;
	}


	/**
	 * Constructor which initializes the servers, stats, and constants.
	 * @param interarrival	Interarrival time.
	 * @param avg_time		Avg time per transaction.
	 * @throws Exception	Thrown when interarrival < 1 or avg_time < 0.
	 */
	public BankSim(double interarrival, double avg_time) throws Exception{
		if((int)interarrival < 1) throw new Exception("Cannot have interarrival time that is less than 1.");
		if((int)avg_time < 0) throw new Exception("Cannot have avergae time per transaction less than 0.");
		this.INTERARRIVAL_TIME = interarrival;
		this.AVG_TIME_PER_TRNSACTION = avg_time;

		stats = new StatisticsContainer();
		stats.addStatistics("Receptionist");
		stats.addStatistics("Teller");

		servers = new ServerContainer<Client>();
		servers.addServer("Receptionist");
		servers.addServer("Teller");

		Event.addBankSim(this);
	}

	/**
	 * Run the simulation for time equal to simulation_time
	 * @param simulation_time Time to run for.
	 */
	public void run(int simulation_time){
		EventQueue.addEvent(new Bank_Arrival((int)RandBox.expo(INTERARRIVAL_TIME)));
		while(Time.getClock() < simulation_time){
			Event e = EventQueue.getEvent();
			e.process();
		}
		//Get Stats and print them
		stats.printStatisticsContainer();
	}

	public static void main (String[] args){
		try{
			BankSim s = new BankSim(120, 60);
			s.run(144000);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
