package simulation;

import java.util.PriorityQueue;

/**
 * Name: Gregory Mierzwinski
 * Date: 03/15/2016
 * Description: This class is used as the event queue.
 *
 * @author Gregory
 */

public class EventQueue {

	//The event queue
	private static PriorityQueue<Event> eventQueue = new PriorityQueue<Event>();


	/**
	 * Get an event.
	 * @return The next event to process.
	 */
	public static Event getEvent(){
		return eventQueue.poll();
	}


	/**
	 * Add an event to the queue.
	 * @param e The event to be added.
	 */
	public static void addEvent(Event e){
		eventQueue.add(e);
	}
}


