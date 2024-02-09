package simulation;

import java.util.LinkedHashMap;

/**
 * Name: Gregory Mierzwinski
 * Date: 03/15/2016
 * Description: This class is used to contain the servers.
 *
 * @author Gregory
 */

public class ServerContainer<T> {

	//The hash table for the server container
	private LinkedHashMap<String, Server<T>> servers;


	/**
	 * Constructs a new hash table.
	 */
	public ServerContainer (){
		servers = new LinkedHashMap<String, Server<T>>();
	}


	/**
	 * Constructs new servers with the given names.
	 * @param serverNames
	 */
	public ServerContainer (String[] serverNames) {
		this();
		for (String name: serverNames){
			servers.put(name, new Server<T>(name));
		}
	}


	/**
	 * Add a new server with the given name.
	 */
	public void addServer (String name){
		servers.put(name, new Server<T>(name));
	}


	/**
	 * Get the server of the given name.
	 * @param name Name of the server.
	 * @return Server of the given name.
	 */
	public Server<T> getServer (String name){
		return servers.get(name);
	}

}
