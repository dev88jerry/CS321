package assign5;

/**
*
* Name: Gregory Mierzwinski
* Date: 04/04/2016
* Description: This is a class that represents cars that are bound for the Lion's.
*
* @author Gregory
*
*/

public class LionBound extends Car implements Runnable {
	//Bridge to cross
	private Bridge bridge;


	/**
	 * Constructor.
	 * @param b
	 */
	public LionBound(Bridge b){
		this.bridge= b;
	}


	/**
	 * Returns a string representation.
	 */
	@Override
	public String toString(){
		return "Lion's Bound";
	}


	/**
	 * Runs the car.
	 */
	@Override
	public void run() {
		while(true){
			try{
				//Sleep for a bit before starting
				long s = ((int)Math.random()*10)+1;
				Thread.sleep(s);

				//If there are no cars on the bridge or the opposite type of car is on the bridge, wait
				if(bridge.getTypeOnBridge() == null){
					bridge.getlBoundOnBridge().acquire();
				}
				else if(bridge.getTypeOnBridge() instanceof BishBound){
					bridge.getlBoundOnBridge().acquire();
				}

				//Get onto the bridge
				bridge.getOntoBridge(this);

				//Drive over it
				s = ((int)Math.random()*1)+1;
				bridge.outputBridge();
				Thread.sleep(s);

				//Get off the bridge
				bridge.getOffBridge(this);

				//If there are no other cars on the bridge, let the other side go through
				if(bridge.isEmpty()){
					bridge.getbBoundOnBridge().release();
				}
			}
			catch(InterruptedException e){

			}
		}
	}
}
