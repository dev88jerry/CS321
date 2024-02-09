package assign5;

/**
*
* Name: Gregory Mierzwinski
* Date: 04/04/2016
* Description: This is a class that represents cars that are bound for Bishop's.
*
* @author Gregory
*
*/

public class BishBound extends Car implements Runnable{
	//Bridge to cross
	private Bridge bridge;


	/**
	 * Constructor.
	 * @param b
	 */
	public BishBound(Bridge b){
		this.bridge = b;
	}


	/**
	 * Returns a string representation.
	 */
	@Override
	public String toString(){
		return "Bishop's Bound";
	}


	/**
	 * Runs the car.
	 */
	@Override
	public void run() {
		while(true){
			try{
				//Sleep for a bit before starting
				long s = ((int)Math.random()*1000)+1;
				Thread.sleep(s);

				//If there are no cars on the bridge or the opposite type of car is on the bridge, wait
				if(bridge.getTypeOnBridge() == null){
					bridge.getbBoundOnBridge().acquire();
				}
				else if(bridge.getTypeOnBridge() instanceof LionBound){
					bridge.getbBoundOnBridge().acquire();
				}

				//Get onto the bridge
				bridge.getOntoBridge(this);

				//Drive over it
				s = ((int)Math.random()*40)+1;
				bridge.outputBridge();
				Thread.sleep(s);

				//Get off the bridge
				bridge.getOffBridge(this);

				//If there are no other cars on the bridge, let the other side go through
				if(bridge.isEmpty()){
					bridge.getlBoundOnBridge().release();
				}
			}
			catch(InterruptedException e){

			}
		}
	}
}
