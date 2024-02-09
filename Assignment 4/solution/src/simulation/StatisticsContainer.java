package simulation;

import java.util.LinkedHashMap;

/**
 * Name: Gregory Mierzwinski
 * Date: 03/15/2016
 * Description: This class is used to contain statistics on each server.
 *
 * @author Gregory
 */


public class StatisticsContainer {

	//Contains each statistic for the server of a given name
	private LinkedHashMap<String, Statistics> allStatistics;


	/**
	 * Constructor that creates the hash table.
	 */
	public StatisticsContainer (){
		allStatistics = new LinkedHashMap<String, Statistics>();
	}


	/**
	 * Constructs a container with statistics for servers of the given names.
	 * @param serverNames
	 */
	public StatisticsContainer (String[] serverNames) {
		this();
		for (String name: serverNames){
			allStatistics.put(name, new Statistics());
		}
	}


	/**
	 * Add a server statistics to the hash table.
	 * @param name
	 */
	public void addStatistics (String name){
		allStatistics.put(name, new Statistics());
	}


	/**
	 * Get the server statistics for the given server name.
	 * @param name Name of the server.
	 * @return Server statistics.
	 */
	public Statistics getServerStatistics (String name){
		return allStatistics.get(name);
	}


	/**
	 * Print the statistics container.
	 */
	public void printStatisticsContainer (){
		for (String key: allStatistics.keySet()){
			allStatistics.get(key).printStatistic(key);
			System.out.println("\n\n");
		}
		Statistics.printBankStatistic();
	}
}
