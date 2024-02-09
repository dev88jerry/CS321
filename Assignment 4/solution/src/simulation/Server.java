package simulation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Name: Gregory Mierzwinski
 * Date: 03/15/2016
 * Description: This class is used to represent the servers.
 *
 * @author Gregory
 */

public class Server <T> {

	//Server queue
	private Queue<T> clientQueue;

	//Object the server is serving
	private T server;

	//The name of the server
	private String name;


	/**
	 * Constructs a server with the given name.
	 * @param name Name of the server.
	 */
	public Server(String name){
		this.name = name;
		this.server = null;
		this.clientQueue = new LinkedList<T>();
	}


	/**
	 * Set the instance to the server.
	 * @param t_instance The instance to set the server to.
	 */
	public void setToServer(T t_instance){
		server = t_instance;
	}


	/**
	 * Insert an instance into the queue.
	 * @param t_instance Instance to insert.
	 */
	public void insertIntoServerQ(T t_instance){
		clientQueue.add(t_instance);
	}


	/**
	 * Remove an instance form the queue.
	 * @return Instance that was removed.
	 */
	public T removFromServerQ(){
		return clientQueue.poll();
	}


	/**
	 * Remove instance that is currently being served. Server is set to null after removal.
	 * @return Instance that was being served.
	 */
	public T removeFromServer(){
		T temp = server;
		server = null;
		return temp;
	}


	/**
	 * Get the current size of the queue.
	 * @return Size of the queue.
	 */
	public int getSize(){
		return this.clientQueue.size();
	}


	/**
	 * Returns whether or not the queue is empty.
	 * @return true/false empty/not-empty
	 */
	public boolean isEmpty(){
		return clientQueue.isEmpty();
	}


	/**
	 * Returns whether or not the server is serving.
	 * @return true/false serving/not-serving
	 */
	public boolean isServing(){
		return (server != null);
	}

}
